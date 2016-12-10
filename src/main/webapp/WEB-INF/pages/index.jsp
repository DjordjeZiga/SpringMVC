<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
    <title>Welcome to Java Spring MVC with Java Configuration</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="https://www.udemy.com/u/tunatore/">Udemy</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
                <li><a href="${pageContext.request.contextPath}">Promo</a></li>
            </ul>
            </div>
        </div>
    </nav>
<div class="container">
    <h1>Java Spring MVC (JavaConfig)</h1>
    <p>The same application provided by Spring MVC JavaConfig udemy course</p>
    <p>Welcome to Java Spring MVC with Java Configuration</p>

    <a href="${pageContext.request.contextPath}/displayUsers">Display users  with Embedded Database</a><br>
    <a href="${pageContext.request.contextPath}/displayUsersMySql">Display users with MySql Database</a><br>
    <a href="${pageContext.request.contextPath}/newblogpost.html">New blog post</a><br>
    <a href="${pageContext.request.contextPath}/blogposts">Blog posts</a><br>
    <a href="${pageContext.request.contextPath}/admin.html">Admin</a><br>


    <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
        <b>You are logged in as:</b><security:authentication property="principal.username"/>
        with the role of: <security:authentication property="principal.authorities"/>
    </security:authorize>
    </br>
    <a href="<c:url value="/logout"/>">Logout</a>
</div>

<footer class="panel-footer">
    <div class="container">
        <p class="text-muted"><b>Ziga 2016 Please feel free to ask me question by sending email to</b></p>
        <a href="<%=request.getContextPath()%>?language=en">EN</a>
        <a href="<%=request.getContextPath()%>?language=de">DE</a>

        <spring:message code="language"/>
        <font color="green"><b><spring:message code="welcome.text"/></b></font>
    </div>
</footer>
</body>
</html>
