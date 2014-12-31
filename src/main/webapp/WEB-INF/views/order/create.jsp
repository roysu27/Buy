<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
				<th>總金額</th>
				<td>${order.money}</td>
			</tr>
		</table>
		<p class="text-center">
			<a href="/Order/Confirm/${order.id}" class="btn btn-primary">確認訂單</a>
			<a href="/Order/Cancel/${order.id}" class="btn btn-primary">取消訂單</a>
		</p>
	</div>

</body>
</html>