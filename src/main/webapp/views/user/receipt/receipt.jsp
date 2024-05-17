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
            margin-bottom: 20px; 
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
<jsp:include page="../header/header.jsp"/> 

	<h2>Thông Tin Đặt Phòng Khách Sạn</h2>
    <form action="#" method="post">

        <label for="name">Họ và Tên:</label>
        <input type="text" id="name" name="name" value="<%= request.getAttribute("FullName") != null ? (String)request.getAttribute("FullName") : "" %>" readonly>

        <label for="phone">Số Điện Thoại:</label>
        <input type="text" id="phone" name="phone" value="<%= request.getAttribute("SDT") != null ? (String)request.getAttribute("SDT") : "" %>" readonly>
        
        <label for="gender">Giới tính:</label>
        <input type="text" id="gender" name="gender" value="<%= request.getAttribute("Gender") != null ? (String)request.getAttribute("Gender") : "" %>" readonly>

        <label for="checkin">Ngày Nhận Phòng:</label>
        <input type="text" id="checkin" name="checkin" value="<%= request.getAttribute("timeStart") != null ? (String)request.getAttribute("timeStart") : "" %>" readonly>

        <label for="checkout">Ngày Trả Phòng:</label>
        <input type="text" id="checkout" name="checkout" value="<%= request.getAttribute("timeEnd") != null ? (String)request.getAttribute("timeEnd") : "" %>" readonly>

        <label for="room-type">Loại Phòng:</label>
        <input type="text" id="room-type" name="room-type" value="<%= request.getAttribute("TypeRoomName") != null ? (String)request.getAttribute("TypeRoomName") : "" %>" readonly>
        
        <label for="NumberAdult">Số người lớn:</label>
        <input type="text" id="NumberAdult" name="NumberAdult" value="<%= request.getAttribute("NumberAdult") != null ? (int)request.getAttribute("NumberAdult") : "" %>" readonly>
        
        <label for="NumberChild">Số trẻ em:</label>
        <input type="text" id="NumberChild" name="NumberChild" value="<%= request.getAttribute("NumberChild") != null ? (int)request.getAttribute("NumberChild") : "" %>" readonly>
        
        <label for="total-price">Đơn Giá 1 Đêm: </label>
        <input type="text" id="total-price" name="total-price" value="<%= request.getAttribute("Price") != null ? (int)request.getAttribute("Price") : "" %>" readonly>
        
        <label for="surchange">Phụ thu: </label>
        <input type="text" id="surchange" name="surchange" value="<%= request.getAttribute("surchange") != null ? (int)request.getAttribute("surchange") : "" %>" readonly>
        
        <label for="pay">Da thanh toan:</label>
        <input type="text" id="pay" name="pay" value="<%= request.getAttribute("Prepayment") != null ? (int)request.getAttribute("Prepayment") : "" %>" readonly>

        <label for="total-price">Tổng Tiền:</label>
        <input type="text" id="total-price" name="total-price" value="<%= request.getAttribute("total") != null ? (int)request.getAttribute("total") : "" %>" readonly>

        <input type="submit" value="Tai ve may">
    </form>
</body>
</html>