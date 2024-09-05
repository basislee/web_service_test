<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일 업로드 결과</title>
	</head>
	<body>
			${originalFileName } 파일을 업로드 완료<br>
			C:\springWorkspace\upload 폴더에서 업로드된 파일 확인
			
			<br><br><br>
			<a href="<c:url value='/' />">[홈으로 이동]</a>
	</body>
</html>