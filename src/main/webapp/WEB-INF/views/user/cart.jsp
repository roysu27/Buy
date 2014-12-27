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
		<table class="table table-bordered table-hover">
			<tr>
				<th class="span2">商品編號</th>
				<th class="span4">商品名稱</th>
				<th class="span2">功能</th>
			</tr>
			<c:forEach var="product" items="${requestScope.productList}">
				<tr>
					<td>${product.id}</td>
					<td><a href="/Product/Detail/${product.id}">${product.name}</a></td>
					<td><a href="/User/Cart/Delete/${product.id}">移除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>