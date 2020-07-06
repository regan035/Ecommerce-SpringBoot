<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="components/header.jsp"/>

<form action="login" method="post">
	<input type="email" name= "email" placeholder="Email">
	<input type="text" name= "password" placeholder="Password">
	<button type="submit">Submit</button>

</form>
</body>
</html>