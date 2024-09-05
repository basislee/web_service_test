<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>전제 상품 조회</title>		 
	</head>
	<body>
		<h3>전체 상품 조회</h3>		
		<table border="1" width="600">
			<table border="1" width="600">
			<tr><th>상품번호</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>제조사</th>
			<th>재고</th>
			<th>제조일</th>
			<th>사진</th></tr>
			
			<!-- 반복문 사용해서 모든 데이터 출력 -->
			<!-- 상품번호에 링크 설정 : /product/detailViewProduct -->
			<!-- 날짜 포맷 설정 : 2024-05-10 형식 -->
			<c:forEach items="${ prdList }" var="prd">
			<tr>
				<td><a href="<c:url value='/product/detailViewProduct/${prd.prdNo}' />">${prd.prdNo}</a></td>
				<td>${prd.prdName}</td>
				<td>${prd.prdPrice}</td>
				<td>${prd.prdCompany}</td>
				<td>${prd.prdStock}</td>
				<td><fmt:formatDate value="${prd.prdDate}" pattern="YYYY-MM-dd" /></td>
				<td>
					<img alt="<c:url value='/prd_images/${prd.prdNo}.jpg'/>" src="<c:url value='/prd_images/${prd.prdNo}.jpg'/>" width="30" height="20">
					<!-- 또는  -->
					<img src="/prd_images/${prd.prdNo}.jpg" width="30" height="20">
				</td> 
			</tr>
			</c:forEach>			
		</table><br><br>
		
		<!--  index 페이지로 이동 링크 추가 -->
		<a href="<c:url value='/' />">홈으로 이동</a>
	</body>
</html>