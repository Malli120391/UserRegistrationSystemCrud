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
          <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
          </ul>
         
         </nav>
    
    </header>
    <br>
      
        <div class="container col-md-5">
           <div class="card">
            <div class="card-body">
               <c:if test="${user!=null}">
               <form action="updateuser" method="post">
               </c:if>
               <c:if test="${user == null}">
               <form action="insertuser" method="post">
               </c:if>
               
                 <caption>
                  <h2>
                   <c:if test="${user!=null}">
                    Edit User
                   </c:if>
                   <c:if test="${user == null }">
                     Add New User
                   </c:if>
                  </h2>
                 </caption>
                 
                  <c:if test="${user!=null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' /> "/>
                  </c:if>
                  
                   <fieldset class="form-group">
                    <label>Name:</label><input type="text" value="<c:out value='${user.name}' />"
                    class="form-control" name="name" required="required">
                   </fieldset>
                   
                   <fieldset class="form-group">
                    <label>Email:</label><input type="text" value="<c:out value='${user.email}'/>" 
                        class="form-control" name="email" required="required">
                   </fieldset>
                   
                   <fieldset class="form-group">
                    <label>PhoneNo:</label><input type="text" value="<c:out value='${user.phoneNo}'/>" 
                        class="form-control" name="phoneNo" required="required">
                   </fieldset>
                   
                   <fieldset class="form-group">
                    <label>Country:</label><input type="text" value="<c:out value='${user.country}'/>" 
                        class="form-control" name="Country" required="required">
                   </fieldset>
                   
                   <fieldset class="form-group">
                    <label>State:</label><input type="text" value="<c:out value='${user.state}'/>" 
                        class="form-control" name="state" required="required">
                   </fieldset>
                   
                   <fieldset class="form-group">
                    <label>City:</label><input type="text" value="<c:out value='${user.city}'/>" 
                        class="form-control" name="city" required="required">
                   </fieldset>
                   
                   <fieldset class="form-group">
                    <label>Pin-Code:</label><input type="text" value="<c:out value='${user.pincode}'/>" 
                        class="form-control" name="pincode" required="required">
                   </fieldset>
                   
                   <button type="submit" class="btn btn-success">Save</button>
             </form>
            </div>
           </div>
        </div>

</body>
</html>