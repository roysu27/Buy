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
		<form action="/Product/Search" method="POST" class="form-search">
			<input type="text" name="searchStr" class="input-medium search-query">
			<button type="submit" class="btn">搜尋</button>
		</form>
	</div>
	
	<div>
		<table class="table table-bordered table-hover">
			<tr>
				<th>商品編號</th>
				<th>商品名稱</th>
				<th>購物車</th>
			</tr>
			<c:forEach var="product" items="${requestScope.productList}">
				<tr>
					<td>${product.id}</td>
					<td><a href="/Product/Detail/${product.id}">${product.name}</a></td>
					<td><a href="/User/Cart/Add/${product.id}">加入</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>