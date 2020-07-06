<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Spring MVC</title>
</head>
<body>

<a href="page?link=realestatesite&name=silloh">Page</a>

<a href="pathvar-realestatesite-silloh">Path Variable</a>
<jsp:include page="components/header.jsp"/>


<h2>Welcome to Spring MVC</h2>
<p>${msg}</p>
<br>
<form action="access" method="get">
	<input type="email" name= "email" placeholder="Email">
	<input type="text" name= "password" placeholder="Password">
	<button type="submit">Submit</button>

</form>
</body>
</html>