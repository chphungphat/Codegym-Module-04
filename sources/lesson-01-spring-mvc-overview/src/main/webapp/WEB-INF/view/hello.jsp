
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>hello C12</h1>
  <%
    String name = (String) request.getAttribute("name");
    out.print(name);
    System.out.println(name);
  %>
</body>
</html>
