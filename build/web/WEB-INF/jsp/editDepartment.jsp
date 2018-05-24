<%@ page contentType = "text/html; charset = UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Department</title>
</head>
<body>

<h2>Enter department information for update</h2>
<form:form method="post" action="/SpringWebMVC/updateDepartment">
  <table>  
    <tr>
      <td><form:label path="id">Id</form:label></td>
      <td><form:input path="id"  value = "${department.getId()}" /></td>
    </tr>
    <tr>
      <td><form:label path="name">Name</form:label></td>
      <td><form:input path="name"  value = "${department.getName()}"/></td>
    </tr>
    <tr>
      <td><form:label path="type">Type</form:label></td>
      <td><form:input path="type" value = "${department.getType()}"/></td>
    </tr>
    <tr>
        <td><form:label path="name">Store</form:label></td>
        <td>
        <select class="form-control" id= "store_id" name="store_id">
            <c:forEach var="store" items="${stores}">
                <option value="${store.getId()}">${store.getName()}</option>            
            </c:forEach>
        </select>
        </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Update department"/>
      </td>
    </tr>
  </table>
</form:form>
<form:form method="post" action="/SpringWebMVC/deleteDepartment">
    <form:input path="id"  value = "${department.getId()}" type="hidden"/>
    <input type="submit" value="Delete department"/>
</form:form>
<a href="SpringWebMVC/">Home</a><br>
</body>
</html>
