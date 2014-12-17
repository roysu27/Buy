<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy 管理後台</title>

    <link href="/resources/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/sitemesh/basic.css" rel="stylesheet">
    <link href="/resources/bootstrap/bootstrap-responsive.css" rel="stylesheet">
    
    <script src="/resources/js/jquery.min.js"></script>
</head>

<body>

	<%@include file="/WEB-INF/views/common/menu.jsp"%>

    <div class="container-fluid">
        <div class="row-fluid">
        
            <div class="span3">
                <div class="well sidebar-nav">
                    <ul class="nav nav-list">
                        <li class="nav-header">商品管理</li>
                        <li><a href="/Admin/CreateParentCategory">新增父類別</a></li>
                        <li><a href="/Admin/CreateChildCategory">新增子類別</a></li>
                        <li><a href="/Admin/CreateProduct">新增商品</a></li>
                        <li class="nav-header">Sidebar</li>
                        <li class="active"><a href="#">Link</a></li>
                        <li><a href="#">Link</a></li>
                        <li><a href="#">Link</a></li>
                        <li><a href="#">Link</a></li>
                        <li><a href="#">Link</a></li>
                        <li><a href="#">Link</a></li>
                        <li class="nav-header">Sidebar</li>
                        <li><a href="#">Link</a></li>
                        <li><a href="#">Link</a></li>
                        <li><a href="#">Link</a></li>
                    </ul>
                </div>
            </div>
            
            <div class="span9">
            	<decorator:body/>
            </div>
            
        </div>

        <hr>

        <footer>
            <p>&copy; Company 2013</p>
        </footer>

    </div>

    <script src="/resources/bootstrap/bootstrap.js"></script>


</body>
</html>