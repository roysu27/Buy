<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>

	<form class="form-signin">
	    <h3 class="form-signin-heading">建立商品</h3>
	    <select>
		  <option value="0">請選擇父類別</option>
		  <option>1</option>
		  <option>2</option>
		  <option>3</option>
		  <option>4</option>
		  <option>5</option>
		</select><br>
	    <select>
		  <option value="0">請選擇子類別</option>
		  <option>1</option>
		  <option>2</option>
		  <option>3</option>
		  <option>4</option>
		  <option>5</option>
		</select><br>
	    <input type="text" placeholder="商品名稱"><br>
	    <button class="btn btn-primary" type="submit">建立</button>
	</form>

</body>
</html>