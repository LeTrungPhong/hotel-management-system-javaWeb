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
        }
        .container {
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
        .form-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 600px;
            margin: 20px auto;
        }
        .form-container label {
            display: block;
            margin-bottom: 10px;
        }
        .form-container input[type="text"], 
        .form-container input[type="number"],
        .form-container input[type="date"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container button {
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .form-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body class="container">
<jsp:include page="../general/header/header.jsp"/>  
<div class="employee-container">
    <div class="employee">
        <img src="https://via.placeholder.com/80" alt="Avatar">
        <div class="employee-info">
            <h3>Trung Đẹp Trai</h3>
            <p>Số CCCD: 123456789</p>
            <p>Ngày sinh: 01/01/2004</p>
            <p>Số điện thoại: 0987654321</p>
        </div>
        <div class="action-buttons">
            <button class="edit-button" onclick="editEmployee()">Chỉnh sửa</button>
            <button class="suspend-button" onclick="suspendEmployee()">Đình chỉ</button>
        </div>
    </div>

    <div class="employee">
        <img src="https://via.placeholder.com/80" alt="Avatar">
        <div class="employee-info">
            <h3>Phong Phúng Phính</h3>
            <p>Số CCCD: 987654321</p>
            <p>Ngày sinh: 02/02/2004</p>
            <p>Số điện thoại: 0123456789</p>
        </div>
        <div class="action-buttons">
            <button class="edit-button" onclick="editEmployee()">Chỉnh sửa</button>
            <button class="suspend-button" onclick="suspendEmployee()">Đình chỉ</button>
        </div>
    </div>
    
    <div class="employee">
        <img src="https://via.placeholder.com/80" alt="Avatar">
        <div class="employee-info">
            <h3>Hoàng Mập Địt</h3>
            <p>Số CCCD: 987654321</p>
            <p>Ngày sinh: 02/02/2004</p>
            <p>Số điện thoại: 0123456789</p>
        </div>
        <div class="action-buttons">
            <button class="edit-button" onclick="editEmployee()">Chỉnh sửa</button>
            <button class="suspend-button" onclick="suspendEmployee()">Đình chỉ</button>
        </div>
    </div>

</div>

<div class="add-button">
    <button onclick="window.location.href='<%= url.urlServer + "insertStaff" %>'">Thêm nhân viên</button>
</div>

<div class="form-container">
    <h2>Chỉnh sửa thông tin nhân viên</h2>
    <form action="submit_edited_employee.php" method="POST">
        <label for="employeeName">Họ và tên:</label>
        <input type="text" id="employeeName" name="employeeName" value="Phong Phúng Phính" required>

        <label for="employeeID">Số CCCD:</label>
        <input type="text" id="employeeID" name="employeeID" value="123456789" required>

        <label for="employeeDOB">Ngày sinh:</label>
        <input type="text" id="employeeDOB" name="employeeDOB" required>

        <label for="employeePhone">Số điện thoại:</label>
        <input type="text" id="employeePhone" name="employeePhone" value="0987654321" required>

        <button type="submit">Lưu thay đổi</button>
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
</script>
</body>
</html>