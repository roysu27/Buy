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
    
    <script src="/resources/js/lib/jquery.min.js"></script>
</head>

<body>

	<%@include file="/WEB-INF/views/common/menu.jsp"%>

    <div class="container-fluid">
        <div class="row-fluid">
        
            <div class="span2">
                <div class="well sidebar-nav">
                    <ul class="nav nav-list">
                    	<c:forEach var="categoryMap" items="${requestScope.sidebar}">
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
            
            <div class="span8">
            	<decorator:body/>
            </div>
            
            <div class="span2">
				<p class="text-center">購物車</p>
				<table class="table table-striped">
					<c:choose>
						<c:when test="${empty cartList}">
							<tr><td><span class="text-center">購物車無商品。</span></td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="product" items="${cartList}">
								<tr><td>${product.name}</td></tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
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