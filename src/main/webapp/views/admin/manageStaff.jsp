<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.controller.url.*" %>
<%@ page import="com.appManageHotel.model.DAO.*" %>
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
            padding: 20px;
        }
        .container {
        	position: relative;
        	margin-top: 150px;
        }
        .employee-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
        }
        .employee { 
            border-bottom: 1px solid #ccc;
            padding-bottom: 20px;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
        }
        .employee:last-child {
            border-bottom: none;
            padding-bottom: 0;
            margin-bottom: 0;
        }
        .employee img {
            width: 80px;
            height: 80px;
            border-radius: 50%;
            margin-right: 20px;
        }
        .employee-info {
            flex-grow: 1;
        }
        .employee-info h3 {
            margin: 0;
        }
        .employee-info p {
            margin: 5px 0;
        }
        .action-buttons {
            display: flex;
            align-items: center;
        }
        .action-buttons button {
            cursor: pointer;
            border: none;
            border-radius: 5px;
            padding: 5px 10px;
            margin-right: 10px;
            font-size: 14px;
            transition: background-color 0.3s;
        }
        .edit-button {
            background-color: #4CAF50;
            color: white;
        }
        .edit-button:hover {
            background-color: #45a049;
        }
        .suspend-button {
            background-color: #f44336;
            color: white;
        }
        .suspend-button:hover {
            background-color: #c6392d;
        }
        .add-button {
            position: fixed;
            right: 20px;
            bottom: 20px;
        }
        .add-button button {
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .add-button button:hover {
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
        .form-container-update label{
            display: block;
            margin-bottom: 10px;
        }
        .form-container input[type="text"], 
        .form-container input[type="number"],
        .form-container input[type="date"],
        .form-container-update input[type="text"], 
        .form-container-update input[type="number"],
        .form-container-update input[type="date"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container button,
        .form-container-update button {
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
        .form-container-update button:hover {
            background-color: #45a049;
        }
        .background-shadow {
        	position: fixed;
        	top: 0px;
        	left: 0px;
        	width: 100%;
        	height: 100%;
        	z-index: 4;
        	background-color: rgba(0,0,0,0.2);
        }
    </style>
</head>
<body class="container">
<jsp:include page="../general/header/header.jsp"/>  
<div class="employee-container">
    <%
    	ArrayList<Staff> listStaff = StaffDAOimpl.getInstance().selectAll();
    	if(listStaff != null){
    		for(int i = 0; i < listStaff.size(); ++i){
    			String IDStaff = listStaff.get(i).getIDStaff();
    			String FullName = listStaff.get(i).getFullName();
    			String CCCD = listStaff.get(i).getCCCD();
    			String IDAccount = listStaff.get(i).getIDAccount();
    			boolean State = listStaff.get(i).getState();
    			%>
    				<div class="employee">
        				<img src="https://via.placeholder.com/80" alt="Avatar">
        				<div class="employee-info">
            				<h3>Họ và tên: <%= FullName %></h3>
            				<p>Số CCCD: <%= CCCD %></p>
            				<p>Trạng thái: <%= State %></p>
        				</div>
        				<div class="action-buttons">
            				<button class="edit-button" onclick="displayFormUpdate('<%= IDStaff %>','<%= FullName %>','<%= CCCD %>','<%= IDAccount %>',<%= State %>)">Chỉnh sửa</button>
            				<button class="suspend-button" onclick="layOffStaff('<%= IDStaff %>')">Đình chỉ</button>
        				</div>
    				</div>
    			<%
    		}
    	}
    %>
</div>

<form action="<%= url.urlServer + "manageStaff" %>" class="dp-n" method="post">
     <input type="text" class="layOffStaff" name="IDStaff">
     <input type="text" name="type" value="layOffStaff">
     <input type="submit" class="submitLayoff">
</form>

<div class="add-button">
    <button onclick="displayFormInsert()">Thêm nhân viên</button>
</div>

<div class="background-shadow dp-n"></div>
 
<div class="form-container dp-n">
    <h2 style="margin-bottom: 10px">Thêm nhân viên</h2>
    <form action="<%= url.urlServer + "manageStaff" %>" method="post">
        <label for="FullName">Họ và tên:</label>
        <input type="text" id="FullName" name="FullName" required>

        <label for="CCCD">Số CCCD:</label>
        <input type="text" id="CCCD" name="CCCD" required>

        <label for="UserName">Tên tài khoản:</label>
        <input type="text" id="UserName" name="UserName" required>

        <label for="PassWord">Mật khẩu:</label>
        <input type="text" id="PassWord" name="PassWord" required>

		<input type="text" class="dp-n" name="type" value="insertStaff">
        <button type="submit">Thêm</button>
    </form>
</div>

<div class="form-container-update dp-n">
    <h2 style="margin-bottom: 10px">Sửa nhân viên</h2>
    <form action="<%= url.urlServer + "manageStaff" %>" method="post">
        <label for="FullNameUpdate">Họ và tên:</label>
        <input type="text" id="FullNameUpdate" name="FullName" required>

        <label for="CCCDUpdate">Số CCCD:</label>
        <input type="text" id="CCCDUpdate" name="CCCD" required>
        
        <input type="text" id="IDStaffUpdate" name="IDStaff" class="dp-n">
		<input type="text" id="StateUpdate" name="State" class="dp-n">
		<input type="text" id="IDAccountUpdate" name="IDAccount" class="dp-n">
		<input type="text" class="dp-n" name="type" value="updateStaff">
        <button type="submit">Sửa</button>
    </form>
</div>

<script>
    function editEmployee() {
        // Redirect to the page for editing employee information
        window.location.href = "edit_employee.html";
    }

    function suspendEmployee() {
        // Add logic to suspend employee here
        alert("Nhân viên đã bị đình chỉ.");
    }

    function addEmployee() {
        // Redirect to the page for adding a new employee
        window.location.href = "add_employee.html";
    }
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $( function() {
        $( "#employeeDOB" ).datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            yearRange: "-100:+0"
        });
    });

	var formContainer = document.querySelector('.form-container');
	var backgroundShadow = document.querySelector('.background-shadow');
	var formContainerUpdate = document.querySelector('.form-container-update');
    
    function displayFormInsert(){
    	backgroundShadow.classList.remove('dp-n');
    	formContainer.classList.remove('dp-n');
    }

    backgroundShadow.addEventListener('click', () => {
    	backgroundShadow.classList.add('dp-n');
    	formContainer.classList.add('dp-n');
    	formContainerUpdate.classList.add('dp-n');
    });

    function displayFormUpdate(IDStaff,FullName,CCCD,IDAccount,State){

    	document.getElementById('IDStaffUpdate').value = IDStaff;
		document.getElementById('FullNameUpdate').value = FullName;
		document.getElementById('CCCDUpdate').value = CCCD;
		document.getElementById('StateUpdate').value = State;
		document.getElementById('IDAccountUpdate').value = IDAccount;

        
    	backgroundShadow.classList.remove('dp-n');
    	formContainerUpdate.classList.remove('dp-n');
    }

    function layOffStaff(IDStaff){
		document.querySelector('.layOffStaff').value = IDStaff;
		document.querySelector('.submitLayoff').click();
    }
</script>
</body>
</html>