<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<th>${order.id}</th>
				<th>${order.money}</th>
				<th>
					<c:choose>
						<c:when test="${order.state == 0}">訂單建立</c:when>
						<c:when test="${order.state == 1}">訂單確認</c:when>
						<c:when test="${order.state == 2}">撿貨中</c:when>
						<c:when test="${order.state == 3}">理貨中</c:when>
						<c:when test="${order.state == 4}">已出貨</c:when>
						<c:when test="${order.state == 5}">已送達</c:when>
						<c:when test="${order.state == 6}">訂單取消</c:when>
					</c:choose>
				</th>
				<th>
					<c:choose>
						<c:when test="${order.pay}">已付款</c:when>
						<c:otherwise>未付款</c:otherwise>
					</c:choose>
				</th>
			</tr>
		</c:forEach>
	</table>

</body>
</html>