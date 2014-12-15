<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>

	<form action="/Admin/SaveChildCategory" method="POST" class="form-signin">
	    <h3 class="form-signin-heading">建立子類別</h3>
	    <select name="parentCategory">
			<option value="0">請選擇父類別</option>
			<c:forEach var="category" items="${parentCategoryList}">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select><br>
	    <input type="text" name="categoryName" placeholder="類別名稱"><br>
	    <button type="submit" class="btn btn-primary">建立</button>
	</form>

</body>
</html>