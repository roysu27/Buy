<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>
	<script src="/resources/js/admin/addProductImage.js"></script>

	<form action="/Admin/SaveProductImage" method="POST" enctype="multipart/form-data" class="form-signin">
	    <h3 class="form-signin-heading">新增商品圖片</h3>
	    <select name="parentCategory" id="parentCategory">
			<option value="0">請選擇父類別</option>
			<c:forEach var="category" items="${parentCategoryList}">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select><br>
	    <select name="childCategory" id="childCategory">
			<option value="0">請選擇子類別</option>
		</select><br>
	    <select name="productId" id="productId">
			<option value="0">請選擇商品</option>
		</select><br>
		<input type="file" name="file" id="file"><br>
	    <button type="submit" class="btn btn-primary" id="submit">新增</button>
	</form>

</body>
</html>