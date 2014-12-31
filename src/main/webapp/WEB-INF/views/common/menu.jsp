<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="/">Buy</a>
            <div class="nav-collapse collapse">
                <p class="navbar-text pull-right">
                	<c:choose>
                		<c:when test="${sessionScope.validUser != null}">
                			歡迎你，${sessionScope.validUser.name}。
                    		<a href="/User/Logout" class="navbar-link">登出</a>
                		</c:when>
                		<c:otherwise>
                    		<a href="/Login/Form" class="navbar-link">登入</a>
                		</c:otherwise>
                	</c:choose>
                </p>
                <ul class="nav">
                    <li class="active"><a href="/">首頁</a></li>
                	<c:choose>
                		<c:when test="${sessionScope.validUser != null}">
		                    <li><a href="/Admin/Home">管理後台</a></li>
		                    <li class="dropdown">
		                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">會員管理 <b class="caret"></b></a>
		                        <ul class="dropdown-menu">
		                            <li><a href="/User/ChangePassword/Form">修改密碼</a></li>
		                        </ul>
		                    </li>
		                    <li><a href="/Order/List">訂單管理</a></li>
		                    <li><a href="/User/Cart/List">購物車</a></li>
                		</c:when>
                		<c:otherwise>
                    		<li><a href="/Register/Form">註冊</a></li>
                		</c:otherwise>
                	</c:choose>
                </ul>
            </div>
        </div>
    </div>
</div>