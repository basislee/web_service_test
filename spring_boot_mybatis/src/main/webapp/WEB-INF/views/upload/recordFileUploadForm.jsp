<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>녹음 오디오 파일 업로드</title>
		<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
		<script src="<c:url value='/js/recordFileUpload.js'/>"></script>
	</head>
	<body>
		<h3>녹음 파일 업로드</h3>
		<button id="recordBtn">녹음</button>
		<button id="stopBtn">정지</button>
		<br><br>
		
		<!-- 녹음 파일 플레이 -->
		<h3>녹음 파일 플레이</h3>
		<div id="audioBox"></div>
		
		<br><br>
		  <!--  index 페이지로 이동 링크 추가 -->
		<a href="<c:url value='/' />">홈으로 이동</a>
	</body>
</html>