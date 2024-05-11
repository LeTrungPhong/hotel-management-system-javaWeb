<%@page import="com.appManageHotel.controller.cookie.cookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.controller.url.*" %>
<%@ page import="com.appManageHotel.model.BEAN.*" %>
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
        .buttonPrice button {
        	all: unset;
        	background-color: white;
        }
        
    </style>
</head>
<body class="container">
	<jsp:include page="../../general/header/header.jsp"/> 
	<% 
		Customer customer = request.getAttribute("Customer") != null ? (Customer)request.getAttribute("Customer") : null; 
		TypeRoom typeRoom = request.getAttribute("TypeRoom") != null ? (TypeRoom)request.getAttribute("TypeRoom") : null;
	%>
	<h2>Thông Tin Đặt Phòng Khách Sạn</h2>
    <form action="<%= url.urlServer + "bookRoom" %>" id="form-submit" method="post" onsubmit="return validateInput()">
        <img class="img_room_booking" src="https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg" alt="">
		<input type="text" style="display: none" class="dp-n" name="IDTypeRoom" value="<%= typeRoom.getIDTypeRoom() %>">
        <label for="FullName">Họ và Tên:</label>
        <input 
        	type="text" 
        	id="FullName" 
        	name="FullName" 
        	value="<%= customer != null ? customer.getFullName() : "" %>" 
        	required
        	<%= customer != null ? "readonly" : "" %>
        >

        <label for="SDT">Số Điện Thoại:</label>
        <input 
        	type="text" 
        	id="SDT" 
        	name="SDT" 
        	value="<%= customer != null ? customer.getSDT() : "" %>" 
        	required
        	<%= customer != null ? "readonly" : "" %>
        >
         
        <select <%= customer != null ? "disabled" : "" %>  name="Gender">
        	<option <%= (customer != null && customer.getGender().equals("female")) ? "selected" : "" %> value="Female">Female</option>
        	<option <%= (customer != null && customer.getGender().equals("male")) ? "selected" : "" %> value="Male">Male</option>
        </select>

        <label for="ComeInDate">Ngày Nhận Phòng:</label>
        <input type="date" id="ComeInDate" name="ComeInDate" required >

        <label for="ComeOutDate">Ngày Trả Phòng:</label>
        <input type="date" id="ComeOutDate" name="ComeOutDate" required >

        <label for="TypeRoomName">Loại Phòng:</label>
        <input type="text" id="TypeRoomName" name="TypeRoomName" value="<%= typeRoom != null ? typeRoom.getTypeRoomName() : "" %>" required readonly >

        <div class="input-group">
            <label for="NumberAdult">Người Lớn:</label>
            <input type="number" id="NumberAdult" name="NumberAdult" value="1" min="1" max="<%= typeRoom != null ? typeRoom.getMaxAdult() : 1 %>">
        </div>
        
        <div class="input-group">
            <label for="NumberChild">Trẻ Em:</label>
            <input type="number" id="NumberChild" name="NumberChild" value="0" min="0" max="<%= typeRoom != null ? typeRoom.getMaxChild() : 0 %>">
        </div>
        
        <label for="Price">Đơn Giá 1 Đêm: </label>
        <input type="text" id="Price" name="Price" value="<%= typeRoom != null ? typeRoom.getPrice() : "" %>" readonly required>

        <label for="total-price">Tổng Tiền:</label>
        <input type="text" id="total-price" name="total-price" readonly required>

		<select name="payPrice">
			<option selected id="pay25"></option>
			<option id="pay100"></option>
		</select>
		
        <input type="submit" value="Tiến hành thanh toán">
    </form>
<script>

const urlParams = new URLSearchParams(window.location.search);
const paramValue = urlParams.get('show');
if(paramValue){
	alert(paramValue);
	window.location.href="<%= url.urlServer + "receipt" %>"
}

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

var totalPrice = document.getElementById('total-price').value;
document.getElementById('form-submit').addEventListener('submit', function(event) {
    var totalPrice = document.getElementById('total-price').value;
    if(totalPrice.trim() === ''){
        alert("Thoi gian khong hop le");
        event.preventDefault(); 
    }
});

var timeStart = document.getElementById('ComeInDate');  
var timeEnd = document.getElementById('ComeOutDate');

