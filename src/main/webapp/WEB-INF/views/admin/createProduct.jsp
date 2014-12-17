<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>
	<script src="/resources/js/admin/createProduct.js"></script>

	<form class="form-signin">
	    <h3 class="form-signin-heading">建立商品</h3>
	    <select name="parentCategory" id="parentCategory">
			<option value="0">請選擇父類別</option>
			<c:forEach var="category" items="${parentCategoryList}">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select><br>
	    <select name="childCategory" id="childCategory">
			<option value="0">請選擇子類別</option>
		</select><br>
	    <input type="text" placeholder="商品名稱"><br>
	    <button class="btn btn-primary" type="submit">建立</button>
	</form>

</body>
</html>