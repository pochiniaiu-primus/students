<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new student</title>
</head>
<body>
<br>
<form:form action="saveStudent" modelAttribute="student">
    <form:hidden path="id"/>
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    URL <form:input path="url"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>