timeStart.addEventListener('input', () => {
	const timeStartValue = new Date(timeStart.value);
	const timeEndValue = new Date(timeEnd.value);

	const dayS = timeStartValue.getDate();
	const monthS = timeStartValue.getMonth() + 1;
	const yearS = timeStartValue.getFullYear();

	const dayE = timeEndValue.getDate();
	const monthE = timeEndValue.getMonth() + 1;
	const yearE = timeEndValue.getFullYear();

	const total = document.getElementById('total-price');
	const pay25 = document.getElementById('pay25');
	const pay100 = document.getElementById('pay100');

	const currentDate = new Date();
	const year = currentDate.getFullYear();
	const month = currentDate.getMonth() + 1; 
	const day = currentDate.getDate();
	
	let check = false;
	
	if(isNaN(timeStartValue.getTime()) || isNaN(timeEndValue.getTime())){
		check = true;
	}

	if(year > yearS){
		check = true;
	}
	if(year == yearS && month > monthS){
		check = true;
	}
	if(year == yearS && month == monthS && day > dayS){
		check = true;
	}
	if(year == yearS && month == monthS && day == dayS){
		check = true;
	}
	
	if(yearS > yearE){
		check = true;
	}
	if(yearS == yearE && monthS > monthE){
		check = true;
	}
	if(yearS == yearE && monthS == monthE && dayS > dayE){
		check = true;
	}
	if(yearS == yearE && monthS == monthE && dayS == dayE){
		check = true;
	}
    
	if(check){
		total.value = "";
		pay25.value = "";
		pay25.textContent = "";
		pay100.value = "";
		pay100.textContent = "";
		return;
	}

	const timestamp1 = timeStartValue.getTime();
	const timestamp2 = timeEndValue.getTime();

	const secondsDiff = Math.abs(timestamp2 - timestamp1) / 1000;

	const daysDiff = Math.floor(secondsDiff / (60 * 60 * 24));

	console.log("Số ngày giữa hai ngày:", daysDiff);

	const Price = document.getElementById("Price").value;
	total.value = daysDiff * Price;
	pay25.value = daysDiff * Price * 25 / 100;
	pay25.textContent = "Tra truoc 25 % = " + daysDiff * Price * 25 / 100;
	pay100.value = daysDiff * Price;
	pay100.textContent = "Thanh toan phong 100% = " + daysDiff * Price;
})

timeEnd.addEventListener('input', () => {
	const timeStartValue = new Date(timeStart.value);
	const timeEndValue = new Date(timeEnd.value);

	const dayS = timeStartValue.getDate();
	const monthS = timeStartValue.getMonth() + 1;
	const yearS = timeStartValue.getFullYear();

	const dayE = timeEndValue.getDate();
	const monthE = timeEndValue.getMonth() + 1;
	const yearE = timeEndValue.getFullYear();

	const total = document.getElementById('total-price');
	const pay25 = document.getElementById('pay25');
	const pay100 = document.getElementById('pay100');

	const currentDate = new Date();
	const year = currentDate.getFullYear();
	const month = currentDate.getMonth() + 1; 
	const day = currentDate.getDate();
	
	let check = false;
	
	if(isNaN(timeStartValue.getTime()) || isNaN(timeEndValue.getTime())){
		check = true;
	}

	if(year > yearS){
		check = true;
	}
	if(year == yearS && month > monthS){
		check = true;
	}
	if(year == yearS && month == monthS && day > dayS){
		check = true;
	}
	if(year == yearS && month == monthS && day == dayS){
		check = true;
	}
	
	if(yearS > yearE){
		check = true;
	}
	if(yearS == yearE && monthS > monthE){
		check = true;
	}
	if(yearS == yearE && monthS == monthE && dayS > dayE){
		check = true;
	}
	if(yearS == yearE && monthS == monthE && dayS == dayE){
		check = true;
	}
    
	if(check){
		total.value = "";
		pay25.value = "";
		pay25.textContent = "";
		pay100.value = "";
		pay100.textContent = "";
		return;
	}

	const timestamp1 = timeStartValue.getTime();
	const timestamp2 = timeEndValue.getTime();

	const secondsDiff = Math.abs(timestamp2 - timestamp1) / 1000;

	const daysDiff = Math.floor(secondsDiff / (60 * 60 * 24));

	console.log("Số ngày giữa hai ngày:", daysDiff);

	const Price = document.getElementById("Price").value;
	total.value = daysDiff * Price;
	pay25.value = daysDiff * Price * 25 / 100;
	pay25.textContent = "Tra truoc 25 % = " + daysDiff * Price * 25 / 100;
	pay100.value = daysDiff * Price;
	pay100.textContent = "Thanh toan phong 100% = " + daysDiff * Price;
})

var timeEnd = document.getElementById('ComeOutDate');

</script>
</body>
</html>