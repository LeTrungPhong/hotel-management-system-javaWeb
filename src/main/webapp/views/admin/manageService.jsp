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
        .form-container textarea {
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
    </style>
</head>
<body class="container">
<jsp:include page="../general/header/header.jsp"/> 
<div class="service-container">
    <div class="service">
        <div class="service-info">
            <img src="https://st.depositphotos.com/1518767/4293/i/450/depositphotos_42930411-stock-photo-concentrated-male-chef-garnishing-food.jpg" alt="Service Image">
            <div>
                <h3>Tên dịch vụ 1</h3>
                <p>Giá: $50</p>
            </div>
        </div>
        <div class="button-container">
            <button onclick="editService()">Chỉnh sửa</button>
        </div>
    </div>

    <div class="service">
        <div class="service-info">
            <img src="https://st.depositphotos.com/1518767/4293/i/450/depositphotos_42930411-stock-photo-concentrated-male-chef-garnishing-food.jpg" alt="Service Image">
            <div>
                <h3>Tên dịch vụ 2</h3>
                <p>Giá: $70</p>
            </div>
        </div>
        <div class="button-container">
            <button onclick="editService()">Chỉnh sửa</button>
        </div>
    </div>

    <!-- Add more services here -->

    <div class="button-container">
        <button onclick="window.location.href='<%= url.urlServer + "insertService" %>'">Thêm dịch vụ</button>
    </div>
</div>




<div class="form-container">
    <h2>Thêm loại dịch vụ</h2>
    <form action="submit_new_service.php" method="POST">
        <label for="serviceName">Tên dịch vụ:</label>
        <input type="text" id="serviceName" name="serviceName" required>

        <label for="servicePrice">Giá:</label>
        <input type="number" id="servicePrice" name="servicePrice" required>

        <label for="serviceDescription">Mô tả:</label>
        <textarea id="serviceDescription" name="serviceDescription" rows="4" required></textarea>

        <button type="submit">Thêm dịch vụ</button>
    </form>
</div>




<script>

const serviceImageInput = document.getElementById('serviceImage');
const previewImage = document.getElementById('previewImage');

serviceImageInput.addEventListener('input', function () {
    const imageURL = this.value.trim();
    if (imageURL !== '') {
        previewImage.src = imageURL;
        previewImage.style.display = 'block';
    } else {
        previewImage.src = '#';
        previewImage.style.display = 'none';
    }
});

</script>
</body>
</html>