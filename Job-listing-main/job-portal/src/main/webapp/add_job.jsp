<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Admin Add Jobs</title>
 <%@include file="all_component/all_css.jsp"%>
</head>
<body>
<%@include file="all_component/navbar.jsp"%>
 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .form-container {
            width: 40%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #555;
        }

        input[type="text"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        textarea {
            height: 150px;
            resize: none;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<div class="alert alert-success" role="alert">

</div>
<c:if test="${userobj.role ne  'Admin'}">
<c:redirect url ="login.jsp"></c:redirect>
</c:if>

<c:if test="${not empty succMsg }">
<div class="alert alert-success" role=alert"> ${succMsg }</div>
<c:remove var="succMsg" />
</c:if>

    <div class="form-container">
        <h2>Add Job Form</h2>

        <form action="add_job" method="post">
            <!-- Job Title -->
            <div class="form-group">
                <label for="title">Job Title:</label>
                <input type="text" id="title" name="title" placeholder="Enter job title" required>
            </div>

            <!-- Location Dropdown -->
            <div class="form-group">
                <label for="location">Location:</label>
                <select id="location" name="location" required>
                    <option value="">Select location</option>
                    <option value="Delhi">Delhi</option>
                    <option value="Mumbai">Mumbai</option>
                    <option value="Bangalore">Bangalore</option>
                    <option value="Chennai">Chennai</option>
                    <option value="Kolkata">Kolkata</option>
                    <option value="Hyderabad">Hyderabad</option>
                    <option value="Pune">Pune</option>
                    <option value="Ahmedabad">Ahmedabad</option>
                    <option value="Surat">Surat</option>
                    <option value="Jaipur">Jaipur</option>
                </select>
            </div>

            <!-- Categories Dropdown -->
            <div class="form-group">
                <label for="category">Category:</label>
                <select id="category" name="category" required>
                    <option value="">Select category</option>
                    <option value="Software Engineer">Software Engineer</option>
                    <option value="Data Scientist">Data Scientist</option>
                    <option value="System Administrator">System Administrator</option>
                    <option value="IT Support">IT Support</option>
                    <option value="Network Engineer">Network Engineer</option>
                    <option value="Cybersecurity Analyst">Cybersecurity Analyst</option>
                    <option value="DevOps Engineer">DevOps Engineer</option>
                    <option value="Cloud Engineer">Cloud Engineer</option>
                    <option value="Database Administrator">Database Administrator</option>
                    <option value="UI/UX Designer">UI/UX Designer</option>
                </select>
            </div>

            <!-- Status Dropdown -->
            <div class="form-group">
                <label for="status">Status:</label>
                <select id="status" name="status" required>
                    <option value="">Select status</option>
                    <option value="Active">Active</option>
                    <option value="Inactive">Inactive</option>
                </select>
            </div>

            <!-- Description -->
            <div class="form-group">
                <label for="description">Job Description:</label>
                <textarea id="description" name="description" placeholder="Enter job description" required></textarea>
            </div>

            <!-- Submit Button -->
            <button type="submit">Publish job</button>
        </form>
    </div>

</body>
</html>