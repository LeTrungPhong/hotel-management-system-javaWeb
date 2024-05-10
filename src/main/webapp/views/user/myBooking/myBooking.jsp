<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.model.BEAN.*" %>
<%@ page import="com.appManageHotel.model.DAO.*" %>
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
	<jsp:include page="../../general/header/header.jsp"/> 
	<%
		ArrayList<Bill> listBill = request.getAttribute("listBill") != null ? (ArrayList<Bill>)request.getAttribute("listBill") : null;
	%>
	<h1>Quản lý đặt phòng của tôi</h1> 
    <table>
            <tr>
            	<th>Số thứ tự</th>
                <th>Tên Phòng</th>
                <th>Ngày đến</th>
                <th>Ngày đi</th>
                <th>Số người lớn</th>
                <th>Số trẻ em</th>
                <th>Số tiền đã thanh toán</th>
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
    									<td><%= room.getRoomName() %></td>
    									<td><%= infor.getComeInDate() %></td>
    									<td><%= infor.getComeOutDate() %></td>
    									<td><%= infor.getNumberAdult() %></td>
    									<td><%= infor.getNumberChild() %></td>
    									<td><%= listBill.get(i).getTotal() %></td>
    								</tr>
        						<%
        					}
        				}
        			}
            	}
            %>
    </table>
</body>
</html>