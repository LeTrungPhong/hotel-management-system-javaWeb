<%@page import="java.time.LocalDate"%>
<%@page import="com.appManageHotel.controller.url.url"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thống kê doanh thu khách sạn</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<style>
	input[type="number"] {
			width: 100px; 
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
	}
</style>
<body>
<jsp:include page="navBarAdmin.jsp"/> 
	<%
		LocalDate timeNow = LocalDate.now();
	%>
	<div style="width: 75%; margin: 150px auto;">
        <h2>Biểu đồ cột - Doanh thu theo tháng trong năm <input id="yearChartMonth" type="number" value="<%= request.getParameter("year") != null ? Integer.parseInt(request.getParameter("year")) : timeNow.getYear() %>" min="2023" max="2025"></h2>
        <canvas id="monthlyRevenueChart"></canvas>

        <h2>Biểu đồ cột - Doanh thu theo ngày trong tháng 
        	<input id="monthChartDay" type="number" value="<%= request.getParameter("month") != null ? Integer.parseInt(request.getParameter("month")) : timeNow.getMonthValue() %>" min="1" max="12">
        	Năm <input id="yearChartDay" type="number" value="<%= request.getParameter("year") != null ? Integer.parseInt(request.getParameter("year")) : timeNow.getYear() %>" min="2023" max="2025">
        </h2>
        <canvas id="dailyRevenueChart"></canvas>

        <h2>Biểu đồ hình tròn - Phần trăm loại phòng được đặt</h2>
        <canvas id="roomTypePieChart"></canvas>

        <h2>Biểu đồ cột - Doanh thu từng loại phòng</h2>
        <canvas id="roomRevenueChart"></canvas>
        
        <h2>Biểu đồ hình tròn - Phần trăm dịch vụ được đặt</h2>
        <canvas id="servicePieChart"></canvas>

        <h2>Biểu đồ cột - Thống kê các loại dịch vụ khách hàng đã dùng</h2>
        <canvas id="serviceUsageChart"></canvas>
    </div> 
    
