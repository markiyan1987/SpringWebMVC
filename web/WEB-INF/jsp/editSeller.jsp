<%@ page contentType = "text/html; charset = UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Seller</title>
</head>
<body>

<h2>Enter seller information for update</h2>
<form:form method="post" action="/SpringWebMVC/updateSeller">
  <table>  
    <tr>
      <td><form:label path="id">Id</form:label></td>
      <td><form:input path="id"  value = "${seller.getId()}" /></td>
    </tr>
    <tr>
      <td><form:label path="first_name">First name</form:label></td>
      <td><form:input path="first_name"  value = "${seller.getFirst_name()}"/></td>
    </tr>
    <tr>
      <td><form:label path="last_name">Last name</form:label></td>
      <td><form:input path="last_name" value = "${seller.getLast_name()}"/></td>
    </tr>
    <tr>
      <td><form:label path="date_of_birth">Date of birth</form:label></td>
      <td><form:input path="date_of_birth" value = "${seller.getDate_of_birth()}"/></td>
    </tr>
    <tr>
      <td><form:label path="salary">Salary</form:label></td>
      <td><form:input path="salary" value = "${seller.getSalary()}"/></td>
    </tr>
    <tr>
        <td><form:label path="department_id">Department</form:label></td>
        <td>
        <select class="form-control" id= "department_id" name="department_id">
            <c:forEach var="department" items="${departments}">
                <option value="${department.getId()}">${department.getName()}</option>            
            </c:forEach>
        </select>
        </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Update seller"/>
      </td>
    </tr>
  </table>
</form:form>
<form:form method="post" action="/SpringWebMVC/deleteSeller">
    <form:input path="id"  value = "${seller.getId()}" type="hidden"/>
    <input type="submit" value="Delete seller"/>
</form:form>
<a href="SpringWebMVC/">Home</a><br>
</body>
</html>
