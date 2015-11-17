<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advisor Home</title>
<link href="../css/indexgefp.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
  
<script type="text/javascript">
$(function() {
	
			$("#tip").autocomplete({
			    source: "<c:url value='autocomplete.html'/>",
			    select: function(event, ui) {
		            if( ui.item )
		                window.location.href = "<c:url value='advisorPlan.html'/>?stuid=" + ui.item.id;
		                
		        }
			});
});

</script>
<style type="text/css">

</style>
</head>
<body>
	<div class="center">
							<security:authorize access="hasRole('ROLE_ADVISOR')">

	<div align="center">
    <img src="../images/header.png">
        
   
    <div  id="menu"> 
    <ul>
	<li>
			<a href="#">Home</a>
			<ul>
				<security:authorize access="hasRole('ROLE_ADVISOR')">
				<li>
				<a href="#">Advisor</a>
				</li> 
				</security:authorize>
			
				<security:authorize access="hasRole('ROLE_STUDENT')">
				<li>
				<a href="/gefp/user/viewPlan.html">Student</a>
				</li>
				</security:authorize>
			</ul>
		</li>
		<li></li><li></li>
<li></li><li></li><li></li><li></li><li></li><li></li>	
<li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
</ul>

    </div>
    </div>
    <div style="margin-left:20%">
    <h4 align="left">Welcome <security:authentication property="principal.name" /> </h4> 
			<br/>
			<br/>
		<div>
			<form action="advisor.html" method="post">
		Search User: <input id="tip" type="text" name="term"> <input type="submit" class="myButton" name="search" value="Search">
		</form>
		</div>
		${error}
		<br/><br/>
		
		
		
	
	</div>
	</security:authorize>
	</div>
	
</body>
</html>