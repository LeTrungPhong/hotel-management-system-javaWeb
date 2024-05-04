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
        .form-container input[type="number"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .image-container {
            margin-bottom: 20px;
        }
        .image-container input[type="text"] {
            width: calc(80% - 20px);
        }
        .image-container button {
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 5px 10px;
            margin-left: 10px;
        }
        .add-image-button,
        .save-changes-button {
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            margin-top: 10px;
            transition: background-color 0.3s;
        }
        .add-image-button:hover,
        .save-changes-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body class="container">
<jsp:include page="../general/header/header.jsp"/> 
<div class="form-container">
    <h2>Chỉnh sửa thông tin loại phòng</h2>
    <form action="submit_edited_room_type" method="POST">
        <label for="roomName">Tên loại phòng:</label>
        <input type="text" id="roomName" name="roomName" required>

        <label for="maxAdults">Số người tối đa (người lớn):</label>
        <input type="number" id="maxAdults" name="maxAdults" required>

        <label for="maxChildren">Số người tối đa (trẻ em):</label>
        <input type="number" id="maxChildren" name="maxChildren" required>

        <label for="roomPrice">Giá:</label>
        <input type="number" id="roomPrice" name="roomPrice" required>

        <div class="image-container">
            <label for="roomImages">Đường dẫn hình ảnh phòng:</label>
            <input type="text" id="roomImages" name="roomImages[]" required>
            <button class="add-image-button" type="button" onclick="addInputField()">Thêm</button>
        </div>

        <button class="save-changes-button" type="submit">Lưu thay đổi</button>
    </form>
</div>

<script>
    function addInputField() {
        const imageContainer = document.createElement('div');
        imageContainer.className = 'image-container';

        const input = document.createElement('input');
        input.type = 'text';
        input.name = 'roomImages[]';
        input.required = true;

        const addButton = document.createElement('button');
        addButton.textContent = 'Thêm';
        addButton.className = 'add-image-button';
        addButton.type = 'button';
        addButton.onclick = addInputField;

        const removeButton = document.createElement('button');
        removeButton.textContent = 'Xóa';
        removeButton.style.backgroundColor = '#f44336';
        removeButton.style.color = 'white';
        removeButton.style.border = 'none';
        removeButton.style.borderRadius = '5px';
        removeButton.style.padding = '5px 10px';
        removeButton.style.marginLeft = '10px';
        removeButton.onclick = function () {
            imageContainer.remove();
        };

        imageContainer.appendChild(input);
        imageContainer.appendChild(addButton);
        imageContainer.appendChild(removeButton);

        const form = document.querySelector('.form-container form');
        form.insertBefore(imageContainer, form.lastElementChild);
    }
</script>
</body>
</html>