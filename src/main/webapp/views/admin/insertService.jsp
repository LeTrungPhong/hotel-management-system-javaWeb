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
<div class="form-container">
    <h2>Thêm loại dịch vụ</h2>
    <form action="submit_new_service.php" method="POST">
        <div class="image-upload-container">
            <label for="serviceImage">Đường dẫn hình ảnh minh họa:</label>
            <input type="text" id="serviceImage" name="serviceImage" required>
            <img id="previewImage" src="#" alt="Preview">
        </div>

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