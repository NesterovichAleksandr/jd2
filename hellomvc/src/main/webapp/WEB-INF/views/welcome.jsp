<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<a>welcome jsp</a>
<a>${greeting}</a>
<br/>
<table>
    <tbody>
    <c:forEach items="${departments}" var="department">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/hellomvc/welcome/add.html">Add new department</a>
</body>
</html>
