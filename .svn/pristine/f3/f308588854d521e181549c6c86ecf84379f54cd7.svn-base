<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users</title>
</head>
<body>

<table>
<th>ID</th><th>Name</th><th>Username</th><th>Password</th><th>Operations</th>
<c:forEach items="${users}" var="user">
  <tr><td>${user.id}</td>
  <td>${user.name}</td>
  <td>${user.username}</td>
  <td>${user.password}</td>
  <td><a href="view.html?id=${user.id}">View</a></td>
  <td><a href="viewPlan.html?id=${user.id}">View Plan</a></td>
 <td><a href="edit.html?id=${user.id}">Edit</a></td>
  </tr>
  </c:forEach>
</table>
   <td><a href="add.html">Add</a></td>

</body>
</html>