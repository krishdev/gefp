<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
     
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Runway</title>
<link href="../css/indexgefp.css" rel="stylesheet">
</head>
<body>
	
	<div class="center">
							<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">

	<div align="center">
    <img src="../images/header.png">
       
    <div  id="menu"> 
    <ul>
<li><a href="planHome.html">Home</a></li>
<li><a href="searchPlan.html?ok=VIEW&planid=${planid}">Back to Plan</a>
</li>
<li>
<a href="addOptions.html?btn=Stage&planid=${planid}">AddStage</a>
</li>
<li>
<a href="addCheckpoint.html?btn=Checkpoint&planid=${planid}"> Add Checkpoint</a>
</li>	
<li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
</ul>

    </div>
    </div>
    <div align="center">
   
    
    <!-- Runway -->
		<div class="padadd">
		 <h3><span> Edit Runway </span></h3>
    
    <div> 
					<c:choose>
						<c:when test="${empty error}">
						
						
						</c:when>
						<c:otherwise>
						<c:out value="${error}"/>
						</c:otherwise>
					</c:choose>
					
					</div>
	<c:forEach items="${runw}" var="runway">
		<form method="post" action="editrunway.html">

		<table>
			<tr>
				<td>
					Runway Name
				</td>
				<td>
					<input class="textadd" type="text" name="RName" value="${runway.RName }"/>
				</td>
			</tr>
			<tr>
			<td></td>
				<td><input type="hidden" name="planid" value="${planid}">
				<input type="hidden" name="rid" value="${runway.rid}">
					<input type="submit" style="padding: 4px 24px;" class="myaddButton" name="edit" value="Edit"/>
				</td>
			</tr>
		</table>
		</form>
	
	
	</c:forEach>

		</div>
	
	</div>

</security:authorize>
</div>
	
</body>
</html>