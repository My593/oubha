<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/3
  Time: 上午9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>部门</th>
        <th>职位</th>
    </tr>

    <s:iterator value="staffs" var="staff">
        <tr>
            <td>${staff.id}</td>
            <td>${staff.name}</td>
            <td>${staff.age}</td>
            <td>${staff.gender}</td>
            <td>${staff.dept.name}</td>
            <td>${staff.post.name}</td>
        </tr>
    </s:iterator>




</table>

</body>
</html>
