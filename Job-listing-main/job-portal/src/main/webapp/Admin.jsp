<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
    <%@include file="all_component/all_css.jsp"%>
    <style type="text/css">
    .back-img {
        background: url("images/admin.jpg");
        height: 80vh;
        width: 100%; /* Ensure it spans the full width */
        background-repeat: no-repeat;
        background-size: cover;
        background-position: center;
    }

    .text-center h1 {
        color: #000000; /* Change the color to Gold or any other color */
        padding: 4rem 0; /* Padding for better spacing */
    }
    </style>
</head>
<body>
<c:if test="${userobj.role ne  'Admin'}">
<c:redirect url ="login.jsp"></c:redirect>
</c:if>

   <%@include file="all_component/navbar.jsp"%>
   <div class="container-fluid back-img">
       <div class="text-center">
           <h1 class="p-4"> Welcome Admin</h1>
       </div>
   </div>
</body>
</html>
