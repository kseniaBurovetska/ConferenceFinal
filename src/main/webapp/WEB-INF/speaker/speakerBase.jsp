<%--
  Created by IntelliJ IDEA.
  User: GlaDOS
  Date: 29 Mar 2019
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Speaker</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>

</head>

<body class="d-flex flex-column h-100">

<jsp:include page="../views/header.jsp"/>

<div class="container-fluid">

  <p class=" py-2 ml-3">I am a speaker</p>

</div>

<jsp:include page="../views/footer.jsp"/>

</body>
</html>
