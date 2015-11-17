<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Stage</title>
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
<a href="addRunway.html?btn=Runway&planid=${planid}">AddRunway</a>
</li>
<li>
<a href="addCheckpoint.html?btn=Checkpoint&planid=${planid}"> Add Checkpoint</a>
</li>	
<li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
</ul>

    </div>
    </div>


	<div align="center">
		
	
		<!-- Stage -->
		<div class="padadd">
		<h3><span> ADD STAGE </span></h3>
		<form action="existStages.html">
			<div>
					<c:choose>
						<c:when test="${empty error}">
						
						
						</c:when>
						<c:otherwise>
						<c:out value="${error}"/>
						</c:otherwise>
					</c:choose>
					</div>
		<table>
		
			<tr>
				<td>
				Add an exsisting Stage
				</td>
				<td><select class="addoptiondropdown" name="sid">
						<c:forEach items="${setofstg}" var="stage">
							<option value="${stage.sid}"><c:out value="${stage.SName}"/>
							
							</option>		
						</c:forEach>
					</select>
				
						
					
				</td>
			</tr>
			<tr>
			<td>
			</td>
				<td>
				<input type="hidden" name="planid" value="${planid}">
					<input type="submit" style=" padding: 4px 32px;" class="myaddButton" name="add" value="ADDStage"/>
				</td>
			</tr>
			
		</table>
		</form>
		<form method="post" action="addOptions.html">
		<table>
			<tr>
				<td>
					New Stage Name
				</td>
				<td>
					<input class="textadd" name="SName"/>
					
				</td>
			</tr>
			<tr>
			<td>
			</td>
				<td><input type="hidden" name="planid" value="${planid}">
					<input type="submit" style=" padding: 4px 32px;" class="myaddButton" name="add" value="ADDStage"/>
				</td>
			</tr>
		</table>
		</form>
		</div>
	
	</div>


   
</security:authorize>
</div>
</body>
</html>