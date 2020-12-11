<%--
  Created by IntelliJ IDEA.
  User: cuihg
  Date: 2020/11/4
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>添加学生信息</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
    "use strict";
    $(function() {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath }/selectCourseAll',
            dataType:'json',
            contentType:'application/json',
            success:function (data) {
                var options="";
                options="<option value='0'>-请选择-</option>";
                for(var i=0;i<data.length;i++){
                    options+=("<option value='"+data[i].class_id+"'>"+data[i].cname+"</option>");
                }
                $('#course').html(options);
            }
        })
    })
</script>
<body>
    <div class="container" align="center">
        <form action="/addStudent" method="post" enctype="multipart/form-data">
            <div>
                姓名:<input type="text" name="name"><br>

                性别:<input type="radio" name="sex" value="M" checked>男
                     <input type="radio" name="sex" value="F">女<br>

                生日:<input type="date" name="birthday"><br>

                班级:<select name="class_id" id="course" ></select><br>

                专业:<input type="text" name="specialty"><br>

                <input type="file" name="img" value="选择图片"><br>

                奖金:<input type="text" name="scholarship"><br>

                     <input type="submit" value="添加">
            </div>
        </form>
    </div>
</body>
</html>
