<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>

	<table class="table table-bordered span5">
		<tr>
			<th class="span2">商品編號</th>
			<td class="span4">${product.id}</td>
		</tr>
		<tr>
			<th>商品名稱</th>
			<td>${product.name}</td>
		</tr>
	</table>

</body>
</html>