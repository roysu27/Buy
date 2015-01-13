<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>

	<div class="span8 offset2">
		<table class="table table-bordered">
			<tr>
				<th class="span2">訂單編號</th>
				<td class="span6">${order.id}</td>
			</tr>
			<tr>
				<th>訂單金額</th>
				<td>${order.money}</td>
			</tr>
		</table>
		<table class="table table-bordered">
			<tr>
				<th class="span2">商品編號</th>
				<th class="span4">商品名稱</th>
				<th class="span2">商品價格</th>
			</tr>
			<c:forEach var="product" items="${productList}">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.discountsPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>