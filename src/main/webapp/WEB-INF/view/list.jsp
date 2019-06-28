<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/27
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var id = this.title;
                alert(id);
                $.post("/user/delete/"+id,{},function (data) {

                       $(this.title).parent().parent().remove();


                });
            })
        })
    </script>
</head>
<body>
<table width="600" border="1">
    <tr>
        <th>编号</th>
        <th>账号</th>
        <th>密码</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${pageInfo.list}" var="goods">

        <tr>
            <td>${goods.id}</td>
            <td>${goods.name}</td>
            <td>${goods.pwd}</td>
            <td><input type="button" value="删除" class="delete" title="${goods.id}"> 修改</td>
        </tr>
    </c:forEach>
</table>


<c:choose>
    <c:when test="${pageInfo.pageNum==pageInfo.firstPage}">首页&nbsp;&nbsp;&nbsp;上一页</c:when>
    <c:otherwise>
        <a href="/user/find?page=1">首页</a>&nbsp;&nbsp;&nbsp;
        <a href="/user/find?page=${pageInfo.prePage}">上一页</a>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${pageInfo.pageNum==pageInfo.lastPage}">下一页&nbsp;&nbsp;&nbsp;最后页</c:when>
    <c:otherwise>
        <a href="/user/find?page=${pageInfo.nextPage}">下一页</a>&nbsp;&nbsp;&nbsp;
        <a href="/user/find?page=${pageInfo.lastPage}">最后页</a>
    </c:otherwise>
</c:choose>


共${pageInfo.pages}页/当前第${pageInfo.pageNum} 共${pageInfo.total}条记录
</body>
</html>
