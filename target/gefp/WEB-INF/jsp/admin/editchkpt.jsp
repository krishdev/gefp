<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
            
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Checkpoint</title>
<link href="../css/indexgefp.css" rel="stylesheet">
<script src="//cdn.ckeditor.com/4.4.7/standard/ckeditor.js"></script></head>
</head>
<body>

<form action="editCheckpoint.html" method="post">
<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">

	<div class="center">
		
	<div align="center">
    <img src="../images/header.png">
       
    <div  id="menu"> 
    <ul>
<li><a href="planHome.html">Home</a></li>
<li><a href="searchPlan.html?ok=VIEW&planid=${planid}">Back to Plan</a>
</li><li></li><li></li><li></li><li></li>	
<li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
</ul>

    </div>
    </div>
	<div class="padadd" align="center">
	<h3>Edit CheckPoint</h3>
		<table>
			<tr>
				<td>
				Stage
				</td>
				<td>
					<select class="addoptiondropdown" name="stageid">
						<c:forEach items="${stages}" var="stage">
							<option value="${stage.sid}" ${stage.sid == stage_id ? 'selected="selected"':'' }><c:out value="${stage.SName}"/>
							</option>					
						</c:forEach>
					</select>
					
				</td>
			</tr>
			<tr>
				<td>
				Runway
				</td>
				<td>
					<select class="addoptiondropdown" name="runwayid">
						<c:forEach items="${runways}" var="runway">
							<option value="${runway.rid}" ${runway.rid == runwayid ? 'selected="selected"':'' }><c:out value="${runway.RName}"/>
							
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
<!-- 				<input type="text" class="textadd" name="cname" >
 -->								<textarea name="cname">
								${ckname}
								</textarea>
        <script>
            CKEDITOR.replace( 'cname' );
        </script>
				<input type="hidden" name="chkid" value="${chkid}"/>
				<input type="hidden" name="planid" value="${planid}"/>
				<input type="hidden" name="cellid" value="${cellid}"/>
				</td>
			</tr>
			<tr>
			<td></td>
				<td>
					<input type="submit" name="add" class="myaddButton" value="Edit">
				</td>
			</tr>
		</table>
	</div>
	</div>
	</security:authorize>
	
</form>
</body>
</html>