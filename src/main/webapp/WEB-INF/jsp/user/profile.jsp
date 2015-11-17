<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link href="../css/indexgefp.css" rel="stylesheet">
<link href="../css/profile.css" rel="stylesheet">

</head>
<body>
<div class="center">
							<security:authorize access="hasRole('ROLE_STUDENT')">

    <div align="center">
    <img src="../images/header.png">
       
    <div  id="menu"> 
    <ul>
	<li>
			<a href="#">Home</a>
			<ul>
				<security:authorize access="hasRole('ROLE_ADVISOR')">
				<li>
				<a href="/gefp/advi/advisor.html">Advisor</a>
				</li> 
				</security:authorize>
				<security:authorize access="hasRole('ROLE_STUDENT')">
				<li>
				<a href="viewPlan.html">Student</a>
				</li>
				</security:authorize>
			</ul>
		</li>

<li></li><li><a href="#">PROFILE</a></li><li></li><li></li>	
<li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
</ul>

    </div>
    </div>
    <br/><br/><br/>
<div style="margin-left: 12%" class="profile">
<div align="right"><a href="editProfile.html">Edit</a></div>
	<table>
	<tr><!-- Name -->
	<td>
	<span class="txt">Name</span>
	</td>
	<td>
	<span class="txt">${usern.name} </span>
	</td>
	</tr>
	
	<tr><!-- CIN -->
	<td>
	<span class="txt">CIN</span>
	</td>
	<td>
	<span class="txt">${usern.cin} </span>
	</td>
	</tr>
	
	<tr><!-- Department -->
	<td>
	<span class="txt">DEPARTMENT</span>
	</td>
	<td>
	<span class="txt"> ${usern.major.departmentName}</span>
	</td>
	</tr>
	
	<tr><!-- Email -->
	<td>
	<span class="txt">EMAIL</span>
	</td>
	<td>
	<span class="txt">${usern.email} </span>
	</td>
	</tr>
	
	<tr><!-- Phone -->
	<td>
	<span class="txt">PHONE NUM</span>
	</td>
	<td>
	<span class="txt">${usern.phno} </span>
	</td>
	</tr>
	
	<tr><!-- City -->
	<td>
	<span class="txt">CITY</span>
	</td>
	<td>
	<span class="txt">${usern.city} </span>
	</td>
	</tr>
	
	
	
	</table>
</div>
</security:authorize>
</div>	
</body>
</html>