<script>

	const monthChartDay = document.getElementById('monthChartDay');

	const yearChart = document.getElementById('yearChartMonth');
	yearChart.addEventListener('input', () => {
		window.location.href = '<%= url.urlServer + "chart?year=" %>' + yearChart.value + '&month=' + monthChartDay.value;
	});

	const yearChartDay = document.getElementById('yearChartDay');
	yearChartDay.addEventListener('input', () => {
		window.location.href = '<%= url.urlServer + "chart?year=" %>' + yearChartDay.value + '&month=' + monthChartDay.value;
	});

	monthChartDay.addEventListener('input', () => {
		window.location.href = '<%= url.urlServer + "chart?year=" %>' + yearChartDay.value + '&month=' + monthChartDay.value;
	})



	<%
		ArrayList<Integer> listChartMonth = request.getAttribute("chartMonth") != null ? (ArrayList<Integer>)request.getAttribute("chartMonth") : null;
		String chartMonthJson = new com.google.gson.Gson().toJson(listChartMonth);
	%>
    // Biểu đồ cột - Doanh thu theo tháng
    const ctxMonthly = document.getElementById('monthlyRevenueChart').getContext('2d');
    const monthlyRevenueChart = new Chart(ctxMonthly, {
        type: 'bar',
        data: {
            labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
            datasets: [{
                label: 'Doanh thu (triệu VND)',
                data: JSON.parse('<%= chartMonthJson %>'),
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    <%
		ArrayList<Integer> listChartDay = request.getAttribute("chartDay") != null ? (ArrayList<Integer>)request.getAttribute("chartDay") : null;
		String chartDayJson = new com.google.gson.Gson().toJson(listChartDay);
	%>
    // Biểu đồ cột - Doanh thu theo ngày trong tháng 5
    const ctxDaily = document.getElementById('dailyRevenueChart').getContext('2d');
    const dailyRevenueChart = new Chart(ctxDaily, {
        type: 'bar',
        data: {
            labels: Array.from({ length: JSON.parse('<%= chartDayJson %>').length }, (v, k) => 'Ngày ' + (k+1)),
            datasets: [{
                label: 'Doanh thu (triệu VND)',
                data: JSON.parse('<%= chartDayJson %>'),
                backgroundColor: 'rgba(153, 102, 255, 0.2)',
                borderColor: 'rgba(153, 102, 255, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });


    <%
		ArrayList<String> listChartTypeRoomName = request.getAttribute("chartTypeRoomName") != null ? (ArrayList<String>)request.getAttribute("chartTypeRoomName") : null;
		String chartTypeRoomNameJson = new com.google.gson.Gson().toJson(listChartTypeRoomName);
		
		ArrayList<Integer> listChartNumberBook = request.getAttribute("chartNumberBook") != null ? (ArrayList<Integer>)request.getAttribute("chartNumberBook") : null;
		String chartNumberBookJson = new com.google.gson.Gson().toJson(listChartNumberBook);
	%>

    // Biểu đồ hình tròn - Phần trăm loại phòng được đặt
    const ctxPie = document.getElementById('roomTypePieChart').getContext('2d');
    const roomTypePieChart = new Chart(ctxPie, {
        type: 'pie',
        data: {
            labels: JSON.parse('<%= chartTypeRoomNameJson %>'),
            datasets: [{
                label: 'Số lần được đặt',
                data: JSON.parse('<%= chartNumberBookJson %>'),
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true
        }
    });

    <%
		ArrayList<Integer> listChartMoneyOfTypeRoom = request.getAttribute("chartMoneyOfTypeRoom") != null ? (ArrayList<Integer>)request.getAttribute("chartMoneyOfTypeRoom") : null;
		String chartMoneyOfTypeRoomJson = new com.google.gson.Gson().toJson(listChartMoneyOfTypeRoom);
	%>

    
    // Biểu đồ cột - Doanh thu từng loại phòng
    const ctxRoomRevenue = document.getElementById('roomRevenueChart').getContext('2d');
    const roomRevenueChart = new Chart(ctxRoomRevenue, {
        type: 'bar',
        data: {
            labels: JSON.parse('<%= chartTypeRoomNameJson %>'),
            datasets: [{
                label: 'Doanh thu từng loại phòng (triệu VND)',
                data: JSON.parse('<%= chartMoneyOfTypeRoomJson %>'),
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    <%
    	ArrayList<String> listChartServiceName = request.getAttribute("chartServiceName") != null ? (ArrayList<String>)request.getAttribute("chartServiceName") : null;
		String chartServiceNameJson = new com.google.gson.Gson().toJson(listChartServiceName);
	
		ArrayList<Integer> listChartNumberUse = request.getAttribute("chartNumberUse") != null ? (ArrayList<Integer>)request.getAttribute("chartNumberUse") : null;
		String chartNumberUseJson = new com.google.gson.Gson().toJson(listChartNumberUse);
	%>

 	// Biểu đồ hình tròn - Phần trăm dich vu được đặt
    const ctxPieSV = document.getElementById('servicePieChart').getContext('2d');
    const servicePieChart = new Chart(ctxPieSV, {
        type: 'pie',
        data: {
            labels: JSON.parse('<%= chartServiceNameJson %>'),
            datasets: [{
                label: 'Số lần được đặt',
                data: JSON.parse('<%= chartNumberUseJson %>'),
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true
        }
    });

    <%
		ArrayList<Integer> listChartMoneyOfService = request.getAttribute("chartMoneyOfService") != null ? (ArrayList<Integer>)request.getAttribute("chartMoneyOfService") : null;
		String chartMoneyOfServiceJson = new com.google.gson.Gson().toJson(listChartMoneyOfService);
	%>

    // Biểu đồ cột - Thống kê các loại dịch vụ khách hàng đã dùng
    const ctxServiceUsage = document.getElementById('serviceUsageChart').getContext('2d');
    const serviceUsageChart = new Chart(ctxServiceUsage, {
        type: 'bar',
        data: {
            labels: JSON.parse('<%= chartServiceNameJson %>'),
            datasets: [{
                label: 'Số tiền:',
                data: JSON.parse('<%= chartMoneyOfServiceJson %>'),
                backgroundColor: [
                    'rgba(255, 159, 64, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 159, 64, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

</script>
</body>
</html>