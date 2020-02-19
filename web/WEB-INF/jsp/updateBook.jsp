<%--
  Created by IntelliJ IDEA.
  User: XuHao
  Date: 2020/2/9
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <%--BootStrap美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
</div>

<form action="${pageContext.request.contextPath}/book/updateBook" method="post">
<input type="hidden" name="bookId" value="${Qbook.bookID}">
    <div class="form-group">
        <label >书籍名称</label>
        <label>
            <input type="text" name="bookName" class="form-control" value="${Qbook.bookName}" required>
        </label>
    </div>
    <div class="form-group">
        <label >书籍数量</label>
        <label>
            <input type="text" name="bookCounts" class="form-control"  value="${Qbook.bookCounts}" required>
        </label>
    </div>
    <div class="form-group">
        <label >书籍描述</label>
        <label>
            <input type="text" name="detail" class="form-control"  value="${Qbook.detail}" required >
        </label>
    </div>
    <div class="form-group">
        <input type="submit" class="form-control " value="修改" >
    </div>
</form>
</body>
</html>
