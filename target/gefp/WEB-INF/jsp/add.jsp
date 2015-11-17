	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
<form:form modelAttribute="user">
	<div>
		<table>
		<tr>
			<td>
			Name
			</td>
			<td>
			<form:input path="name"/>
			</td>
		</tr>
		<tr>
			<td>
			Username
			</td>
			<td>
			<form:input path="username"/> <form:errors path="username"/>
			</td>
		</tr>
		<tr>
			<td>
			Password
			</td>
			<td>
			<form:input path="password"/> <form:errors path="password"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" name="add" value="Add">
			</td>
			</tr>
			</table>
	</div>
</form:form>
</body>
</html>