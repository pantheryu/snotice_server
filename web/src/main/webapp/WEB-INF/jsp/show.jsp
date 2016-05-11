<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: spirit
  Date: 2016/2/25
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  request.setAttribute("basePath", basePath);
%>

<html>
<head>
    <title>pic</title>
</head>
<body>
<c:forEach items="${imagesPathList}" var="image">
  <img src="${basePath}${image}"><br/>
</c:forEach>
<span style="font-size: 14px">${basePath}${image}</span>

</body>
</html>
