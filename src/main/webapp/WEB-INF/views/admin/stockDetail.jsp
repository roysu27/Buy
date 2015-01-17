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
			<th>商品名稱</th>
			<th>庫存量</th>
		</tr>
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.name}</td>
				<td>${product.reserve}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>