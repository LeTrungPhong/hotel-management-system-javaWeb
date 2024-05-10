<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.appManageHotel.model.DAO.CustomerDAOimpl"%>
<%@ page import="com.appManageHotel.model.BEAN.Account" %>
<%@ page import="com.appManageHotel.model.BEAN.Customer" %>
<%@ page import="com.appManageHotel.controller.cookie.cookie" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="com.appManageHotel.model.DAO.AccountDAOImpl" %>
<%@ page import="com.appManageHotel.controller.url.*"%>
<%@ page import="com.appManageHotel.model.BO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
    }
    .container {
    	position: relative;
    	width: 100vw;
    	height: 100vh;
    	display: flex;
    	align-items: center;
    	justify-content: center;
    }
    .content {
        max-width: 400px;
        padding: 20px;
        background: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
        text-align: center;
    }
    label {
        font-weight: bold;
    }
    input[type="text"],
    input[type="email"],
    select {
        width: 100%;
        padding: 10px;
        margin: 5px 0 20px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #4caf50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body class="container">
	<jsp:include page="../../general/header/header.jsp"/>
			<%
            	Customer customer = request.getAttribute("Customer") != null ? (Customer)request.getAttribute("Customer") : null;
            %>
	<div class="content">
		<h2>Update Information</h2>
    	<form action="<%= url.urlServer + "updateInforUser" %>" method="post" onsubmit="refuseData()">
     	  <label for="fullName">Full Name:</label>
      	  <input type="text" id="fname" value="<%= customer == null ? "" : customer.getFullName() %>" name="FullName" placeholder="Your full name.." required>

      	  <label for="lname">ID Card:</label>
      	  <input type="text" id="lname" value="<%= customer == null ? "" : customer.getCCCD() %>" name="CCCD" placeholder="Your id card.." required>
      	  
      	  <label for="sdt">Phone Number:</label>
      	  <input type="text" id="sdt" value="<%= customer == null ? "" : customer.getSDT() %>" name="SDT" placeholder="Your phone number.." required>

       	 <label for="birth">Birth:</label>
       	 <input type="date" value="<%= customer == null ? "" : customer.getBirth() %>" id="birth" name="Birth" required>
       	 
       	 <br></br>
		
     	   <label for="Gender">Gender:</label>
     	   <select id="gender" name="Gender">
      	      <option <%= (customer != null && customer.getGender().equals("male")) ? "selected" : "" %> value="male">Male</option>
      	      <option <%= (customer != null && customer.getGender().equals("female")) ? "selected" : "" %> value="female">Female</option>
      	      <option <%= (customer != null && customer.getGender().equals("other")) ? "selected" : "" %> value="other">Other</option>
        	</select>
        	<input class="dp-n" type="text" value="updateInforUser" name="type">
        	<input type="submit" value="Update">
    </form>
	</div>
</body>
<script>
	function refuseData(){
		if(document.getElementById('lname').value.length != 12){
			alert("CCCD phai nhap 12 so");
			return false;
		}
		if(document.getElementById('sdt').value.length != 10){
			alert("SDT phai nhap 10 so");
			return false;
		}
		return true;
	}
</script>
</html>