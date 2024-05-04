<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            	Cookie findCookieIDAccount = cookie.findCookieByName((HttpServletRequest)request, "IDAccount");
            	Account account = findCookieIDAccount == null ? null : AccountBO.getInstance().selectAccountByCookie(findCookieIDAccount);
            %>
	<div class="content <%= account == null ? "dp-n" : "" %>">
		<h2>Change Password</h2>
    	<form action="<%= url.urlServer + "changePassWord" %>" method="post">
     	  <label for="username">Username:</label>
      	  <input type="text" id="username" value="<%= account == null ? "" : account.getUserName() %>" name="UserName" placeholder="Your username..." required disabled>

		  <label for="oldpassword">Old password:</label>
      	  <input type="text" id="oldpassword" name="PassWord" placeholder="Your old password.." required>

      	  <label for="password">New password:</label>
      	  <input type="text" id="password" name="NewPassWord" placeholder="Your password.." required>
      	  
      	  <label for="passwordConfirm">Confirm new password:</label>
      	  <input type="text" id="passwordConfirm" name="ConfirmNewPassWord" placeholder="Confirm new password..." required>
		
          <input class="dp-n" type="text" value="changePassWord" name="type">
          <input type="submit" value="Update">
    </form>
	</div>
</body>
</html>