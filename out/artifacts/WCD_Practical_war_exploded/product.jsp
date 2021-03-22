<%--
  Created by IntelliJ IDEA.
  User: vanhv
  Date: 3/22/2021
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Product Page</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<jsp:useBean id="finder" class="com.example.model.ProductBean"/>
<h1 class="text-center">PRODUCT LIST</h1>
<br>
<a href="login?action=logout" class="btn btn-danger">Logout</a>
<table class="table table-stripped">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
    </tr>
    <c:forEach var="product" items="${finder.products}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.amount}"/></td>
            <td><c:out value="${product.details}"/></td>
        </tr>
    </c:forEach>

</table>
</body>
</html></html>
