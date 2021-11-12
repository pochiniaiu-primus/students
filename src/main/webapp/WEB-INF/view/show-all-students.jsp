<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<h2>All Students</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>URL</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="stud" items="${allStudents}">
        <c:url var="updateButton" value="/updateInfoAboutStudent">
            <c:param name="studId" value="${stud.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteInfoAboutStudent">
            <c:param name="studId" value="${stud.id}"/>
        </c:url>
        <tr>
            <td>${stud.name}</td>
            <td>${stud.surname}</td>
            <td>${stud.url}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href='${updateButton}'"/>
                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add"
       onclick="window.location.href='addNewStudent'"

/>
</body>
</html>