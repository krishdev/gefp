<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Flight Plan</title>
<link href="../css/indexgefp.css" rel="stylesheet">
<style type="text/css">
p{
display:inline;
}
</style>
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">

 function togglechecptn( chkptid, uid ){ 
    $.ajaxSetup({ cache: false });
    $("#chkptids-" + chkptid).load("<c:url value='addchkptuser.html?chkptid=" + chkptid + "&uid=" + uid + "' />");   
}
</script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
</head>
<body>

<div class="center">
   
    <div align="center">
    <img src="../images/header.png">
       
    <div  id="menu"> 
    <ul>

<li>
			<a href="#">Home</a>
			<ul>
				<security:authorize access="hasRole('ROLE_ADVISOR')">
				<li>
				<a href="advisor.html">Advisor</a>
				</li> 
				</security:authorize>
			
				<security:authorize access="hasRole('ROLE_STUDENT')">
				<li>
				<a href="/gefp/user/viewPlan.html">Student</a>
				</li>
				</security:authorize>
			</ul>
		</li><li></li><li></li>
<li>
</li><li></li><li></li>
<li></li><li></li>	
<li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
</ul>

    </div>
    </div>
    <br/><br/><br/>
     <div style="margin-left:10%;width:100%">
     ${u.name}<br/>
     ${u.major.departmentName} : ${u.plan.name}
	<table id="pland">
	<tr>
		<th>
		</th>
		
		<c:forEach items="${planrunwaydetails}" var="planrunwaydetail">
		<th>
		
		${planrunwaydetail.RName}
		</th>
		
		</c:forEach>
		</tr>
		
	<tbody id="sortable">
	<c:forEach items="${planstagedetails}" var="planstagedetail">
		
		<tr>
		
			<td >
				<h3> ${planstagedetail.SName}</h3>
			</td>						
			<c:forEach items="${planrunwaydetails}" var="planrunwaydetail">
			
			
			<td>
				<c:forEach items="${cells}" var="cell">
				<c:if test="${planstagedetail.sid eq cell.sid}">
			<c:if test="${planrunwaydetail.rid eq cell.runid}">
				
				<c:choose>
				<c:when test="${cell.chkuser ne cell.chkid}">
				<input type="checkbox" id="chkptids-${cell.chkid}"  onclick="javascript:togglechecptn(${cell.chkid},${u.id})" value="${cell.chkid}">
				</c:when>
				<c:otherwise>
				<input type="checkbox" id="chkptids-${cell.chkid}" checked="checked" onclick="javascript:togglechecptn(${cell.chkid},${u.id})" value="${cell.chkid}">
				</c:otherwise>
				</c:choose>
				
				
				<span>
					${cell.chkpt}<br/>
					
				</span>
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

<br/>

</div>		

</body>
</html>