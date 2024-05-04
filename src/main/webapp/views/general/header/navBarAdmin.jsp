<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.controller.url.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
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
    </style>
</head>
<body class="container">
	<div class="menu">
		<button onclick="window.location.href='<%= url.urlServer + "home-admin" %>'">Home</button>
    	<button onclick="window.location.href='<%= url.urlServer + "manageTypeRoom" %>'">Danh sách các loại phòng</button>
    	<button onclick="window.location.href='<%= url.urlServer + "manageService" %>'">Danh sách các dịch vụ</button>
    	<button onclick="window.location.href='<%= url.urlServer + "manageStaff" %>'">Danh sách các nhân viên</button>
    	<button onclick="window.location.href='<%= url.urlServer + "manageBill" %>'">Danh sách các hóa đơn</button>
	</div>
</body>
</html>