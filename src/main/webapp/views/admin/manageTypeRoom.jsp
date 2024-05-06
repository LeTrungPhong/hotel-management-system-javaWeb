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
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 50px;
        }
        .container {
        	position: relative;
        	margin-top: 150px;
        }
        .room-type {
        	width: 400px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }
        .room-type img {
            width: 100%;
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
        }
        .room-type-info {
            padding: 20px;
        }
        .room-type-info h2 {
            margin-top: 0;
        }
        .room-type-info p {
            margin: 10px 0;
        }
        .btn-container {
            text-align: center;
            margin-top: 10px;
        }
        .btn-container a {
            text-decoration: none;
        }
        .btn-container button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            margin: 0 10px;
            transition: background-color 0.3s;
        }
        .btn-container button:hover {
            background-color: #45a049;
        }
        .form-container,
        .form-container-update {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 40%;
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
        .form-container-update input[type="text"],
        .form-container-update input[type="number"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container textarea,
        .form-container-update textarea {
        	width: calc(100% - 20px);
        	padding 10px;
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

<%
	ArrayList<TypeRoom> listTypeRoom = TypeRoomDAOimpl.getInstance().selectAll();
	if(listTypeRoom != null){
		for(int i = 0; i < listTypeRoom.size(); ++i){
			String IDTypeRoom = listTypeRoom.get(i).getIDTypeRoom();
			String TypeRoomName = listTypeRoom.get(i).getTypeRoomName();
			int Price = listTypeRoom.get(i).getPrice();
			int MaxAdult = listTypeRoom.get(i).getMaxAdult();
			int MaxChild = listTypeRoom.get(i).getMaxChild();
			int NumberBook = listTypeRoom.get(i).getNumberBook();
			String Description = listTypeRoom.get(i).getDescription();
			%>
				<div class="room-type">
	    			<img src="https://media.cnn.com/api/v1/images/stellar/prod/140127103345-peninsula-shanghai-deluxe-mock-up.jpg?q=w_2226,h_1449,x_0,y_0,c_fill" alt="Room Image">
	    			<div class="room-type-info">
	        			<h2><%= TypeRoomName %></h2>
	        			<p>Số người tối đa: Người lớn - <%= MaxAdult %>, Trẻ nhỏ - <%= MaxChild %></p>
	        			<p>Giá: $<%= Price %>/đêm</p>
	        			<p>Số lần đặt: <%= NumberBook %></p>
	        			<p>Description: <%= Description %></p>
	        			<div class="btn-container">
	            			<button onclick="detailTypeRoom('<%= IDTypeRoom %>')">Xem chi tiết</button>
	            			<button onclick="displayFormUpdate('<%= IDTypeRoom %>','<%= TypeRoomName %>',<%= Price %>,<%= MaxAdult %>,<%= MaxChild %>,<%= Description %>)">Chỉnh sửa</button>
	        			</div>
	    			</div>
				</div>
			<% 
		}
	}
%>

<div class="btn-container">
    <button onclick="displayFormInsert()">Thêm loại phòng</button>
</div>

<div class="background-shadow dp-n"></div>

<div class="form-container dp-n">
    <h2>Thêm loại phòng</h2>
    <form action="<%= url.urlServer + "manageTypeRoom" %>" method="POST">
        <label for="roomName">Tên loại phòng:</label>
        <input type="text" id="roomName" name="TypeRoomName" required>

        <label for="maxAdults">Số người tối đa (người lớn):</label>
        <input type="number" id="maxAdults" name="MaxAdult" min="0" required>

        <label for="maxChildren">Số người tối đa (trẻ em):</label>
        <input type="number" id="maxChildren" name="MaxChild" min="0" required>

        <label for="roomPrice">Giá:</label>
        <input type="number" id="roomPrice" name="Price" min="0" step="50" required>
        
        <label for="description">Description:</label>
        <textarea id="description" name="Description" rows="4" required></textarea>

        <div class="image-container">
            <label for="roomImages">Đường dẫn hình ảnh phòng:</label>
            <select class="select-image" name=roomImages>
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
            <button class="add-image-button" type="button" onclick="addInputField()">Thêm</button>
        </div>
        <input type="text" name="type" value="insertTypeRoom" class="dp-n">
        <input class="save-changes-button" type="submit" value="Add">
    </form>
</div> 

<div class="form-container-update dp-n">
    <h2>Chỉnh sửa thông tin loại phòng</h2>
    <form action="<%= url.urlServer + "manageTypeRoom" %>" method="POST">
    	<input type="text" id="idTypeRoomUpdate" name="IDTypeRoom" class="dp-n">
        <label for="typeRoomNameUpdate">Tên loại phòng:</label>
        <input type="text" id="typeRoomNameUpdate" name="TypeRoomName" required>

        <label for="maxAdultUpdate">Số người tối đa (người lớn):</label> 
        <input type="number" id="maxAdultUpdate" name="MaxAdult" min="0" required>

        <label for="maxChildUpdate">Số người tối đa (trẻ em):</label>
        <input type="number" id="maxChildUpdate" name="MaxChild" min="0" required>

        <label for="priceUpdate">Giá:</label>
        <input type="number" id="priceUpdate" name="Price" min="0" step="50" required>
        
        <label for="Description">Description:</label>
        <textarea id="Description" name="Description" rows="4" required></textarea>

        <div class="image-container-update">
            <label for="roomImages">Đường dẫn hình ảnh phòng:</label>
            <select class="select-image-update" name=roomImages>
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
            <button class="add-image-button" style="padding: 6px 8px" type="button" onclick="addInputFieldUpdate()">Thêm</button>
        </div>
        <input type="text" name="type" value="updateTypeRoom" class="dp-n">
        <input class="save-changes-button" type="submit" value="Update">
    </form>
</div>

<!-- https://i.ibb.co/x21gkf7/introduce.jpg
https://i.ibb.co/k8R44b5/standard-double.jpg
https://i.ibb.co/bBB4hFd/meal-service.jpg
https://i.ibb.co/KD4pV89/bike-rental.jpg
https://i.ibb.co/b2NqFWP/beach-view-suite.jpg
https://i.ibb.co/PhyGC7n/beach-view-single.jpg -->
</body>

<script>
	var formContainer = document.querySelector('.form-container');
	var formContainerUpdate = document.querySelector('.form-container-update');
	var backgroundShadow = document.querySelector('.background-shadow');

	function displayFormInsert(){
		formContainer.classList.remove('dp-n');
		backgroundShadow.classList.remove('dp-n');
	}

	function displayFormUpdate(IDTypeRoom,TypeRoomName,Price,MaxAdult,MaxChild,Description){
		formContainerUpdate.classList.remove('dp-n');
		backgroundShadow.classList.remove('dp-n');

		document.getElementById('idTypeRoomUpdate').value = IDTypeRoom;
		document.getElementById('typeRoomNameUpdate').value = TypeRoomName;
		document.getElementById('priceUpdate').value = Price;
		document.getElementById('maxChildUpdate').value = MaxChild;
		document.getElementById('maxAdultUpdate').value = MaxAdult;
		document.getElementById('Description').value = Description;
	}

	backgroundShadow.addEventListener('click', () => {
		formContainer.classList.add('dp-n');
		formContainerUpdate.classList.add('dp-n');
		backgroundShadow.classList.add('dp-n');
	});

    function addInputField() {
        const imageContainer = document.createElement('div');
        imageContainer.className = 'image-container';

/*         const input = document.createElement('input');
        input.type = 'text';
        input.name = 'roomImages[]';
        input.required = true; */

        const selectImage = document.getElementsByClassName('select-image');
        const htmlSelectImage = selectImage[0].outerHTML;

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

        /* imageContainer.appendChild(htmlSelectImage); */
        imageContainer.innerHTML += htmlSelectImage;
        imageContainer.appendChild(addButton);
        imageContainer.appendChild(removeButton);

        const form = document.querySelector('.form-container form');
        form.insertBefore(imageContainer, form.lastElementChild);
    }

    function addInputFieldUpdate() {
        const imageContainer = document.createElement('div');
        imageContainer.className = 'image-container';

/*         const input = document.createElement('input');
        input.type = 'text';
        input.name = 'roomImages[]';
        input.required = true; */

        const selectImage = document.getElementsByClassName('select-image-update');
        const htmlSelectImage = selectImage[0].outerHTML;

        const addButton = document.createElement('button');
        addButton.textContent = 'Thêm';
        addButton.className = 'add-image-button';
        addButton.type = 'button';
        addButton.onclick = addInputFieldUpdate;

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

        /* imageContainer.appendChild(htmlSelectImage); */
        imageContainer.innerHTML += htmlSelectImage;
        imageContainer.appendChild(addButton);
        imageContainer.appendChild(removeButton);

        const form = document.querySelector('.form-container-update form');
        form.insertBefore(imageContainer, form.lastElementChild);
    }

    function detailTypeRoom(IDTypeRoom){
    	document.cookie = "IDTypeRoom=" + IDTypeRoom + ";max-age=" + (24 * 60 * 60);
    	window.location.href = '<%= url.urlServer + "manageRoom" %>';
    }
    
</script>

</html>