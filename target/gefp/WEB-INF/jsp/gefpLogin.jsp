<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
  <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/gefpstyle.css" rel="stylesheet">
</head>
<body>
	<form name="login" action="<c:url value='/j_spring_security_check' />" method="post">
	
	
		    <div style="width:100" class="container">
        <div class="center">
        <div class="topdiv"></div>
            <div class="innnerheader">
            <div style="height:25px"></div>
            <table width="90%" style="margin-left: 5%;">
            	<tr>
                	<td>
                    	<img src="images/csula-logo-linesm.png">
                    </td>
                    <td align="right">
                    	<h4 style="font-size:19px">California State University Los Angeles</h4>
                    </td>
                </tr>
            </table>
            
            </div>
            
            <div align="center"><h3> Golden Eagle Flight Plan - User Login</h3></div>
			<div class="logindiv">
			<div style="height:40px"></div>
				<table width="80%" style="margin-left:5%">
				<tr>
					<td>
					<span class="fontlogin">UserName</span>
					</td>
					<td>
					<input type="text" name="j_username" class="forminput" />
					<%-- <form:input path="username"/> --%>
					<div><%-- <form:errors path="username"/> --%></div>
					
					</td>
				</tr>
				<td> <div style="height:15px"></div></td>
				<td>				
				</td>
				<tr>
					<td>
					<span class="fontlogin">Password</span>
					</td>
					<td>
					 <input type="password" name="j_password" class="forminput" />
					<div></div>
					</td>
				</tr>
				<tr>
					<td> <div style="height:5px"></div></td><td><td/>
				</tr>
				<tr>
				<td>
				</td>
					<td>
					<input type="submit" class="myButton" name="login" value="Login"/>
					<div>
					<c:choose>
						<c:when test="${empty erroruser}">
						
						</c:when>
						<c:otherwise>
						<label>${erroruser}</label>
						</c:otherwise>
					</c:choose>
					</div>
					</td>
				</tr>
			</table>		
			</div>
        </div>
    </div>
</form>
</body>
</html>