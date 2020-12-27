<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Application</title>
     <link rel="stylesheet" 
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
       crossorigin="anonymous">
</head>
<body>

    <header>
      
         <nav class="navbar navbar-expand-md navbar-dark" style="background-color: orange">
         
         <div>
         <a href="http://www.google.com" class="navbar-brand">User
         Registration Application</a>
         </div>
         
          <ul class="navbar-nav">
          <li><a href="<%=request.getContextPath()%>/list" class="nav-link">User List</a></li>
          </ul>
         
         </nav>
    
    </header>
    <br>
    
    <div class="row">
      <div class="container">
       <h3 class="text-center">User Management Application</h3>
       <hr>
          <div class="container text-left">
          <a href="<%=request.getContextPath() %>/newuser" class="btn btn-success">Add New User</a>
          </div>
       <br>
       <table class="table table-bordered">
                <thead>
                <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone-NO</th>
                <th>Country</th>
                <th>State</th>
                <th>City</th>
                <th>Pin-Code</th>
                <th>Action</th>
                </tr>
                </thead>
                <tbody>
                   <c:forEach var="user" items="${listUser}">
                   <tr>
                   <td><c:out value="${user.id}"></c:out></td>
                   <td><c:out value="${user.name}"></c:out></td>
                   <td><c:out value="${user.email}"></c:out></td>
                   <td><c:out value="${user.phoneNo}"></c:out></td>
                   <td><c:out value="${user.country}"></c:out></td>
                   <td><c:out value="${user.state}"></c:out></td>
                   <td><c:out value="${user.city}"></c:out></td>
                   <td><c:out value="${user.pincode}"></c:out></td>
                   
                   <td><a href="edituser?id=<c:out value='${user.id}'/>">Edit</a>
                       &nbsp;&nbsp;&nbsp;&nbsp; <a
                       href="deleteuser?id=<c:out value='${user.id}' />">Delete</a></td>
                   </tr>
                   </c:forEach>
                
                </tbody>
                
       </table>
       
       
      </div>
      
    </div>

</body>
</html>