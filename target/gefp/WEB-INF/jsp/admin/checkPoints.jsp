<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD Checkpoints</title>
<link href="../css/indexgefp.css" rel="stylesheet">
<script src="//cdn.ckeditor.com/4.4.7/standard/ckeditor.js"></script></head>
<body>
						<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">

<form action="addCheckpoint.html" method="POST">
	<div class="center">
		
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
<a href="addRunway.html?btn=Runway&planid=${planid}">AddRunway</a> 
</li>
<li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
</ul>

    </div>
    </div>
	<div class="padadd" align="center">
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
				Stage
				</td>
				<td>
					<select class="addoptiondropdown" name="stageid">
						<c:forEach items="${stages}" var="stage">
							<option value="${stage.sid}"><c:out value="${stage.SName}"/>
							</option>					
						</c:forEach>
					</select>
					<input type="hidden" name="planid" value="${planid}" />
					
				</td>
			</tr>
			<tr>
				<td>
				Runway
				</td>
				<td>
					<select class="addoptiondropdown" name="runwayid">
						<c:forEach items="${runways}" var="runway">
							<option value="${runway.rid}"><c:out value="${runway.RName}"/>
							
							</option>	
											
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
				CheckPoint
				</td>
				<td>
				<!-- <input class="textadd" type="text" name="chkptn"> -->
						<textarea name="chkptn"></textarea>
        <script>
            CKEDITOR.replace( 'chkptn' );
        </script>
				</td>
			</tr>
			<tr>
			<td>
			</td>
				<td>
					<input type="submit" name="add" value="ADD" class="myaddButton">
				</td>
			</tr>
		</table>
	</div>
	</div>
	
</form>
 </security:authorize>
</body>
</html>