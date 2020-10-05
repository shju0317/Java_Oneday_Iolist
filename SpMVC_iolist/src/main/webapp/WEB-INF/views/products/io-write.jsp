<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>   
<link href="${rootPath}/static/css/io-write.css?ver=2020-10-05" rel="stylesheet"> 
<script src="${rootPath}/static/js/io-write.js?ver=2020-10-05-001"></script>
<form:form id="products" modelAttribute="productVO">
	<fieldset>
		<legend>상품정보 입력</legend>	

		<div><label for="io_date">일자</label>
		<form:input path="io_date" placeholder="일자"/>
		</div>
		
		<div><label for="io_time">시각</label>
		<form:input path="io_time" placeholder="시각"/>
		</div>
		
		<div><label for="io_pname">상품명</label>
		<form:input path="io_pname" placeholder="상품명"/>
		</div>
		
		<div><label for="io_inout">구분</label>
		<form:input path="io_inout" placeholder="구분(i/o)"/>
		</div>
		
		<div><label for="io_price">단가</label>
		<form:input path="io_price" placeholder="단가"/>
		</div>
				
		<div><label for="io_quan">수량</label>
		<form:input path="io_quan" placeholder="수량"/>
		</div>
		
		<div class="button-box">
			<button id="btn-save" type="button">저장</button>
		</div>
		
	</fieldset>
</form:form>