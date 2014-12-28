<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>
	
	<div>
		<form action="/User/Buy" method="POST">
			<table class="table table-bordered table-hover">
				<tr>
					<th>商品編號</th>
					<th>商品名稱</th>
					<th>價格</th>
					<th>功能</th>
				</tr>
				<c:forEach var="product" items="${requestScope.productList}">
					<input type="hidden" name="productIdArray" value="${product.id}">
					<tr>
						<td>${product.id}</td>
						<td><a href="/Product/Detail/${product.id}">${product.name}</a></td>
						<td>${product.price}</td>
						<td><a href="/User/Cart/Delete/${product.id}">移除</a></td>
					</tr>
				</c:forEach>
			</table>
			<button type="submit" class="btn btn-primary">購買</button>
		</form>
	</div>
	
</body>
</html>