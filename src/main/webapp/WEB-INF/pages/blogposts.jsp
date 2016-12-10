<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
    <title>Blog posts</title>
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
    <h1>Blog Posts</h1>

    <c:if test="${empty blogposts}">
        No blog posts is found<br>
    </c:if>

    <a href="${pageContext.request.contextPath}/">Back</a><br>

    <a href="${pageContext.request.contextPath}/newblogpost.html">Enter a New blog post</a><br>

    <form action="${pageContext.request.contextPath}/searchByTitle" method="post">
        <table>
            <tr><td>Blog Title:</td><td><input name="title" type="text"></td></tr>
            <tr><td colspan="2"><input type="submit" value="Search"></td><td></td></tr>
        </table>
    </form> <br>

    <a href="${pageContext.request.contextPath}/draftblogposts">Find a draft blog post</a>

    <c:if test="${not empty blogposts}">
        <table style="width: 650px" class="table ">
            <c:forEach var="blogpost" items="${blogposts}">
                <tr><td>Blog post id</td><td><c:out value="${blogpost.id}"/></td></tr>
                <tr><td>Title</td><td><c:out value="${blogpost.title}"/></td></tr>
                <tr><td>Content</td><td><div style="white-space: pre"><c:out value="${blogpost.content}"/></div></td></tr>
                <tr><td>Draft</td><td><c:out value="${blogpost.draft}"/></td></tr>
            </c:forEach>
        </table>
    </c:if>
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
