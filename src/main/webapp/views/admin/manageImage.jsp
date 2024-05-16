<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.controller.url.*" %>
<%@ page import="com.appManageHotel.model.DAO.*"%>
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
        .image-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
        }
        .image {
            border-bottom: 1px solid #ccc;
            padding-bottom: 20px;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
        }
        .image:last-child {
            border-bottom: none;
            padding-bottom: 0;
            margin-bottom: 0;
        }
        .image img {
            max-width: 80px;
            max-height: 80px;
            margin-right: 20px;
        }
        .image-info {
            flex-grow: 1;
        }
        .image-info h3 {
            margin: 0;
        }
        .image-info p {
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
        .update {
            background-color: #4CAF50;
            color: white;
        }
        .edit-button:hover {
            background-color: #45a049;
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
        .form-container input[type="date"],
        .form-container-update input[type="text"], 
        .form-container-update input[type="number"],
        .form-container-update input[type="date"]{
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container input[type="submit"],
        .form-container-update input[type="submit"] {
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .form-container input[type="submit"]:hover,
        .form-container-update input[type="submit"]:hover {
            background-color: #45a049;
        }
        .background-shadow {
        	position: fixed;
        	top: 0px;
        	left: 0px;
        	width: 100%;
        	height: 100%; 
        	z-index: 4;
        	background-color: rgba(0,0,0,0.4);
        }
        #ImageNameOld,
        #PathOld {
        	background-color: rgba(0,0,0,0.1);
        }
        .dp-n {
        	display: none;
        }
    </style>
</head>
<!-- https://i.ibb.co/x21gkf7/introduce.jpg
https://i.ibb.co/k8R44b5/standard-double.jpg
https://i.ibb.co/bBB4hFd/meal-service.jpg
https://i.ibb.co/KD4pV89/bike-rental.jpg
https://i.ibb.co/b2NqFWP/beach-view-suite.jpg
https://i.ibb.co/PhyGC7n/beach-view-single.jpg -->
<body class="container">
<jsp:include page="navBarAdmin.jsp"/>
<div class="background-shadow dp-n"></div>
<div class="image-container">
    <%
    	ArrayList<Image> listImage = request.getAttribute("listImage") != null ? (ArrayList<Image>)request.getAttribute("listImage") : null;
    	if(listImage != null){
    		for(int i = 0; i < listImage.size(); ++i){
        		%>
        			<div class="image">
            			<img src="<%= listImage.get(i).getPath() %>" alt="Image">
            			<div class="image-info">
                			<h3><%= listImage.get(i).getImageName() %></h3>
                			<p><%= listImage.get(i).getPath() %></p>
            			</div>
            			<div class="action-buttons">
                			<button class="update" onclick="displayFormUpdate('<%= listImage.get(i).getIDImage() %>','<%= listImage.get(i).getImageName() %>','<%= listImage.get(i).getPath() %>')">Chỉnh sửa</button>
            			</div>
        			</div>
        		<%
        	}
    	}
    %>
</div>

<div class="add-button">
    <button class="add" onclick="displayForm()">Them hinh anh</button>
</div>

<div class="form-container dp-n">
    <h2 style="margin-bottom: 15px">Them hinh anh</h2>
    <form action="<%= url.urlServer + "manageImage" %>" method="post">
        <label for="ImageNameInsert">Ten hinh anh: </label>
        <input type="text" id="ImageNameInsert" name="ImageName" value="" required>
        
        <label for="PathInsert">Path: </label>
        <input type="text" id="PathInsert" name="Path" value="" required>
        <input type="text" class="dp-n" name="type" value="insertImage">
        <input type="submit" value="them">
    </form>
</div>
 
<div class="form-container-update dp-n">
    <h2 style="margin-bottom: 15px">Chỉnh sửa hình ảnh</h2> 
    <form action="<%= url.urlServer + "manageImage" %>" method="post">
        <label for="ImageNameOld">Ten hinh anh cu: </label>
        <input type="text" id="ImageNameOld" value="" readonly> 
        <label for="PathOld">Path cu: </label>
        <input type="text" id="PathOld" value="" readonly>
        
    	<input type="text" id="IDImageUpdate" class="dp-n" name="IDImage">
        <label for="ImageNameUpdate">Ten hinh anh moi: </label>
        <input type="text" id="ImageNameUpdate" name="ImageName" value="" required>
        <label for="Path">Path moi: </label>
        <input type="text" id="PathUpdate" name="Path" value="" required>
        <input type="text" class="dp-n" name="type" value="updateImage">
        <input type="submit" value="Update">
    </form>
</div>

</body>
<script>

var backgroundShadow = document.querySelector('.background-shadow');
var formContainer = document.querySelector('.form-container');
var formContainerUpdate = document.querySelector('.form-container-update');

var IDImageUpdate = document.getElementById("IDImageUpdate");
var ImageNameUpdate = document.getElementById("ImageNameUpdate");
var PathUpdate = document.getElementById("PathUpdate");

var ImageNameOld = document.getElementById("ImageNameOld");
var PathOld = document.getElementById("PathOld");

function displayForm(){
	backgroundShadow.classList.remove('dp-n');
	formContainer.classList.remove('dp-n');
}

function displayFormUpdate(idimage, imagename, path){
	backgroundShadow.classList.remove('dp-n');
	formContainerUpdate.classList.remove('dp-n');

	IDImageUpdate.value = idimage;
	ImageNameUpdate.value = imagename;
	PathUpdate.value = path;
	ImageNameOld.value = imagename;
	PathOld.value = path;
}

backgroundShadow.addEventListener('click',() => {
	backgroundShadow.classList.add('dp-n');
	formContainer.classList.add('dp-n');
	formContainerUpdate.classList.add('dp-n');
});

</script>
</html>