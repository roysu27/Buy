<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy</title>

    <link href="/resources/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/sitemesh/basic.css" rel="stylesheet">
    <link href="/resources/bootstrap/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>

	<%@include file="/WEB-INF/views/common/menu.jsp"%>

    <div class="container-fluid">
        <div class="row-fluid">
        
            <div class="span3">
                <div class="well sidebar-nav">
                    <ul class="nav nav-list">
                    	<c:forEach var="categoryMap" items="${sessionScope.sidebar}">
                    		<%-- 父類別 --%>
                    		<li class="nav-header">${categoryMap.key.name}</li>
	                    	<c:forEach var="category" items="${categoryMap.value}">
	                    		<%-- 子類別 --%>
                        		<li><a href="/Product/List/${category.id}">${category.name}</a></li>
	                    	</c:forEach>
                    	</c:forEach>
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