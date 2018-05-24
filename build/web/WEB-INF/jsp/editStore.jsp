<%@ page contentType = "text/html; charset = UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Store</title>
</head>
<body>

<h2>Enter store information for update</h2>
<form:form method="post" action="/SpringWebMVC/updateStore">
  <table>  
    <tr>
      <td><form:label path="id">Id</form:label></td>
      <td><form:input path="id"  value = "${store.getId()}" /></td>
    </tr>
    <tr>
      <td><form:label path="name">Name</form:label></td>
      <td><form:input path="name"  value = "${store.getName()}"/></td>
    </tr>
    <tr>
      <td><form:label path="type">Type</form:label></td>
      <td><form:input path="type" value = "${store.getType()}"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Update store"/>
      </td>
    </tr>
  </table>
</form:form>
<form:form method="post" action="/SpringWebMVC/deleteStore">
    <form:input path="id"  value = "${store.getId()}" type="hidden"/>
    <input type="submit" value="Delete store"/>
</form:form>
<a href="SpringWebMVC/">Home</a><br>
</body>
</html>
