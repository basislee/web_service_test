<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>productForm</title>
		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
		<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
		<%-- <script src="<c:url value='/js/prdNoCheck.js'/>"></script> --%>
		<%-- <script src="<c:url value='/js/prdNoCheck1.js'/>"></script> --%>
		<%-- <script src="<c:url value='/js/prdNoCheck2.js'/>"></script> --%>
		<%-- <script src="<c:url value='/js/prdNoCheck3.js'/>"></script> --%>
		<%-- <script src="<c:url value='/js/prdNoCheck4.js'/>"></script> --%>
		<script src="<c:url value='/js/prdNoCheck5.js'/>"></script>
	</head>
	<body>
		<h3>상품 정보 등록</h3>
		<form method="post" action="<c:url value='/product/insertProduct'/>">
			<table>
				<tr><td>상품 번호</td><td><input type="text" name="prdNo" id="prdNo">
				        <button id="prdNoCheckBtn" name="prdNoCheckBtn">중복확인</button>
				</td></tr>
				<tr><td>상품명</td><td><input type="text" name="prdName"></td></tr>
				<tr><td>가격 </td><td> <input type="text" name="prdPrice"></td></tr>
				<tr><td>제조회사</td><td><input type="text" name="prdCompany"></td></tr>
				<tr><td>재고 </td> <td><input type="text" name="prdStock"></td></tr>
				<tr><td>제조일 </td> <td><input type="text" name="prdDate"></td></tr>
				<tr><td colspan="2"><input type="submit" value="등록">
				<input type="reset" value="취소"></td></tr>
			</table>
		</form>
	</body>
</html>