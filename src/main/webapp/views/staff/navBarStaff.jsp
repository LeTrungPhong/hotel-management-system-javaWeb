<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.controller.url.*" %>
<%@ page import="com.appManageHotel.controller.url.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="views/user/header/style.css">
<title>Insert title here</title>
	<style>
        body {
            font-family: Arial, sans-serif;
            position: relative;
        }
        .menu {
        	position: fixed;
        	width: 100%;
        	top: 70px;
            left: 0px;
            display: flex;
            justify-content: center;
            margin-top: 20px;
            z-index: 4;
        }
        .menu button {
            padding: 10px 20px;
            margin: 10px;
            font-size: 18px;
            border: none;
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .menu button:hover {
            background-color: #45a049;
        }
        .dp-n {
        	display: none;
        }
        .button-signout {
        	all:unset;
        	background-color: red;
        	border-radius: 5px;
        	padding: 10px 10px;
        	cursor: pointer;
        	color: white;
        	font-weight: 600;
        	margin-right: 40px;
        }
    </style>
</head>
<body class="container">
	<header class='header'>
        <div class='header__logo'>
            <a href="<%= url.urlServer + "selectRoom" %>" class='header__sign-button'>
                	<span>Danh sách phòng trống</span>
            </a>
            <a href="<%= url.urlServer + "checkInRoom" %>" class='header__sign-button'> 
                	<span>Danh sách phòng đã được Check In</span>
            </a>
           	<a href="<%= url.urlServer + "nonCheckInRoom" %>" class='header__sign-button'>
                <span>Danh sách phòng chưa được Check In</span>
            </a>
        </div>
        <button class="button-signout" style="background: red;" onclick="document.getElementById('signOutAdmin').click()">Đăng xuất</button>
     </header>
	<form class="dp-n" method="post" action="<%= url.urlServer + "signOut" %>">
		<input type="submit" id="signOutAdmin">
	</form>
	<script></script>
</body>
</html>