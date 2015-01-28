<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>
    
	<div class="page-header">
		<h1>購物車 <small>可由此檢視您的購買清單</small></h1>
	</div>
	
	<div>
		<form action="/User/Buy" method="POST">
			<input type="hidden" name="rToken" value="${requestScope.rToken}">
			<table class="table table-bordered table-hover">
				<tr>
					<th>商品編號</th>
					<th>商品名稱</th>
					<th>價格</th>
					<th class="span2">數量</th>
					<th>功能</th>
				</tr>
				<c:forEach var="product" items="${requestScope.productList}">
					<input type="hidden" name="productIdArray" value="${product.id}">
					<tr>
						<td>${product.id}</td>
						<td><a href="/Product/Detail/${product.id}">${product.name}</a></td>
						<td>${product.discountsPrice}</td>
						<td><input type="text" name="prductQuantityArray" class="span6" value="1"></td>
						<td><a href="/User/Cart/Delete/${product.id}">移除</a></td>
					</tr>
				</c:forEach>
			</table>
			<p class="text-center">
				<button type="submit" class="btn btn-primary">購買</button>
			</p>
		</form>
	</div>
	
</body>
</html>