<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.controller.url.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 50px;
        }
        .container {
        	margin-top: 150px;
        }
        .room-type {
        	width: 400px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }
        .room-type img {
            width: 100%;
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
        }
        .room-type-info {
            padding: 20px;
        }
        .room-type-info h2 {
            margin-top: 0;
        }
        .room-type-info p {
            margin: 10px 0;
        }
        .btn-container {
            text-align: center;
            margin-top: 10px;
        }
        .btn-container a {
            text-decoration: none;
        }
        .btn-container button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            margin: 0 10px;
            transition: background-color 0.3s;
        }
        .btn-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body class="container">
<jsp:include page="../general/header/header.jsp"/> 
	<div class="room-type">
    <img src="https://media.cnn.com/api/v1/images/stellar/prod/140127103345-peninsula-shanghai-deluxe-mock-up.jpg?q=w_2226,h_1449,x_0,y_0,c_fill" alt="Room Image">
    <div class="room-type-info">
        <h2>Phòng Deluxe</h2>
        <p>Số người tối đa: Người lớn - 2, Trẻ nhỏ - 1</p>
        <p>Giá: $200/đêm</p>
        <div class="btn-container">
            <a href="chi_tiet_loai_phong.html"><button>Xem chi tiết</button></a>
            <a href="chinh_sua_loai_phong.html"><button>Chỉnh sửa</button></a>
        </div>
    </div>
</div>

<div class="room-type">
    <img src="https://media.cnn.com/api/v1/images/stellar/prod/140127103345-peninsula-shanghai-deluxe-mock-up.jpg?q=w_2226,h_1449,x_0,y_0,c_fill" alt="Room Image">
    <div class="room-type-info">
        <h2>Phòng Deluxe</h2>
        <p>Số người tối đa: Người lớn - 2, Trẻ nhỏ - 1</p>
        <p>Giá: $200/đêm</p>
        <div class="btn-container">
            <a href="chi_tiet_loai_phong.html"><button>Xem chi tiết</button></a>
            <a href="chinh_sua_loai_phong.html"><button>Chỉnh sửa</button></a>
        </div>
    </div>
</div>

<div class="room-type">
    <img src="https://media.cnn.com/api/v1/images/stellar/prod/140127103345-peninsula-shanghai-deluxe-mock-up.jpg?q=w_2226,h_1449,x_0,y_0,c_fill" alt="Room Image">
    <div class="room-type-info">
        <h2>Phòng Deluxe</h2>
        <p>Số người tối đa: Người lớn - 2, Trẻ nhỏ - 1</p>
        <p>Giá: $200/đêm</p>
        <div class="btn-container">
            <a href="chi_tiet_loai_phong.html"><button>Xem chi tiết</button></a>
            <a href="chinh_sua_loai_phong.html"><button>Chỉnh sửa</button></a>
        </div>
    </div>
</div>

<div class="btn-container">
    <a href="<%= url.urlServer + "insertTypeRoom" %>"><button>Thêm loại phòng</button></a>
</div>
</body>
</html>