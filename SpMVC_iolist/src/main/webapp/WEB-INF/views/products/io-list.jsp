<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Loo9</title>
<link href="${rootPath}/static/css/io-list.css?ver=2020-09-29" rel="stylesheet">
<script src="${rootPath}/static/js/io-list.js?ver=2020-09-29"></script>
</head>
<body>
<table id="io-list">
	<tr>
		<th>SEQ</th>
		<th>일자</th>
		<th>시각</th>
		<th>상품명</th>
		<th>구분</th>
		<th>단가</th>
		<th>수량</th>
		<th>합계</th>
	</tr>
	<%
	// 서버로부터 데이터를 수신하여 데이터가 없으면 "데이터 없음"이라고 표시
	// 있으면 tr,td 리스트를 만들어서 데이터 표시
	%>
	<c:choose>
		<c:when test="${empty PRODUCTS}">
			<tr>
				<td colspan="8">데이터가 없음</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${PRODUCTS}" var="product" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${product.io_date}</td>
					<td>${product.io_time}</td>
					<td>${product.io_pname}</td>
					<td>${product.io_inout}</td>
					<td>${product.io_price}</td>
					<td>${product.io_quan}</td>
					<td>${product.io_total}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<div id="io-link-box">
	<a href="${rootPath}/products/add">add</a>
</div>	
</body>
</html>