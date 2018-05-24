<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.Store"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Store</title>
   </head>
   
   <body>
      <h2>Store info</h2>
      <div class="conteiner"> 
          <div class="row">
              <div class="col-md-3"></div>
              <div class="col-md-6">
                <table class="table table-bordered">
                    <caption>Stores</caption>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>type</th>
                        <th>edit/delete</th>
                    </tr>
                    <c:forEach var="store" items="${stores}">
                    <tr>
                        <td>${store.getId()}</td>
                        <td>${store.getName()}</td>
                        <td>${store.getType()}</td>
                        <td>
                            <a href="SpringWebMVC/editStore/${store.getId()}">Edit</a> |
                            <a href="SpringWebMVC/editStore/${store.getId()}">Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                <a href="SpringWebMVC/store">Add store</a><br><br>
              </div>
            <div class="col-md-3"></div>
          </div>    
          
          <div class="row">
              <div class="col-md-3"></div>
              <div class="col-md-6">
                <table class="table table-bordered">
                    <caption>Departments</caption>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>type</th>
                        <th>store</th>
                        <th>edit/delete</th>
                    </tr>
                    <c:forEach var="department" items="${departments}">
                    <tr>
                        <td>${department.getId()}</td>
                        <td>${department.getName()}</td>
                        <td>${department.getType()}</td>
                        <td>${department.getStore()}</td>
                        <td>
                            <a href="SpringWebMVC/editDepartment/${department.getId()}">Edit</a> |
                            <a href="SpringWebMVC/editDepartment/${department.getId()}">Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                <a href="SpringWebMVC/department">Add department</a><br><br>
              </div>
              <div class="col-md-3"></div>
         </div>
          
          <div class="row">
              <div class="col-md-3"></div>
              <div class="col-md-6">
                <table class="table table-bordered">
                    <caption>Sellers</caption>
                    <tr>
                        <th>id</th>
                        <th>first name</th>
                        <th>last name</th>
                        <th>date of birth</th>
                        <th>salary</th>
                        <th>department</th>
                        <th>edit/delete</th>
                    </tr>
                    <c:forEach var="seller" items="${sellers}">
                    <tr>
                        <td>${seller.getId()}</td>
                        <td>${seller.getFirst_name()}</td>
                        <td>${seller.getLast_name()}</td>
                        <td>${seller.getDate_of_birth()}</td>
                        <td>${seller.getSalary()}</td>
                        <td>${seller.getDepartment()}</td>
                        <td>
                            <a href="SpringWebMVC/editSeller/${seller.getId()}">Edit</a> |
                            <a href="SpringWebMVC/editSeller/${seller.getId()}">Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>     
                <a href="SpringWebMVC/seller">Add seller</a><br><br> 
              </div>
              <div class="col-md-3"></div>
          </div>
      </div>
      
   </body>
</html>
