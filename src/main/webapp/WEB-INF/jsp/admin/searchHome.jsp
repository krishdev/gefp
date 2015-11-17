<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator-View-Department Plan</title>

<link rel="stylesheet" type="text/css" href="//rawgithub.com/akottr/dragtable/master/dragtable.css" />

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
<script src="//rawgithub.com/akottr/dragtable/master/jquery.dragtable.js"></script>


<link href="../css/indexgefp.css" rel="stylesheet">
 <!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script> -->
<style type="text/css">
p{
display: inline;
}
th{
cursor: default;
}
</style>
<script type="text/javascript">
function togglechecptn( cellid ,planid){ 
    /* $.ajaxSetup({ cache: false }); */
    $.ajax({
						        	
						            url:   "removeCheckpoint.html",
						            type: "POST",
						            data: {
						                "planid" : planid,
						                "cellid" : cellid
						            },
    								success:function() {
    						            //... your other code
    						            location.reload(); //reload the page on the success
    						        }
						        });
    
}
/* $(document).ready(function() {
	
    $('.defaultTable').dragtable({persistState: function(table) {
        table.el.find('th').each(function(i) {
            if(this.id != '') {table.sortOrder[this.id]=i;}
          });
          $.ajax({url: '/reoderRow?hello=world',
                  data: table.sortOrder});
        }
      });
}); */

$(document).ready(function(){
	$('.defaultTable').dragtable({persistState: function(table) { 

	table.el.find('th').each(function(i) { 
	     if(this.id != '') {table.sortOrder[this.id]=i;} 
	   });
	var newIndex = table.endIndex;/*alert{"${newIndex}"}*/
	var thlist = table.el.find('th');
	var jqth = $(thlist)[newIndex-1];
	var rid = $(jqth).attr("id");/*alert{"${rid}"}*/
	var newid = $(jqth).prop('id');
	           rid =  rid.substr(3);
	       $.ajax({
	             type: "POST",
	             url:  "reorderRunway.html",
	             data: {
	                   "planid" : "${flplanid}",
	                   "rid": newid,
	                   "newIndex" : newIndex-2
	               }/*success:function()*/
	             });  
	   }
	});
})
  </script>
</head>
<body>

	<div class="center">

    
   
	<div align="center">
    <img src="../images/header.png">
       
    <div  id="menu"> 
    <ul>
<li><a href="planHome.html">Home</a></li>
<li>
</li><li></li><li></li><li></li><li></li>	
<li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
</ul>

    </div>
    </div>
   
    <form:form commandName="storesForm" method="post">
    <div style="margin-left:10%;width:100%">
		<div>
		<br/>
		<br/>
		<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
		<a href="addOptions.html?btn=Stage&planid=${flplanid}"> Add Stage </a> | <a href="addRunway.html?btn=Runway&planid=${flplanid}"> Add Runway </a> | <a href="addCheckpoint.html?btn=Checkpoint&planid=${flplanid}"> Add Checkpoint</a>
		| <a href="editrunway.html?planid=${flplanid}"> <img alt="edit" src="../images/edit-icon.png" style="width:15px"/> Edit Runway </a>
		</security:authorize>
	<table id="pland" class="defaultTable">
		<thead>
		<tr>
		<th id="donot">
		</th>
		<c:forEach items="${planrunwaydetails}" var="planrunwaydetail">
		<th id="${planrunwaydetail.rid}">
		
		${planrunwaydetail.RName}		
		</th>
		</c:forEach>
		</tr>
		</thead>
		<tbody id="sortable" >
	<c:forEach items="${planstagedetails}" var="planstagedetail">
		
		<tr id="${planstagedetail.sid}">
		
	<td class="alt">
			<span style="font-size: 10pt;font-weight: bold;">${planstagedetail.SName}</span>
		<a style="font-size: 0.8em" href="editStage.html?sid=${planstagedetail.sid}&planid=${flplanid}"><img alt="edit" src="../images/edit-icon.png" style="width:15px"/> </a>
			</td>						
			<c:forEach items="${planrunwaydetails}" var="planrunwaydetail">
			
			
			<td>
				<c:forEach items="${cells}" var="cell">
				<c:if test="${planstagedetail.sid eq cell.sid}">
			<c:if test="${planrunwaydetail.rid eq cell.runid}">
				
				<!-- <table>
					<tr>
						<td align="center"> -->
						<input type="checkbox">
					<!-- 	</td>
						<td align="center"> -->
						${cell.chkpt}
						<!-- </td>
						<td align="center"> -->
						<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">

				<a href="editCheckpoint.html?cellid=${cell.cellid}&stageid=${cell.sid}&runwayid=${cell.runid}&planid=${flplanid}&chkid=${cell.chkid}"><img alt="edit" src="../images/edit-icon.png" style="width:15px"/></a>
				<%-- <input type="button" id="cellid-${cell.cellid}" onclick="javascript:togglechecptn(${cell.cellid},${flplanid})" value="r"> --%>
				<img alt="edit" src="../images/dlt.png" style="width:15px;cursor: pointer;" onclick="javascript:togglechecptn(${cell.cellid},${flplanid})"/><br/>
	</security:authorize>
		<!-- 				</td>
					</tr>
				</table> -->
							
				</c:if>
			</c:if>
			</c:forEach>
			</td>
			
			</c:forEach>					
		</tr>
			
		
	</c:forEach>
			</tbody>
	</table>
	</div>
	</div>
	</form:form>

	
	<!-- end -->
<script>
						$("#sortable td:first").addClass("first");
						$("#sortable td:last").addClass("last");
						$("#sortable").sortable({
						    update: function(event, ui) {
						        $.ajax({
						        	
						            url:   "reorderStage.html",
						            type: "POST",
						            data: {
						                "sid" : ui.item.context.id,
						                "planid" : "${flplanid}",
						                "newIndex" : ui.item.index()
						            } 
						        });
						    }
						});
						$( "#sortable" ).disableSelection();
						
			</script>
</div>
</body>
</html>