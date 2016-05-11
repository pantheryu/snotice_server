<%--
  Created by IntelliJ IDEA.
  User: spirit
  Date: 2016/2/25
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  request.setAttribute("basePath", basePath);
%>
<html>
<head>
    <title>FileUpload</title>
</head>
<body>
<form action="${basePath}upload" method="post" enctype="multipart/form-data">
  <label>用户名：</label><input type="text" name="name"/><br/>
  <label>密 码：</label><input type="password" name="password"/><br/>
  <label>头 像</label><input type="file" name="file"/><br/>
  <input type="submit" value="提  交"/>
</form>

<span style="font-size: 14px">${basePath}</span>

</body>
</html>
