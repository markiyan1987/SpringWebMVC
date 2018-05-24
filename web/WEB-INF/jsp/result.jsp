<%-- 
    Document   : result
    Created on : 21 квіт. 2018, 11:06:37
    Author     : karpj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
       <%if(request.getAttribute("newSeller") != null) {%>
      <h2>Submitted Seller Information</h2>
      <table>
         <tr>
            <td>First name</td>
            <td>${newSeller.getFirst_name()}</td>
         </tr>
         <tr>
            <td>Last name</td>
            <td>${newSeller.getLast_name()}</td>
         </tr>
         <tr>
            <td>Date of birth</td>
            <td>${newSeller.getDate_of_birth()}</td>
         </tr>
         <tr>
            <td>Salary</td>
            <td>${newSeller.getSalary()}</td>
         </tr>
      </table>  
         <%}if(request.getAttribute("newDepartment") != null){%>
         <h2>Submitted Department Information</h2>
      <table>
         <tr>
            <td>Department name</td>
            <td>${newDepartment.getName()}</td>
         </tr>
         <tr>
            <td>Department type</td>
            <td>${newDepartment.getType()}</td>
         </tr>        
      </table> 
            <%}if(request.getAttribute("newStore") != null){%>
       <h2>Submitted Store Information</h2>
      <table>
         <tr>
            <td>Store name</td>
            <td>${newStore.getName()}</td>
         </tr>
         <tr>
            <td>Store type</td>
            <td>${newStore.getType()}</td>
         </tr>        
      </table>          
         <%}%>
         <a href="SpringWebMVC/index">Home</a><br>
         <a href="SpringWebMVC/seller">Add seller</a><br>
         <a href="SpringWebMVC/department">Add department</a><br>
         <a href="SpringWebMVC/store">Add store</a>
   </body>   
</html>