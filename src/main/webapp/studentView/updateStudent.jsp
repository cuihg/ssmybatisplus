<%--
  Created by IntelliJ IDEA.
  User: cuihg
  Date: 2020/11/5
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>修改学生信息</title>
    </head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript">

    $(function() {


        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath }/selectCourseAll',
            dataType:'json',
            contentType:'application/json',
            success:function (data) {
                var options="";
                var class_id1=$("#class_id1");
                for(var i=0;i<data.length;i++){

                    options+="<option "+(class_id1==data[i].class_id?'selected':'')+" value='"+data[i].class_id+"'>"+data[i].cname+"</option>";
                }
                $('#course').html(options);
            }
        })
    })
</script>
<body>
<div class="container" align="center">
    <form action="/upateStudent" method="post" enctype="multipart/form-data">
        <input type="hidden" value="${selectStuById.stu_id}" name="stu_id"/>
        <div>
            姓名:<input type="text" name="name" value="${selectStuById.name}"><br>

            性别:<input type="radio" name="sex" value="M" ${selectStuById.sex=='M'?'checked':''}>男
                <input type="radio" name="sex" value="F" ${selectStuById.sex=='F'?'checked':''}>女<br>

            生日:<input type="date" name="birthday" value="${selectStuById.birthday}"><br>

            班级:<select name="class_id" id="course">
            <option id="class_id1" value="${selectStuById.class_id}"></option>
            </select><br>

            专业:<input type="text" name="specialty" value="${selectStuById.specialty}"><br>

            <img src="${pageContext.request.contextPath}/image2.0/${selectStuById.image}" style="width: 40px ;height: 40px"><br>

            <input type="hidden" value="${selectStuById.image}" name="image">

            图片:<input type="file" name="img"><br>

            奖金:<input type="text" name="scholarship" value="${selectStuById.scholarship}"><br>
                <input type="submit" value="修改">

        </div>
    </form>
</div>
</body>
</html>
