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

	<div class="span8 offset2">
		<table class="table table-bordered">
			<tr>
				<th class="span2">商品編號</th>
				<td class="span6">${product.id}</td>
			</tr>
			<tr>
				<th>商品名稱</th>
				<td>${product.name}</td>
			</tr>
			<tr>
				<th>商品定價</th>
				<td>${product.price}</td>
			</tr>
			<tr>
				<th>商品折扣</th>
				<td>${product.off}</td>
			</tr>
			<tr>
				<fmt:parseNumber var="price" type="number" value="${product.price * product.off / 100}" />
				<th>商品售價</th>
				<td>${price}</td>
			</tr>
			<tr>
				<th>商品庫存</th>
				<td>${product.reserve}</td>
			</tr>
		</table>
	</div>

</body>
</html>