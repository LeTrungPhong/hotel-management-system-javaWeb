<%@page import="com.appManageHotel.model.BEAN.Service"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.appManageHotel.model.DAO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
        /* Thêm CSS để trang web trở nên đẹp hơn */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        * {
            box-sizing: border-box;
        }
        .container {
            max-width: 1300px;
            margin: 150px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-evenly;
            flex-wrap: wrap;
            gap: 20px;
        }
        h1 {
            text-align: center;
        }
        .service {
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            position: relative;
            overflow: hidden;
            width: 400px;
        }
        .service h2 {
            margin-top: 0;
            font-size: 24px;
            color: #333;
        }
        .service p {
            margin-bottom: 10px;
            color: #666;
        }
        .service img {
            width: 100%;
            height: auto;
            margin-bottom: 15px;
            border-radius: 8px;
        }
        .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            opacity: 0;
            transition: opacity 0.3s ease;
            border-radius: 8px;
        }
        .service:hover .overlay {
            opacity: 1;
        }
        .service:hover .service-details {
            transform: translateY(0);
        }
        .service-details {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 400px;
            padding: 20px;
            word-wrap: break-word;
            transform: translateY(100%);
            transition: transform 0.3s ease;
            background-color: rgba(255, 255, 255, 0.9);
            border-bottom-left-radius: 8px;
            border-bottom-right-radius: 8px;
        }
    </style>
</head>
<body class="container">
	<jsp:include page="../../general/header/header.jsp"/> 
	<%
		ArrayList<Service> listService = request.getAttribute("listService") != null ? (ArrayList<Service>)request.getAttribute("listService") : null;
	
		if(listService != null){
			for(int i = 0; i < listService.size(); ++i){
				String IDService = listService.get(i).getIDService();
    			String ServiceName = listService.get(i).GetServiceName();
    			int Price = listService.get(i).getPrice();
    			String Description = listService.get(i).getDescription();
    			String IDImage = listService.get(i).getIDImage();
    			String Path = ImageDAOimpl.getInstance().selectByID(IDImage).getPath();
    			int NumberUse = listService.get(i).getNumberUse();
				%>
					<a href="">
        				<div class="service">
            				<img src="<%= Path %>" alt="">
            				<div class="overlay"></div>
            				<div class="service-details">
                				<h2><%= ServiceName %></h2>
                				<p><%= Description %></p>
                				<p>Giá: <%= Price %></p>
           					</div>
        				</div>
    				</a>
				<%
			}
		}
	%>
    
</body>
</html>