<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.model.BEAN.*" %>
<%@ page import="com.appManageHotel.model.DAO.*" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.appManageHotel.controller.url.*" %>
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
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
        }
        
        .container {
        	position: relative;
        	width: 100%;
        	height: 100%; 
        	
        }
        
        .container-content {
        	position: absolute;
        	width: 90%;
        	top: 20%;
        	left: 50%;
        	transform: translateX(-50%);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
        	margin-top: 20px;
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #fff;
        }

        th,
        td {
            padding: 20px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
        
        }
        
        tr:nth-child(even){
        	background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #ddd;
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

        #form {
            position: absolute;
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
       </style>
</head>
<body class="container">
	<jsp:include page="../header/header.jsp"/> 
	<div class="container-content">
	<%
		ArrayList<Bill> listBill = request.getAttribute("listBill") != null ? (ArrayList<Bill>)request.getAttribute("listBill") : null;
	%>
	<h1>Quản lý đặt phòng của tôi</h1> 
    <table class="table">
            <tr>
            	<th>STT</th>
            	<th>Loại phòng</th>
                <th>Tên Phòng</th>
                <th>Ngày đặt phòng</th>
                <th>Ngày đến</th>
                <th>Ngày đi</th>
                <th>Số người lớn</th>
                <th>Số trẻ em</th>
                <th>Tổng tiền</th>
                <th>Số tiền đã thanh toán</th>
                <th>Trạng thái</th>
                <th>Chức năng</th>
            </tr>
            <%
            	if(listBill != null){
            		for(int i = 0; i < listBill.size(); ++i) {
        				IFBookRoom infor = IFBookRoomDAOimpl.getInstance().selectByID(listBill.get(i).getIDIFBookRoom());
        				if(infor != null) {
        					Room room = RoomDAOimpl.getInstance().selectByID(infor.getIDRoom());
        					if(room != null){
        						%>
        							<tr>
        								<td><%= i %></td>
        								<td><%= TypeRoomDAOimpl.getInstance().selectByID(room.getIDTypeRoom()).getTypeRoomName() %></td>
    									<td><%= room.getRoomName() %></td>
    									<td><%= infor.getBookRoomDate() %></td>
    									<td><%= infor.getComeInDate() %></td>
    									<td><%= infor.getComeOutDate() %></td>
    									<td><%= infor.getNumberAdult() %></td>
    									<td><%= infor.getNumberChild() %></td>
    									<td><%= listBill.get(i).getTotal() %></td>
    									<td><%= listBill.get(i).getPrepayment() %></td>
    									<td>
    										<%
    										if(!infor.isState()){
												if(infor.getCheckIn()){
													%><p style="color: #db0000;">Đã trả phòng</p><%
												} else {
													%><p style="color: #db0000;">Đã hủy</p><%
												}
											} else { 
												LocalDate currentDate = LocalDate.now();
												if(infor.getCheckIn()){
													 %><p style="color: green;">Đã Check In</p><%
												} else if(currentDate.isBefore(infor.getComeInDate()) || currentDate.isBefore(infor.getComeOutDate()) && listBill.get(i).getTotal() == listBill.get(i).getPrepayment()){ 
													%><p>Chưa Check In</p><%
												} 											}
    										%>
    									</td>
    									<td>
    										<%
    											if(infor.isState() && !infor.getCheckIn()){
    												LocalDate currentDate = LocalDate.now();
    												if(currentDate.isBefore(infor.getComeInDate()) || currentDate.isBefore(infor.getComeOutDate()) && listBill.get(i).getTotal() == listBill.get(i).getPrepayment()){
    													 %>
    													 	<button style="background-color: #ffa6a6;" onclick="cancleRoom('<%= infor.getIDIFBookRoom() %>')">Hủy phòng</button>
    													 <%
    												} else {
    													%>Phòng quá hạn<%
    												}
    											}
    										%>
    									</td>
    								</tr>
        						<%
        					}
        				}
        			}
            	}
            %>
    </table>
    <form action="<%= url.urlServer + "myBooking" %>" method="post" style="display: none">
    	<input type="text" id="IDIFBookRoom" name="IDIFBookRoom">
    	<input type="submit" id="submitCancle">
    </form>
	</div>
</body>
<script>

	const urlParams = new URLSearchParams(window.location.search);
	const paramValue = urlParams.get('show');
	if(paramValue){
		alert(paramValue);
	}

	function cancleRoom(IDIFBookRoom){
		document.getElementById('IDIFBookRoom').value = IDIFBookRoom;
		document.getElementById('submitCancle').click();
	}
</script>
</html>