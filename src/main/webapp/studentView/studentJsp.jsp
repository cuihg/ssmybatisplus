<%--
  Created by IntelliJ IDEA.
  User: cuihg
  Date: 2020/11/2
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>学生管理</title>
    <%--bootstrap美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        "use strict";

        function allchecked() {
            var box=document.getElementsByName("Batches");
                for(var i=0;i<box.length;i++){
                    box[i].checked=!box[i].checked;
                }
        }

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
</head>
<meta name="referrer" content="never">
<body>
<div class="container">
    <div class="row clearfix"><%--清除浮动--%>
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>学生管理</small>
                </h1>
            </div>
        </div>
    </div>

    <div align="center" class="form-group">

        <form action="/selectStudentMethod" method="post">
            姓名：<input type="text" name="name">
            专业：<input type="text" name="specialty">

            性别：<select name="sex">
                    <option value="0">-请选择-</option>
                    <option value="F">女</option>
                    <option value="M">男</option>
                 </select>

            班级：<select name="class_id" id="course" ></select>

            <input type="submit" value="查询" >
        </form>

    </div>
    <button ><a href="/studentView/addStudent.jsp" >添加</a></button>
    <%--<input type="hidden" name="method" value="DELETE">--%>
    <form action="/deleteBatches" method="post">
        <table border="2" align="center" class="table table-hover table-striped">
            <tr>
                <td><input type="checkbox" onclick="allchecked()">全选</td>
                <td>学号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>生日</td>
                <td>班级</td>
                <td>专业</td>
                <td>图片</td>
                <td>奖学金</td>
                <td>可操作</td>
            </tr>

            <c:forEach varStatus="sta" var="stu" items="${list}">
                <tr>
                   <td><input type="checkbox" name="Batches" value="${stu.stu_id}"></td>
                   <td>${sta.index+1}</td>
                   <td>${stu.name}</td>
                   <td>${stu.sex=='F'?'女':'男'}</td>
                   <td>${stu.birthday}</td>
                   <td>${stu.course.cname}</td>
                   <td>${stu.specialty}</td>
                   <td><img src="${pageContext.request.contextPath}/image2.0/${stu.image}" style="width: 40px ;height: 40px"></td>
                   <td>${stu.scholarship}</td>
                   <td><a href="${pageContext.request.contextPath}/selectStudentById?stu_id=${stu.stu_id}">修改</a>
                          |<a href="${pageContext.request.contextPath}/deleteStudent?stu_id=${stu.stu_id}">删除</a></td>
                </tr>
            </c:forEach>

                    <a href="${pageContext.request.contextPath }">首页</a>
                    <a href="${pageContext.request.contextPath }">上一页</a>
                    <a href="${pageContext.request.contextPath }">下一页</a>
                    <a href="${pageContext.request.contextPath }">尾页</a>
        </table>
        <input type="submit" value="批量删除">
    </form>
</div>
</body>
</html>
