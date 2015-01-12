<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>
    <script src="/resources/js/order/list.js"></script>
    
	<div class="page-header">
		<h1>訂單管理 <small>可由此檢視您的訂單狀態</small></h1>
	</div>
	
	<table class="table table-bordered table-hover">
		<tr>
			<th>訂單編號</th>
			<th>價格</th>
			<th>訂單狀態</th>
			<th>付款狀態</th>
		</tr>
		<c:forEach var="order" items="${orderList}">
			<tr class="order" id="${order.id}">
				<td>${order.id}</td>
				<td>${order.money}</td>
				<td>
					<c:choose>
						<c:when test="${order.state == 0}">訂單建立</c:when>
						<c:when test="${order.state == 1}">訂單確認</c:when>
						<c:when test="${order.state == 2}">撿貨中</c:when>
						<c:when test="${order.state == 3}">理貨中</c:when>
						<c:when test="${order.state == 4}">已出貨</c:when>
						<c:when test="${order.state == 5}">已送達</c:when>
						<c:when test="${order.state == 6}">訂單取消</c:when>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${order.pay}">已付款</c:when>
						<c:otherwise>未付款</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<fmt:parseNumber var="totalPage" type="number" value="${(orderTotal + 9) / 10}"/>
	<c:set var="locationPage" value="${requestScope.locationPage}"/>
	
	共有${orderTotal}筆訂單資料。<br>
	第${locationPage}頁/共${totalPage}頁
	
	<div class="pagination">
		<ul>
			<c:choose>
				<c:when test="${locationPage - 1 == 0}">
					<li class="disabled"><a>«</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/Order/List/${page - 1}">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="page" begin="1" end="${(orderTotal + 9) / 10}">
				<c:choose>
					<c:when test="${page == locationPage}">
						<li class="active"><a>${page}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/Order/List/${page}">${page}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${locationPage == totalPage}">
					<li class="disabled"><a>»</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/Order/List/${page + 1}">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

</body>
</html>