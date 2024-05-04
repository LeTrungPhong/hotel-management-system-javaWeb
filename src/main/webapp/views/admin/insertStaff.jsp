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
            padding: 20px;
        }
        .container {
        	margin-top: 150px;
        }
        .form-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 600px;
            margin: 0 auto;
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

        <label for="employeeAvatar">Link ảnh đại diện:</label>
        <input type="text" id="employeeAvatar" name="employeeAvatar" required>

        <button type="submit">Lưu thay đổi</button>
    </form>
</div>

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