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

	<form:form action="/User/ChangePassword/Save" method="POST" modelAttribute="changePasswordForm" class="form-signin">
	    <h2 class="form-signin-heading text-center">修改密碼</h2>
	    <form:password path="oldPassword" class="input-block-level" placeholder="舊密碼"/>
	    <form:password path="newPassword" class="input-block-level" placeholder="新密碼"/>
	    <form:password path="newPasswordCheck" class="input-block-level" placeholder="新密碼確認"/>
	    <%-- 如果驗證不通過, 顯示錯誤提示訊息 --%>
		<c:if test="${errorMessage != null}">
			<div class="text-center">
				<c:forEach var="message" items="${errorMessage}">
					<span class="text-error text-center">${message}</span><br>
				</c:forEach>
			</div>
		</c:if>
	    <input type="submit" value="送出" class="btn btn-large btn-block btn-primary">
	</form:form>

</body>
</html>