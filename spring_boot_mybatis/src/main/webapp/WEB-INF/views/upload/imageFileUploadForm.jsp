<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>이미지 파일 업로드 폼</title>
		<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
		<script src="<c:url value='/js/imageFileUpload.js'/>"></script>
	</head>
	<body>
		<h3>이미지 파일 업로드</h3>
		<form id="imageFileFrm" name="imageFileFrm">
			파일 : <input type="file" id="uploadFile" name=	"uploadFile"><br><br>
			<input type="submit" value="업로드">
		</form><br><br>
		
		<!-- 업로드한 이미지 출력 -->
		<h3>업로드한 이미지 보기</h3>
		<div id="imageBox">
			
		</div>
		
		<br><br>
		<a href="<c:url value='/' />">[홈으로 이동]</a>
	</body>
</html>