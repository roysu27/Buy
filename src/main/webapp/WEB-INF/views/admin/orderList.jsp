<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>
	
	<table class="table table-bordered table-hover">
		<tr>
			<th>訂單編號</th>
			<th>價格</th>
			<th>訂單狀態</th>
			<th>付款狀態</th>
			<th>動作</th>
		</tr>
		<c:forEach var="order" items="${orderList}">
			<tr class="order" id="${order.id}">
				<td>${order.id}</td>
				<td>${order.money}</td>
				<td>
					<c:choose>
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
				<td>
					<c:choose>
						<c:when test="${order.state == 1}">
							<a href="/Admin/Order/UpdateState/Picking/${order.id}">訂單撿貨</a>
						</c:when>
						<c:when test="${order.state == 2}">
							<a href="/Admin/Order/UpdateState/Tally/${order.id}">訂單理貨</a>
						</c:when>
						<c:when test="${order.state == 3}">
							<a href="/Admin/Order/UpdateState/Shipping/${order.id}">商品出貨</a>
						</c:when>
						<c:when test="${order.state == 4}">
							<a href="/Admin/Order/UpdateState/Arrivals/${order.id}">商品送達</a>
						</c:when>
					</c:choose>
					<c:if test="${order.state != 5 && order.state != 6}">
						|
						<a href="/Admin/Order/UpdateState/Cancel/${order.id}">取消訂單</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>