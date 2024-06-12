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
    input[type="password"],
    select {
        width: 100%;
        padding: 10px;
        margin: 5px 0 20px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    
    #username {
    	background-color: rgba(0,0,0, 0.1);
    }
    
    .background-color-green {
    	 background-color: #45a049 !important;
    }
    
    input[type="submit"] {
        background-color: #d5d5d5;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }
</style>
</head>
<body class="container">
	<jsp:include page="../header/header.jsp"/>
			<%
            	Account account = request.getAttribute("Account") != null ? (Account)request.getAttribute("Account"): null;
            %>
	<div class="content <%= account == null ? "dp-n" : "" %>">
		<h2>Change Password</h2>
    	<form action="<%= url.urlServer + "changePassWord" %>" method="post">
     	  <label for="username">Username:</label>
      	  <input type="text" id="username" value="<%= account == null ? "" : account.getUserName() %>" name="UserName" placeholder="Your username..." required readonly>

		  <label for="oldpassword">Old password:</label>
      	  <input type="password" class="newPassWord" id="oldpassword" name="PassWord" placeholder="Your old password.." required>

      	  <label for="password">New password:</label>
      	  <input type="password" class="newPassWord" id="password" name="NewPassWord" placeholder="Your password.." required>
      	  
      	  <label for="passwordConfirm">Confirm new password:</label>
      	  <input type="password" class="newPassWord" id="passwordConfirm" name="ConfirmNewPassWord" placeholder="Confirm new password..." required>
		
          <input class="dp-n" type="text" value="changePassWord" name="type">
          <input type="submit" class="submitNewPassWord" value="Update">
    </form>
	</div>
</body>
<script>

const urlParams = new URLSearchParams(window.location.search);
const paramValue = urlParams.get('show');
if(paramValue){
	alert(paramValue);
}

const newPassWord = document.getElementsByClassName('newPassWord');
const submitNewPassWord = document.querySelector('.submitNewPassWord');

function addSubmitPreventDefault(event){
    event.preventDefault();
}

for(let j = 0; j < newPassWord.length; ++j){
    if(newPassWord[j].value === ""){
    	submitNewPassWord.classList.remove('background-color-green');
    	submitNewPassWord.classList.remove('color-white');
    	submitNewPassWord.addEventListener('click', addSubmitPreventDefault);
        break;
    }
    if(j == newPassWord.length - 1){
    	submitNewPassWord.classList.add('background-color-green');
    	submitNewPassWord.classList.add('color-white');
    	submitNewPassWord.removeEventListener('click', addSubmitPreventDefault);
    }
}

for(let i = 0; i < newPassWord.length; ++i){
	newPassWord[i].addEventListener('input',() => {
        for(let j = 0; j < newPassWord.length; ++j){
            if(newPassWord[j].value === "" || newPassWord[1].value !== newPassWord[2].value){
            	submitNewPassWord.classList.remove('background-color-green');
            	submitNewPassWord.classList.remove('color-white');
            	submitNewPassWord.addEventListener('click', addSubmitPreventDefault);
                break;
            }
            if(j == newPassWord.length - 1 && newPassWord[1].value === newPassWord[2].value){
            	submitNewPassWord.classList.add('background-color-green');
            	submitNewPassWord.classList.add('color-white');
            	submitNewPassWord.removeEventListener('click', addSubmitPreventDefault);
            }
        }
    })
}
</script>
</html>