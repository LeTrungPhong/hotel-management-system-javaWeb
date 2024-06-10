<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.controller.url.*" %>
<%@page import="java.util.ArrayList"%>
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
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
        }
        
        .container {
        	position: relative;
        	margin-top: 150px;
        }

        /* .formModify {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        } */

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 700px;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th,
        td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        button {
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-delete {
            background-color: #f44336;
            color: white;
            margin-right: 20px;
        }

        .btn-delete:hover {
            background-color: #d32f2f;
        }

        .btn-add,
        .btn-edit {
            background-color: #4CAF50;
            color: white;
        }

        .btn-add:hover,
        .btn-edit:hover {
            background-color: #45a049;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        #form {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            min-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: all 0.3s;
            z-index: 5;
        }

        #overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: -1;
            opacity: 0;
            transition: all 0.3s;
            visibility: hidden;
        }
        
        .background-shadow {
        	position: fixed;
        	top: 0px;
        	left: 0px;
        	width: 100%;
        	height: 100%;
        	background-color: rgba(0,0,0,0.2);
        	z-index: 4;
        }
        .dp-n {
        	display: none;
        }
    </style>
</head>
<body class="container">
<jsp:include page="navBarAdmin.jsp"/>
	<%
		TypeRoom tr = (TypeRoom)request.getAttribute("TypeRoom");
		ArrayList<Facility> listFacility = request.getAttribute("listFacility") != null ? (ArrayList<Facility>)request.getAttribute("listFacility") : null;
	%> 
	<h1>Quản lý cơ sở vật chất loại phòng: <%= tr != null ? tr.getTypeRoomName() : "" %></h1> 
    <table>
        <thead>
            <tr>
                <th>Tên Phòng</th>
                <th>Thao tác</th>
            </tr>
            	<%
            	if(listFacility != null){
    				for(int i = 0; i < listFacility.size(); ++i){
    					String IDFacility = listFacility.get(i).getIDFacility();
    					String IDTypeRoom = listFacility.get(i).getIDTypeRoom();
    					String FacilityName = listFacility.get(i).getFacilityName();
    					%>
    						<tr>
    							<td><%= FacilityName %></td>
    							<td>
    								<button class="btn-delete" onclick="deleteFacility('<%= IDFacility %>')" type="submit">Xóa</button>
    							</td>
    						</tr>
    					<%
    				}
    			}
            	%>
        </thead>
        <tbody id="room-list">
            <!-- List rooms -->
        </tbody>
    </table>
    <button class="btn-add" onclick="displayFormInsert()">Thêm</button>
    <!-- <button class="btn-edit" onclick="EditRoom()">Sửa Phòng</button> -->

	<div class="background-shadow dp-n"></div>

    <div id="form" class="form-container dp-n">
        <h1 id="edit_or_add" style="margin-bottom: 10px">Thêm cơ sở vật chất</h1>
        <form class="formModify" action="<%= url.urlServer + "manageFacility" %>" method="post">
            <label for="FacilityName">Tên cơ sở vật chất:</label><br>
            <input type="text" id="FacilityName" name="FacilityName" required><br><br>
            <input type="text" id="IDTypeRoom" name="IDTypeRoom" value="<%= request.getParameter("IDTypeRoom") %>" class="dp-n">
            <input type="text" name="type" value="insertFacility" class="dp-n">
            <input type="submit" value="Them">
        </form>
    </div>
    
    <form class="dp-n" action="<%= url.urlServer + "manageFacility" %>" method="post">
    	<input type="text" name="IDFacility" id="IDFacility" >
    	<input type="text" name="IDTypeRoom" value="<%= request.getParameter("IDTypeRoom") %>" class="dp-n">
    	<input type="text" name="type" value="deleteFacility" class="dp-n">
    	<input type="submit" id="delete">
    </form>
    
    <script>
        var formContainer = document.querySelector('.form-container');
        var backgroundShadow = document.querySelector('.background-shadow');
        var formContainerUpdate = document.querySelector('.form-container-update');

        function displayFormInsert() {
        	formContainer.classList.remove('dp-n');
        	backgroundShadow.classList.remove('dp-n');
        }

        backgroundShadow.addEventListener('click', () => {
        	formContainer.classList.add('dp-n');
        	backgroundShadow.classList.add('dp-n');
        	formContainerUpdate.classList.add('dp-n');
        })
        
        function displayFormUpdate(IDRoom,RoomName){

			document.getElementById('IDRoomUpdate').value = IDRoom;
			document.getElementById('RoomNameUpdate').value = RoomName;
            
			formContainerUpdate.classList.remove('dp-n');
			backgroundShadow.classList.remove('dp-n');
        }

        function deleteFacility(IDFacility){
			document.getElementById('IDFacility').value = IDFacility;
			document.getElementById('delete').click();
        }
    </script>
</body>
</html>