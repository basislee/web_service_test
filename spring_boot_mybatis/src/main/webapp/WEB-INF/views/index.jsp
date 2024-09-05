<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index 페이지</title>
	</head>
	<body>
		<h3>Spring Boot - MyBatis 사용 DB 연동 : 상품 관리</h3><br>
		
		<a href="<c:url value='/product/listAllProduct'/>">전체 상품 조회</a><br>
		<a href="<c:url value='/product/newProductForm'/>">상품 등록</a><br>
		
		<!-- 이미지 출력 -->
		<img src="<c:url value='/image/apple.png'/>"> 
		<!-- 맵핑 이름 project_image 사용해서 이미지 출력 -->
		<%-- <img src="project_image/apple.png"> <!-- 주의: 맨 앞에 / 없음 -->
		<img src="<c:url value='/project_image/apple.png'/>">  --%>
		
		<h3>Ajax 연습</h3><br>
		<a href="<c:url value='/loginForm'/>">로그인</a><br>
		<a href="<c:url value='/loginForm2'/>">로그인2</a><br>
		
		<h3>상품 검색</h3>
		<a href="<c:url value='/product/productSearchForm1'/>">상품 검색1</a><br>
		<a href="<c:url value='/product/productSearchForm2'/>">상품 검색2</a><br>
		
		<h3>파일 업로드</h3>
		<a href="<c:url value='/fileUploadForm'/>">파일 업로드</a><br>
		
		<h3>파일 다운로드</h3>
		<a href="<c:url value='/fileDownloadList'/>">파일 다운로드</a><br>
		
		<h3>이미지 파일 업로드</h3>
		<a href="<c:url value='/imageFileUploadForm'/>">이미지 파일 업로드</a><br>
		
		<h3>오디오 파일 업로드</h3>
		<a href="<c:url value='/audioFileUploadForm'/>">오디오 파일 업로드</a><br>
		
		<h3>녹음 파일 업로드</h3>
		<a href="<c:url value='recordFileUploadForm'/>">녹음 파일 업로드</a><br>
	</body>
</html>



