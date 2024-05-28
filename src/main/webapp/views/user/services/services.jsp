<%@page import="com.appManageHotel.model.BEAN.Service"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.model.DAO.*" %>
<%@ page import="com.appManageHotel.controller.url.*" %>
<%@ page import="com.appManageHotel.model.BEAN.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
        /* Thêm CSS để trang web trở nên đẹp hơn */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        * {
            box-sizing: border-box;
        }
        .container {
        	position: relative;
        	width: 100%;
        	height: 100%;
        	display: flex;
        	justify-content: center;
        	align-items: center;
        }
        .container-service {
        	position: absolute;
            max-width: 1300px;
			top: 20%;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-evenly;
            flex-wrap: wrap;
            gap: 20px;
        }
        h1 {
            text-align: center;
        }
        .service {
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            position: relative;
            overflow: hidden;
            width: 400px;
        }
        .service h2 {
            margin-top: 0;
            font-size: 24px;
            color: #333;
        }
        .service p {
            margin-bottom: 10px;
            color: #666;
        }
        .service img {
            width: 100%;
            height: auto;
            margin-bottom: 15px;
            border-radius: 8px;
        }
        .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            opacity: 0;
            transition: opacity 0.3s ease;
            border-radius: 8px;
        }
        .service:hover .overlay {
            opacity: 1;
        }
        .service:hover .service-details {
            transform: translateY(0);
        }
        .service-details {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 400px;
            padding: 20px;
            word-wrap: break-word;
            transform: translateY(100%);
            transition: transform 0.3s ease;
            background-color: rgba(255, 255, 255, 0.9);
            border-bottom-left-radius: 8px;
            border-bottom-right-radius: 8px;
        }
        #form-submit{
        	position: fixed;
        	padding: 20px; 
        	border-radius: 5px;
        	background-color: #fff;
        	z-index: 5;
        	top: 50%;
        	left: 50%;
        	transform: translate(-50%,-50%);
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
        
        .select {
            padding: 10px !important;
            margin: 5px 0 !important;
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

/*         input[readonly] {
            background-color: #f4f4f4;
            cursor: not-allowed;
        } */

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
        
        .background-shadow {
        	background-color: rgba(0,0,0,0.2);
        	position: fixed;
        	width: 100%;
        	height: 100%;
        	top: 0;
        	left: 0;
        	z-index: 4;
        }
        .button-service {
        	all: unset;
        	cursor: pointer;
        }
        .dp-n {
        	display: none;
        }
    </style>
</head>
<body class="container">
	<jsp:include page="../header/header.jsp"/> 
	
	<div class="container-service">
	<%
		ArrayList<Service> listService = request.getAttribute("listService") != null ? (ArrayList<Service>)request.getAttribute("listService") : null;

		if(listService != null){
			for(int i = 0; i < listService.size(); ++i){
				String IDService = listService.get(i).getIDService();
    			String ServiceName = listService.get(i).GetServiceName();
    			int Price = listService.get(i).getPrice();
    			String Description = listService.get(i).getDescription();
    			String IDImage = listService.get(i).getIDImage();
    			String Path = ImageDAOimpl.getInstance().selectByID(IDImage).getPath();
    			int NumberUse = listService.get(i).getNumberUse();
				%>
					<button class="button-service" onclick="bookService('<%= ServiceName %>',<%= Price %>,'<%= Path %>','<%= IDService %>')">
        				<div class="service">
            				<img src="<%= Path %>" alt="">
            				<div class="overlay"></div>
            				<div class="service-details">
                				<h2><%= ServiceName %></h2>
                				<p><%= Description %></p>
                				<p>Giá: <%= Price %></p>
           					</div>
        				</div>
    				</button>
				<%
			}
		}
	%>
	</div>
	
	<div class="background-shadow dp-n"></div>
	
	<%
		
	%>
	
	<form class="dp-n" action="<%= url.urlServer + "services" %>" id="form-submit" method="post" onsubmit="return validateInput()">
        <img style="max-width: 400px;" class="img_room_booking" src="https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg" alt="">
        
      <div style="display: flex; flex-direction: columns; gap: 10px;">
    <div style="min-width: 350px;">
        <label for="FullName">Họ và tên: </label>
        <input 
        	class="input-style"
        	type="text" 
        	id="FullName" 
        	name="FullName" 
        	value=""
        	required>
        
        <label for="SDT">Số điện thoại: </label>
        <input 
        	class="input-style"
        	type="text"  
        	id="SDT" 
        	name="SDT" 
        	required>
        
        <label for="SDT">CCCD: </label>
        <input 
        	class="input-style"
        	type="text" 
        	id="CCCD" 
        	name="CCCD" 
        	required>
        <label for="Birth">Ngày sinh: </label>
        <input 
        	class="input-style"
        	type="date" 
        	id="Birth" 
        	name="Birth" 
        	required>
        <label for="Gender">Giới tính: </label>
        <select class="select input-style" name="Gender">
        	<option value="male">Male</option>
        	<option value="female">Female</option>
        </select>
     </div>
        
     <div style="min-width: 350px;">
        <label for="ServiceName">Tên dịch vụ: </label>
        <input class="input-style" type="text" id="ServiceName" name="ServiceName" readonly required>
        
        <label for="Number">Số lượng: </label>
        <input class="input-style" type="Number" id="Number" name="Number" value="1" min="1" required>
        
        <label for="UseDate">Thời điểm sử dụng dịch vụ: </label>
        <input class="input-style" type="date" id="UseDate" name="UseDate" required>
        
        <label for="Price">Giá dịch vụ: </label>
        <input class="input-style" type="text" id="Price" name="Price" readonly required>
        
        <input type="text" id="IDService" name="IDService" class="dp-n">
        
        <label for="total">Tổng Tiền:</label>
        <input class="input-style" type="text" id="total" name="Total" readonly required>
     </div>
      </div>
		
        <input class="input-submit" type="submit" value="Xác nhận đặt dịch vụ">
    </form>
    
<script>

	const urlParams = new URLSearchParams(window.location.search);
	const paramValue = urlParams.get('show');
	if(paramValue){
		alert(paramValue);
	}

	var formSubmit = document.getElementById('form-submit');
	var backgroundShadow = document.querySelector('.background-shadow');

	var ServiceNameInput = document.getElementById('ServiceName');
	var PriceInput = document.getElementById('Price');
	var imgRoomBooking = document.querySelector('.img_room_booking');
	var TotalInput = document.getElementById('total');
	var NumberInput = document.getElementById('Number');
	var CCCDInput = document.getElementById('CCCD');
	var SDTInput = document.getElementById('SDT');
	var FullNameInput = document.getElementById('FullName');
	var IDServiceInput = document.getElementById('IDService');

	function bookService(ServiceName, Price, Path, IDService){
		formSubmit.classList.remove('dp-n');
		backgroundShadow.classList.remove('dp-n');

		ServiceNameInput.value = ServiceName;
		PriceInput.value = Price;
		imgRoomBooking.src = Path;
		IDServiceInput.value = IDService;

		TotalInput.value = Price * parseInt(NumberInput.value);
	}

	NumberInput.addEventListener('input',() => {
		TotalInput.value = parseInt(PriceInput.value) * parseInt(NumberInput.value);
	})

	backgroundShadow.addEventListener('click', () => {
		formSubmit.classList.add('dp-n');
		backgroundShadow.classList.add('dp-n');
	});

	function validateInput(){
		if(CCCDInput.value.length != 12){
			alert('Dinh dang CCCD khong dung.');
			return false;
		}
		if(SDTInput.value.length != 10){
			alert('SDT phai du 10 so.');
			return false;
		}
		return true;
	}


	// Lấy ngày hiện tại
	  var today = new Date().toISOString().split('T')[0];
	  // Thiết lập giá trị mặc định của input là ngày hiện tại
	  document.getElementById('UseDate').value = today;

	  // Ngăn chọn thời gian trong quá khứ
	  document.getElementById('UseDate').addEventListener('input', function() {
	    var selectedDate = new Date(this.value);
	    var now = new Date();
	    if (selectedDate < now) {
	      this.value = today; // Nếu người dùng chọn ngày trong quá khứ, thiết lập lại thành ngày hiện tại
	    }
	  });
	
</script>
</body>
</html>