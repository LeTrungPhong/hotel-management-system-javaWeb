<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.controller.url.*" %>
<%@ page import="com.appManageHotel.model.DAO.*" %>
<%@ page import="com.appManageHotel.model.BEAN.*" %>
<%@page import="java.util.ArrayList"%>
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
        }
        .container {
        	position: relative;
        	margin-top: 150px;
        }
        .service-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
        }
        .service {
            border-bottom: 1px solid #ccc;
            padding-bottom: 20px;
            margin-bottom: 20px;
        }
        .service:last-child {
            border-bottom: none;
            padding-bottom: 0;
            margin-bottom: 0;
        }
        .service img {
            width: 100px;
            border-radius: 5px;
            margin-right: 20px;
        }
        .service-info {
            display: flex;
            align-items: center;
        }
        .service-info h3 {
            margin: 0;
        }
        .service-info p {
            margin: 5px 0;
        }
        .button-container {
            text-align: right;
            margin-top: 20px;
        }
        .button-container button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .button-container button:hover {
            background-color: #45a049;
        }
        .form-container,
        .form-container-update {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 40%; 
            margin: 20px auto;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            z-index: 5;
        }
        .form-container label,
        .form-container-update label {
            display: block;
            margin-bottom: 10px;
        }
        .form-container input[type="text"],
        .form-container input[type="number"],
        .form-container textarea,
        .form-container-update input[type="text"],
        .form-container-update input[type="number"],
        .form-container-update textarea{
            width: calc(100% - 20px);
            padding: 10px; 
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container button,
        .form-container-update button{
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .form-container button:hover,
        .form-container-update button:hover{
            background-color: #45a049;
        } 
        .image-upload-container {
            margin-bottom: 20px;
        }
        .image-upload-container label {
            display: block;
            margin-bottom: 10px;
        }
        .image-upload-container input[type="text"] {
            width: calc(100% - 20px);
            padding: 10px; 
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .image-upload-container img {
            max-width: 100%;
            border-radius: 5px;
            display: none;
        }
        .image-upload-container .upload-button {
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .image-upload-container .upload-button:hover {
            background-color: #45a049;
        }
        .background-shadow {
        	position: fixed;
        	z-index: 4;
        	top: 0px;
        	left: 0px;
        	width: 100%;
        	height: 100%;
        	background-color: rgba(0,0,0,0.2);
        }
        .dp-n {
        	display: none;
        }
        .button-add {
        	position: fixed;
            bottom: 2%;
            right: 2%;
        }
    </style>
</head>
<body class="container">
<jsp:include page="navBarAdmin.jsp"/> 
<div class="service-container">
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
    				<div class="service">
        				<div class="service-info">
            				<img src="<%= Path %>" alt="Service Image">
            				<div>
                				<h3>Tên dịch vụ: <%= ServiceName %></h3>
                				<p>Giá: $<%= Price %></p>
                				<p>Số lần đặt: <%= NumberUse %></p>
                				<p>Description: <%= Description %></p>
            				</div>
        				</div>
        				<div class="button-container">
            				<button 
            					onclick="displayFormUpdate(
            						'<%= IDService %>',
            		 				'<%= ServiceName %>',
            						<%= Price %>,
									'<%= Description %>')">
            					Chỉnh sửa
            				</button>
        				</div>
    				</div>
    			<%
    		}
    	}
    %>

    <!-- Add more services here -->

    <div class="button-container button-add">
        <button onclick="displayFormInsert()">Thêm dịch vụ</button>
    </div>
</div>

<div class="background-shadow dp-n"></div>

<div class="form-container dp-n">
    <h2>Thêm loại dịch vụ</h2>
    <form action="<%= url.urlServer + "manageService" %>" method="post">
        <label for="serviceName">Tên dịch vụ:</label>
        <input type="text" id="serviceName" name="ServiceName" required>

        <label for="servicePrice">Giá:</label>
        <input type="number" id="servicePrice" name="Price" step="5" required>

        <label for="serviceDescription">Mô tả:</label>
        <textarea id="serviceDescription" name="Description" rows="4" required></textarea>
        
        <select class="select-image-update" name=IDImage>
      	      <%
      	      		ArrayList<Image> listImage = ImageDAOimpl.getInstance().selectAll();
      	      		if(listImage != null){
      	      			for(int i = 0; i < listImage.size(); ++i){
      	      				%>
      	      					<option value="<%= listImage.get(i).getIDImage() %>"><%= listImage.get(i).getImageName() %></option>
      	      				<%
      	      			}
      	      		}
      	      %>
        </select>
        <br></br>
        <input type="text" name="type" value="insertService" class="dp-n">
        <button>Add</button>
    </form>
</div>

<div class="form-container-update dp-n">
    <h2>Sửa loại dịch vụ</h2>
    <form action="<%= url.urlServer + "manageService" %>" method="post">
    	<input type="text" id="IDService" name="IDService" class="dp-n">
        <label for="ServiceName">Tên dịch vụ:</label>
        <input type="text" id="ServiceName" name="ServiceName" required>

        <label for="Price">Giá:</label>
        <input type="number" id="Price" name="Price" step="5" required>

        <label for="Description">Mô tả:</label>
        <textarea id="Description" name="Description" rows="4" required></textarea>
        
        <select class="select-image-update" name=IDImage>
      	      <%
      	      		listImage = ImageDAOimpl.getInstance().selectAll();
      	      		if(listImage != null){
      	      			for(int i = 0; i < listImage.size(); ++i){
      	      				%>
      	      					<option value="<%= listImage.get(i).getIDImage() %>"><%= listImage.get(i).getImageName() %></option>
      	      				<%
      	      			}
      	      		}
      	      %>
        </select>
        <br></br>
        <input type="text" name="type" value="updateService" class="dp-n">
        <button>Update</button>
    </form>
</div>

<script>

var formContainer = document.querySelector('.form-container');
var backgroundShadow = document.querySelector('.background-shadow'); 
var formContainerUpdate = document.querySelector('.form-container-update');

function displayFormInsert(){
	formContainer.classList.remove('dp-n');
	backgroundShadow.classList.remove('dp-n');
}

function displayFormUpdate(IDService,ServiceName,Price,Description){
	backgroundShadow.classList.remove('dp-n');
	formContainerUpdate.classList.remove('dp-n');

	document.getElementById('IDService').value = IDService;
	document.getElementById('ServiceName').value = ServiceName;
	document.getElementById('Price').value = Price;
	document.getElementById('Description').value = Description;
}

backgroundShadow.addEventListener('click', () => {
	formContainer.classList.add('dp-n');
	backgroundShadow.classList.add('dp-n');
	formContainerUpdate.classList.add('dp-n');
});

</script>
</body>
</html>