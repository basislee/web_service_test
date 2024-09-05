<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 상세 정보 조회</title>
	</head>
	<body>
		 <h3>상품 상세 정보 조회</h3>
	     <table border="1" width="300">
				<tr><td>상품번호</td><td>${prd.prdNo }</td></tr>
				<tr><td>상품명</td><td>${prd.prdName }</td></tr>
				<tr><td>가격</td><td>${prd.prdPrice }</td></tr>
				<tr><td>제조회사</td><td>${prd.prdCompany }</td></tr>
				<tr><td>재고</td><td>${prd.prdStock }</td></tr>
				<tr><td>제조일</td>
				<td><fmt:formatDate value="${prd.prdDate }" pattern="YYYY-MM-dd" /></td></tr>
		</table><br><br>
	   
	    <a href="<c:url value='/product/updateProductForm/${prd.prdNo }'/>">[상품 정보 수정]</a><br>  
	    <a href="javascript:deleteCheck();">[상품 정보 삭제]</a><br> 
	    <!-- 삭제 확인 메시지 출력 -->
	    <script>
	    	function deleteCheck(){
	    		let answer = confirm("삭제하시겠습니까?");
	    		if(answer) {
	    			location.href = "/product/deleteProduct/${prd.prdNo}";
	    		}
	    	}
	    </script>
	    
	    <!--  index 페이지로 이동 링크 추가 -->
		<a href="<c:url value='/' />">[홈으로 이동]</a> <a href="<c:url value='/product/listAllProduct'/>">[전체 상품 조회]</a><br>
	</body>
</html>