<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Loo9</title>
<link href="${rootPath}/static/css/index.css?ver=2020-09-29"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	// js파일에서 ${rootPath}값을 참조하기 위해서 rootPath를 전역변수로 선언
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/main-nav.js?ver=2020-09-29"></script>
</head>
<body>
	<header>
		<h1>Loo9</h1>
	</header>
	<nav id="main-nav">
		<ul>
			<li id="menu-home">Loo9</li>
			<li id="menu-list">list</li>
			<li id="menu-add-list">add</li>
		</ul>
	</nav>
	<section id="main-section">
	<c:choose>
		<c:when test="${BODY == 'IO-LIST'}">
			<%@ include file="/WEB-INF/views/products/io-list.jsp" %>
		</c:when>
	</c:choose>	
	</section>
	<footer>
		<address>&copy; shju0317@naver.com 2020</address>
	</footer>
</body>
</html>
