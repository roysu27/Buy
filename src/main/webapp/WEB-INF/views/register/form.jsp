<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
</head>

<body>

	<form:form action="/Register/Save" method="POST" modelAttribute="registerForm" class="form-signin">
	    <h2 class="form-signin-heading">會員註冊</h2>
	    <form:input path="account" class="input-block-level" placeholder="帳號"/>
	    <form:password path="password" class="input-block-level" placeholder="密碼"/>
	    <form:password path="passwordCheck" class="input-block-level" placeholder="密碼確認"/>
	    <form:input path="name" class="input-block-level" placeholder="姓名"/>
	    <form:input path="email" class="input-block-level" placeholder="Email"/>
	    <%-- 如果驗證不通過, 顯示錯誤提示訊息 --%>
		<c:if test="${errorMessage != null}">
			<div class="text-center">
				<c:forEach var="message" items="${errorMessage}">
					<span class="text-error text-center">${message}</span><br>
				</c:forEach>
			</div>
		</c:if>
	    <input type="submit" value="註冊" class="btn btn-large btn-primary">
	</form:form>

</body>
</html>