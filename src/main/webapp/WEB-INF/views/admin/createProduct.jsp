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

	<form action="/Admin/SaveProduct" method="POST" class="form-signin">
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
	    <input type="text" name="productName" placeholder="商品名稱"><br>
	    <input type="text" name="price" placeholder="商品定價"><br>
	    <input type="text" name="off" placeholder="商品折扣">
		<span class="help-inline">填折扣%數。例：85折為85，8折為80。</span><br>
	    <input type="text" name="reserve" placeholder="庫存量"><br>
	    <button type="submit" class="btn btn-primary">建立</button>
	</form>

</body>
</html>