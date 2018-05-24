<%@ page contentType = "text/html; charset = UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Department</title>
</head>
<body>

<h2>Enter store information</h2>
<form:form method="post" action="/SpringWebMVC/addStore">
  <table>    
    <tr>
      <td><form:label path="name">Name</form:label></td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td><form:label path="type">Type</form:label></td>
      <td><form:input path="type" /></td>
    </tr>
        <tr>
      <td colspan="2">
        <input type="submit" value="Add store"/>
      </td>
    </tr>
  </table>
</form:form>
<a href="SpringWebMVC/">Home</a><br>
</body>
</html>
