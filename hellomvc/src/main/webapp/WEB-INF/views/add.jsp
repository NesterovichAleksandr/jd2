<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<s:form action="" method="post" modelAttribute="department">
    <fieldset>
        <label for="name">Department name</label>
        <s:input path="name" id="name"/>
        <input type="submit" value="Submit"/>
    </fieldset>
</s:form>
</body>
</html>
