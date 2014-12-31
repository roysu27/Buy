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
	</div>

</body>
</html>