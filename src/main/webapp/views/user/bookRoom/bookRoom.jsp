<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
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
	<h2>Thông Tin Đặt Phòng Khách Sạn</h2>
    <form action="<%= url.urlServer + "bookRoom" %>" method="post" onsubmit="return validateInput()">
        <img class="img_room_booking" src="https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg" alt="">

        <label for="FullName">Họ và Tên:</label>
        <input type="text" id="FullName" name="FullName" required>
        
        <label for="CCCD">CCCD:</label>
        <input type="text" id="CCCD" name="CCCD" required>

        <label for="SDT">Số Điện Thoại:</label>
        <input type="text" id="SDT" name="SDT" required>
         
        <select name="Gender">
        	<option value="Female">Female</option>
        	<option value="Male">MaleM</option>
        </select>

        <label for="ComeInDate">Ngày Nhận Phòng:</label>
        <input type="text" id="ComeInDate" name="ComeInDate" value="04/05/2024" readonly>

        <label for="ComeOutDate">Ngày Trả Phòng:</label>
        <input type="text" id="ComeOutDate" name="ComeOutDate" value="08/05/2024" readonly>

        <label for="TypeRoomName">Loại Phòng:</label>
        <input type="text" id="TypeRoomName" name="TypeRoomName" value="Single Room" readonly>

        <div class="input-group">
            <label for="NumberAdult">Người Lớn:</label>
            <input type="number" id="NumberAdult" name="NumberAdult" value="1" min="1">
        </div>
        
        <div class="input-group">
            <label for="NumberChild">Trẻ Em:</label>
            <input type="number" id="NumberChild" name="NumberChild" value="0" min="0">
        </div>
        
        <label for="Price">Đơn Giá 1 Đêm: </label>
        <input type="text" id="Price" name="Price" value="20" readonly>

        <label for="total-price">Phụ Phí: </label>
        <input type="text" id="total-price" name="total-price" value="10$" readonly>

        <label for="total-price">Tổng Tiền:</label>
        <input type="text" id="total-price" name="total-price" value="90$" readonly>

        <input type="submit" value="Tiến hành thanh toán">
    </form>
<script>

function validateInput() {
    var inputCCCD = document.getElementById("CCCD").value;
    if(inputCCCD.length != 12) {
        alert("Vui lòng nhập CCCD 12 số.");
        return false;
    }
    var inputSDT = document.getElementById("SDT").value;
    if(inputSDT.length != 10){
    	alert("Vui lòng nhập SDT 10 số.");
    	return false;
    }
    return true;
}
</script>
</body>
</html>