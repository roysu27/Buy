<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>

	<form action="/Admin/SaveParentCategory" method="POST" class="form-signin">
	    <h3 class="form-signin-heading">建立父類別</h3>
	    <input type="text" name="categoryName" placeholder="類別名稱"><br>
	    <button type="submit" class="btn btn-primary">建立</button>
	</form>

</body>
</html>