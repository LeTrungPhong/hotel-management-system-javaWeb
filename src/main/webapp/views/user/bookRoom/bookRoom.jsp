<%@page import="java.util.ArrayList"%>
<%@page import="com.appManageHotel.model.DAO.TypeRoomDAOimpl"%>
<%@page import="com.appManageHotel.controller.cookie.cookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.controller.url.*" %>
<%@ page import="com.appManageHotel.model.BEAN.*" %>
<%@ page import="com.appManageHotel.model.DAO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
        body {
            font-family: Arial, sans-serif;
            
            margin: 0;
            padding: 0;
        }
        
        .container {
        	position: relative;
        	background-color: #f4f4f4;
        	display: flex;
        	justify-content: center;
        	align-items: center;
        }

        .container-content {
        	max-width: 550px;
        	top: 15%;
        	position: absolute;
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

        .input-style {
            width: calc(100% - 5px);
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .input-submit {
            background-color: #4caf50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        .input-submit:hover {
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

        .img_room_booking {
            width: 100%;
            border-radius: 10px;
            margin-bottom: 15px;
        }
        
        .sidebar {
            position: fixed;
            top: 15%;
            width: 440px;
            height: 100%;
            background-color: white;
            overflow-y: auto;
            box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        .sidebar-left {
            border-top-right-radius: 5px;
            left: 0;
        }
        .sidebar-right {
            border-top-left-radius: 5px;
            right: 0;
        }
        .sidebar-right h2 {
        	display: block;
    		font-size: 1.5em;
    		margin-block-start: 0.83em;
    		margin-block-end: 0.83em;
    		margin-inline-start: 0px;
    		margin-inline-end: 0px;
    		font-weight: bold;
    		unicode-bidi: isolate;
        }
        .sidebar-right p {
        	display: block;
   			margin-block-start: 1em;
    		margin-block-end: 1em;
    		margin-inline-start: 0px;
    		margin-inline-end: 0px;
    		unicode-bidi: isolate;
        }
        .sidebar-right ul {
        	display: block;
    		list-style-type: disc;
    		margin-block-start: 1em;
    		margin-block-end: 1em;
    		margin-inline-start: 0px;
    		margin-inline-end: 0px;
    		padding-inline-start: 40px;
    		unicode-bidi: isolate;
        }
        .slider {
            position: relative;
            height: 300px;
            width: 100%;
            overflow: hidden;
        }
        .slides {
            display: flex;
            transition: transform 0.5s ease-in-out;
        }
        .slides img {
            width: 100%;
            height: 300px;
            object-fit: cover;
            border-radius: 5px;
        }
        .slide-buttons {
            position: absolute;
            top: 50%;
            width: 100%;
            display: flex;
            justify-content: space-between;
            transform: translateY(-50%);
        }
        .slide-buttons button {
            background-color: rgba(0, 0, 0, 0.5);
            border: none;
            color: white;
            padding: 10px;
            cursor: pointer;
        }
        .room-info, .room-details {
            margin-top: 20px;
        }
        .room-info h2, .room-details h2 {
            margin-top: 0;
        }
        .room-info p {
        	display: block;
   			margin-block-start: 1em;
    		margin-block-end: 1em;
    		margin-inline-start: 0px;
    		margin-inline-end: 0px;
    		unicode-bidi: isolate;
        }
    </style>
</head>
<body>
	<jsp:include page="../header/header.jsp"/> 
	
	<% 
		Customer customer = request.getAttribute("Customer") != null ? (Customer)request.getAttribute("Customer") : null; 
		String IDTypeRoom = request.getParameter("IDTypeRoom") != null ? (String)request.getParameter("IDTypeRoom") : "";
		TypeRoom typeRoom = !IDTypeRoom.equals("") ? TypeRoomDAOimpl.getInstance().selectByID(IDTypeRoom) : null;
	%>
	
	<div class="sidebar sidebar-right">
        <div class="room-details">
            <h2>Mô tả chi tiết</h2>
            <p><%= typeRoom != null ? typeRoom.getDescription() : "" %></p>
            <h2>Điểm thu hút</h2>
            <ul>
                <li>Tầm nhìn ra biển</li>
                <li>Ban công riêng</li>
                <li>Bồn tắm</li>
                <li>Truy cập hồ bơi và phòng gym miễn phí</li>
            </ul>
            <h2>Số lượng người tiêu chuẩn</h2>
            <p>Người lớn: <%= typeRoom != null ? typeRoom.getMaxAdult() : "" %></p>
            <p>Trẻ em: <%= typeRoom != null ? typeRoom.getMaxChild() : "" %></p>
            <h2>Phụ phí khi thêm người</h2>
            <p>Người lớn thêm: <%= typeRoom != null ? typeRoom.getPrice() * 20/100 : "" %>/đêm</p>
            <p>Trẻ em thêm: <%= typeRoom != null ? typeRoom.getPrice() * 10/100 : "" %>/đêm</p>
        </div>
    </div>

    <div class="sidebar sidebar-left">
        <div class="slider">
            <div class="slides">
                <img src="https://centerhotelbacninh.com/sites/c/ce/centerhotel/uploads/plugins/light-gallery/C%C4%83n%20h%E1%BB%99%201.jpg" alt="Room Image 1">
                <img src="https://centerhotelbacninh.com/sites/c/ce/centerhotel/uploads/plugins/light-gallery/C%C4%83n%20h%E1%BB%99%201.jpg" alt="Room Image 2">
                <img src="https://pistachiohotel.com/UploadFile/Gallery/Overview/a3.jpg" alt="Room Image 3">
            </div>
            <div class="slide-buttons">
                <button id="prevBtn">&lt;</button>
                <button id="nextBtn">&gt;</button>
            </div>
        </div>
        <div class="room-info">
            <h2><%= typeRoom != null ? typeRoom.getTypeRoomName() : "" %></h2>
            <p>Giá: $<%= typeRoom != null ? typeRoom.getPrice() : "" %>/đêm</p>
            <p>Diện tích: 50m²</p>
            <h3 style="margin: 2px 0px;">Tiện nghi:</h3>
            <%
            	if(typeRoom != null){
            		ArrayList<Facility> listFacility = FacilityDAOimpl.getInstance().selectByIDTypeRoom(typeRoom.getIDTypeRoom());
            		if(listFacility != null){
            			for(int i = 0; i < listFacility.size(); ++i){
            				%>
            					<p><%= listFacility.get(i).getFacilityName() %></p>
            				<% 
            			}
            		}
            	}
            %>
        </div>
    </div>
	
	<div class="container-content">
		<h2>Thông Tin Đặt Phòng Khách Sạn</h2>
    <form action="<%= url.urlServer + "bookRoom" %>" id="form-submit" method="post" onsubmit="return validateInput()">
        <img class="img_room_booking" src="https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg" alt="">
		<input type="text" style="display: none" class="dp-n" name="IDTypeRoom" value="<%= typeRoom != null ? typeRoom.getIDTypeRoom() : "" %>">
        <label for="FullName">Họ và Tên:</label>
        <input 
        	type="text" 
        	class="input-style"
        	id="FullName" 
        	name="FullName" 
        	value="<%= customer != null ? customer.getFullName() : "" %>" 
        	required
        	<%= customer != null ? "readonly" : "" %>
        >

        <label for="SDT">Số Điện Thoại:</label>
        <input 
        	type="text" 
        	class="input-style"
        	id="SDT" 
        	name="SDT" 
        	value="<%= customer != null ? customer.getSDT() : "" %>" 
        	required
        	<%= customer != null ? "readonly" : "" %>
        >
         
        <select  name="Gender" class="input-style">
        	<option <%= (customer != null && customer.getGender().equals("female")) ? "selected" : "" %> value="female">Female</option>
        	<option <%= (customer != null && customer.getGender().equals("male")) ? "selected" : "" %> value="male">Male</option>
        </select>

		<%
			String timeStart = request.getParameter("timeStart") != null ? (String)request.getParameter("timeStart") : "";
			timeStart = !timeStart.equals("") ? timeStart.substring(6,10) + "-" + timeStart.substring(0,2) + "-" + timeStart.substring(3,5) : "";
			
			String timeEnd = request.getParameter("timeEnd") != null ? (String)request.getParameter("timeEnd") : "";
			timeEnd = !timeEnd.equals("") ? timeEnd.substring(6,10) + "-" + timeEnd.substring(0,2) + "-" + timeEnd.substring(3,5) : "";
		%>

        <label for="ComeInDate">Ngày Nhận Phòng:</label>
        <input class="input-style" type="date" id="ComeInDate" name="ComeInDate" value="<%= timeStart %>" required>

        <label for="ComeOutDate">Ngày Trả Phòng:</label>
        <input class="input-style" type="date" id="ComeOutDate" name="ComeOutDate" value="<%= timeEnd %>" required>

        <label for="TypeRoomName">Loại Phòng:</label> 
        <input class="input-style" type="text" id="TypeRoomName" name="TypeRoomName" value="<%= typeRoom != null ? typeRoom.getTypeRoomName() : "" %>" required readonly >

        <div class="input-group">
            <label for="NumberAdult">Người Lớn:</label>
            <input class="input-style" type="number" id="NumberAdult" name="NumberAdult" value="1" min="1" max="<%= typeRoom != null ? typeRoom.getMaxAdult() + 2 : 1 %>">
        </div>
        
        <div class="input-group">
            <label for="NumberChild">Trẻ Em:</label>
            <input class="input-style" type="number" id="NumberChild" name="NumberChild" value="0" min="0" max="<%= typeRoom != null ? typeRoom.getMaxChild() + 2 : 0 %>">
        </div>
        
        <label for="Price">Đơn Giá 1 Đêm: </label>
        <input class="input-style" type="text" id="Price" name="Price" readonly value="<%= typeRoom != null ? typeRoom.getPrice() : "" %>" readonly required>
        
        <label for="surcharge">Phụ thu: </label>
        <input class="input-style" type="text" id="surcharge" name="surcharge" readonly value="0" readonly required>

        <label for="total-price">Tổng Tiền:</label>
        <input class="input-style" type="text" id="total-price" readonly name="total-price" readonly required>

		<select name="payPrice" class="input-style">
			<option selected id="pay25"></option>
			<option id="pay100"></option>
		</select>
		
        <input class="input-submit" type="submit" value="Tiến hành thanh toán">
    </form>
	</div>
<script>

const slides = document.querySelector('.slides');
const prevBtn = document.getElementById('prevBtn');
const nextBtn = document.getElementById('nextBtn');
let currentIndex = 0;

function showSlide(index) {
    const totalSlides = slides.children.length;
    if (index >= totalSlides) {
        currentIndex = 0;
    } else if (index < 0) {
        currentIndex = totalSlides - 1;
    } else {
        currentIndex = index;
    }
    slides.style.transform = "translateX(-" + currentIndex * 100 + "%)";
    console.log("123");
}

nextBtn.addEventListener('click', () => {
    showSlide(currentIndex + 1);
});

prevBtn.addEventListener('click', () => {
    showSlide(currentIndex - 1);
});

showSlide(currentIndex);



const urlParams = new URLSearchParams(window.location.search);

const paramValue = urlParams.get('show');
if(paramValue){
	alert(paramValue);
	window.location.href="<%= url.urlServer + "receipt?IDIFBookRoom="%> + <%=request.getParameter("IDIFBookRoom") != null ? request.getParameter("IDIFBookRoom") : "" %>";
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

function changeTotal (){
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

	let Price = parseInt(document.getElementById("Price").value);

	const surchargeAdult = document.getElementById('NumberAdult').value - <%= typeRoom != null ? typeRoom.getMaxAdult() : 1 %>;
	const surchargeChild = document.getElementById('NumberChild').value - <%= typeRoom != null ? typeRoom.getMaxChild() : 0 %>;

	let surcharge = 0;

	if(surchargeAdult > 0){
		surcharge = surcharge + Price * 20 * surchargeAdult / 100;
	}

	if(surchargeChild > 0){
		surcharge = surcharge + Price * 10 * surchargeChild / 100;
	}
	
	document.getElementById('surcharge').value = surcharge;
	Price = Price + surcharge;
	
	total.value = daysDiff * Price;
	pay25.value = daysDiff * Price * 25 / 100;
	pay25.textContent = "Tra truoc 25 % = " + daysDiff * Price * 25 / 100;
	pay100.value = daysDiff * Price;
	pay100.textContent = "Thanh toan phong 100% = " + daysDiff * Price;
}

changeTotal();

document.getElementById('NumberAdult').addEventListener('input', () => {
	changeTotal();
})

document.getElementById('NumberChild').addEventListener('input', () => {
	changeTotal();
})

timeStart.addEventListener('input', () => {
	changeTotal();
})

timeEnd.addEventListener('input', () => {
	changeTotal();
})

var timeEnd = document.getElementById('ComeOutDate');

</script>
</body>
</html>