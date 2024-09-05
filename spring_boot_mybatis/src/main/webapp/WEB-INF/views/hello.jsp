<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>hello</title>
	</head>
	<body>
		hello.jsp 페이지 <br>
		<p>${message }</p> 
		<img src="/image/apple.png"> <!-- / = static folder-->
		<img src="<c:url value='/image/apple.png' />">
	</body>
</html>