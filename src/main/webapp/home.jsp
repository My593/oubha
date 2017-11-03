<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/2
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>

    <script>
        <%--当选择部门的时候会执行--%>
        function onChange(value) {
            //  输出Value的值
            console.log(value)

            // 根据Value的值发送请求获取二级列表的json数据
            var data = new FormData();
            data.append("deptId", value);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    // 对请求回来的数据进行解析
                    json = eval('(' + this.responseText + ')');

                    // 获取服务器的标签
                    serverSelect = document.getElementById("post");

                    // 获取option标签
                    optionEle = serverSelect.getElementsByTagName("option");

                    // 获取option的数量
                    length = optionEle.length;

                    // 使用循环清空所有的option标签
                    for (var i = 0; i < length; i++) {
                        serverSelect.removeChild(optionEle[0])
                    }

                    serverSelect.innerHTML = "<option value = '-1'>--选择职位--</option>";

                    // 将json数据插入到option中
                    for (var i = 0; i < json.length; i++) {

                        //  创建一个option标签
                        option = document.createElement("option");

                        // 设置Value属性
                        option.setAttribute("value", json[i].id);

                        // 设置文本信息
                        text = document.createTextNode(json[i].name);

                        // 把文本信息添加到option标签中
                        option.appendChild(text);

                        // 把option标签添加到server的select中
                        serverSelect.appendChild(option)
                    }
                }
            });
            xhr.open("POST", "http://localhost:8080/getPosts");

            xhr.send(data);

        }
        function createTD(text) {
            var td = document.createElement("td");
            td.setAttribute("align", "center")
            var textNode = document.createTextNode(text);
            td.appendChild(textNode);
            return td;
        }


        function onStaffsQuery(value) {

            //当点击查询按钮的时候会执行
            //获取两个select选中时对应的value
            var deptId = document.getElementById("department").value;
            var postId = document.getElementById("post").value;
            var data = new FormData();
            data.append("deptId", deptId);
            data.append("postId", postId);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    json = eval('(' + this.responseText + ')');

                    var tableEle = document.getElementById("staff");
                    var length = tableEle.rows.length
                    for(var i = 0; i < length - 1; i++){
                        tableEle.deleteRow(1);
                    }

                    for (var i = 0; i < json.length; i++) {
                        var tr = document.createElement("tr");

                        tr.appendChild(createTD(json[i].id));
                        tr.appendChild(createTD(json[i].name));
                        tr.appendChild(createTD(json[i].gender));
                        tr.appendChild(createTD(json[i].age));
                        tr.appendChild(createTD(json[i].dept.name));
                        tr.appendChild(createTD(json[i].post.name));

                        tableEle.appendChild(tr);
                    }
                }
            });

            xhr.open("POST", "http://localhost:8080/staffJson");


            xhr.send(data);

        }

    </script>
</head>
<body>

<h1>欢迎进入本系统</h1>
部门:
<select id="department" onchange="onChange(value)" form="getStaffs" name="deptId">
    <option value="-1">----请选择----</option>
    <s:iterator value="departments" var="dept">
        <option value="${dept.id}">${dept.name}</option>
    </s:iterator>
</select>

职位:
<select id="post" form="getStaffs" name="postId">

    <option value="-1">--选择职位--</option>
</select>

<form action="staffs.action" method="get" id="getStaffs">
    <input type="submit" value="新页面查询">
</form>

<button onclick="onStaffsQuery()">查询员工</button>

<table border="1" id="staff">

    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>部门</th>
        <th>职位</th>
    </tr>
</table>



</body>
</html>
