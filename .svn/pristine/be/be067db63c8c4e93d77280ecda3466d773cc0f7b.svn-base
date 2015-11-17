<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<security:authorize access="not hasRole('ROLE_ADMINISTRATOR')">
	<security:authorize access="hasRole('ROLE_ADVISOR') and hasRole('ROLE_STUDENT')">
		<a href="/gefp/advi/advisor.html">Advisor Home</a>
		<br/>
		<a href="/gefp/user/viewPlan.html">Student Home</a>

	</security:authorize>
	<security:authorize access="not hasRole('ROLE_ADVISOR')">
		<security:authorize access="hasRole('ROLE_STUDENT')">
			<a href="/user/planHome.html">Student Home</a>

		</security:authorize>
		<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
			<a href="#">Administrator Home</a>

		</security:authorize>
	</security:authorize>
</security:authorize>

</body>
</html>