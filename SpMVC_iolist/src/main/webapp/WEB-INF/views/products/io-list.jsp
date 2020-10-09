<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Loo9</title>
<link href="${rootPath}/static/css/io-list.css?ver=2020-10-09-001"
	rel="stylesheet">
<script>
$(function () {
	$("#delete").click(function(){
		if(confirm("정말 삭제할까요?")){
			document.location.href = "${rootPath}/products/delete?seq=${product.io_seq}"
		}
	})
	
	$("#update").click(function(){
		document.location.href="${rootPath}/products/update?seq=${product.io_seq}"
	})
});
</script>
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
			<th>매입합계</th>
			<th>매출합계</th>
			<th colspan=3></th>
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
						<c:choose>
							<c:when test="${product.io_inout == true}">
								<td>매입</td>
							</c:when>
							<c:otherwise>
								<td>매출</td>
							</c:otherwise>
						</c:choose>
						
						<td>${product.io_price}</td>
						<td>${product.io_quan}</td>
						
						<c:choose>
							<c:when test="${product.io_inout == true}">
								<td>${product.io_price*product.io_quan}</td>
							</c:when>
							<c:otherwise>
								<td>0</td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${product.io_inout== false}">
								<td>${product.io_price*product.io_quan}</td>
							</c:when>
							<c:otherwise>
								<td>0</td>
							</c:otherwise>
						</c:choose>

						<td></td>
						<td><a href="${rootPath}/products/update?seq=${product.io_seq}" id="update">수정</a></td>
						<td><a href="${rootPath}/products/delete?seq=${product.io_seq}" id="delete">삭제</a></td>
					</tr>
				
				<c:if test="${i.last}">
				<tr>
				<td colspan=7>  합계 </td>
				<td>${product.io_in_sum}</td>
				<td>${product.io_out_sum}</td>
				<td colspan=3></td>
				</c:if>
				</c:forEach>
				
			</c:otherwise>
		</c:choose>
	</table>
	<div id="io-link-box">
		<a href="${rootPath}/products/write">write</a>
	</div>
</body>
</html>