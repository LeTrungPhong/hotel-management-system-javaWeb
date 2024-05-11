<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            margin: 150px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="email"],
        input[type="number"],
        select,
        textarea {
            width: calc(100% - 5px);
            padding: 10px;
            margin: 5px 0;
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
        input[readonly] {
            background-color: #f4f4f4;
            cursor: not-allowed;
        }
        .input-group {
            display: flex;
            justify-content: space-between;
        }
        .input-group label,
        .input-group input {
            width: calc(100% - 22px);
        }

        .img_room_booking{
            width: 100%;
            border-radius: 10px;
            margin-bottom: 15px;
        }
    </style>
</head>
<body class="container">
<jsp:include page="../../general/header/header.jsp"/> 

	<h2>Thông Tin Đặt Phòng Khách Sạn</h2>
    <form action="#" method="post">
        <img class="img_room_booking" src="https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg" alt="">

        <label for="name">Họ và Tên:</label>
        <input type="text" id="name" name="name" value="<%= (String)request.getSession().getAttribute("FullName") %>" readonly>

        <label for="phone">Số Điện Thoại:</label>
        <input type="text" id="phone" name="phone" value="<%= (String)request.getSession().getAttribute("SDT") %>" readonly>

        <label for="checkin">Ngày Nhận Phòng:</label>
        <input type="text" id="checkin" name="checkin" value="<%= (String)request.getSession().getAttribute("CheckIn") %>" readonly>

        <label for="checkout">Ngày Trả Phòng:</label>
        <input type="text" id="checkout" name="checkout" value="<%= (String)request.getSession().getAttribute("CheckOut") %>" readonly>

        <label for="room-type">Loại Phòng:</label>
        <input type="text" id="room-type" name="room-type" value="<%= (String)request.getSession().getAttribute("TypeRoomName") %>" readonly>
        
        <label for="NumberAdult">Số người lớn:</label>
        <input type="text" id="NumberAdult" name="NumberAdult" value="<%= (int)request.getSession().getAttribute("NumberAdult") %>" readonly>
        
        <label for="NumberChild">Số trẻ em:</label>
        <input type="text" id="NumberChild" name="NumberChild" value="<%= (int)request.getSession().getAttribute("NumberChild") %>" readonly>
        
        <label for="total-price">Đơn Giá 1 Đêm: </label>
        <input type="text" id="total-price" name="total-price" value="<%= (int)request.getSession().getAttribute("Price") %>" readonly>
        
        <label for="pay">Da thanh toan:</label>
        <input type="text" id="pay" name="pay" value="<%= (int)request.getSession().getAttribute("pay") %>" readonly>

        <label for="total-price">Tổng Tiền:</label>
        <input type="text" id="total-price" name="total-price" value="<%= (int)request.getSession().getAttribute("total-price") %>" readonly>

        <input type="submit" value="Tai ve may">
    </form>
</body>
</html>