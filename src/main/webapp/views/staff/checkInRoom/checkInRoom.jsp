<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.awt.font.ImageGraphicAttribute"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="com.appManageHotel.model.BEAN.Room" %>
<%@ page import="com.appManageHotel.model.DAO.RoomDAO" %>
<%@ page import="com.appManageHotel.model.BEAN.*" %>
<%@ page import="com.appManageHotel.model.DAO.TypeRoomDAO" %>
<%@ page import="com.appManageHotel.model.DAO.*" %>
<%@ page import="com.appManageHotel.controller.url.*"%>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="views/user/rooms/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/datepicker.min.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style>
	.dp-n{
		display: none;
	}

.main {
	position: relative;
	width: 100vw;
	height: 100vh;
}
	
.star_room i{
    color: rgb(255, 0, 0);
}

.rooms__list{
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
    justify-content: space-evenly;
}

.body__rooms {
    width: 100%; 
    transform: unset;
}

.room__item{
    margin-top: 20px;
}

.infor__cost__maxPeople{
    position: absolute;
    top: 0;
    width: 100%;
}

.option__filter{
    gap: 10px;
    min-width: 500px;
}

.option__filter__title{
    font-size: 30px;
    font-weight: 700;
}

.container_option__filter{ 
    width: 100%;
    background-color: orange;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 10px 0;
}

.QuantityPerson{
    position: absolute;
    width: 300px;
    background-color: #fff;
    padding: 20px;
    opacity: 0;
    visibility: hidden;
    box-shadow: 0 0 10px #a0a0a0;
    border-radius: 5px;
    margin-top: 5px;
    transition: all 0.2s linear;
    z-index: 1;
}

.QuantityPerson__show{
    opacity: 1;
    visibility: visible;
    z-index: 100;
}

.QuantityPerson__item{
    display: flex;
    align-items: center;
    flex-direction: row;
    margin-bottom: 10px;
}

.QuantityPerson__options{
    border: 2px solid #ccc;
    border-radius: 8px;
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-direction: row;
}

.QuantityPerson__label{
    flex: 1.2;
    text-align: left;
    font-weight: 700;
}

.QuantityPerson__options{
    flex: 1;
}

.QuantityPerson__operator__sub{
    padding: 10px;
    color: red;
}

.QuantityPerson__operator__plus{
    padding: 10px;
    color: green;
}

.icon_user{
    position: absolute;
    color: #9CA3AF;
    font-size: 20px;
    top: 10px;
    left: 10px;
}

.relative> input{
    background-color: #fff !important;
    color: #000 !important;
}

.datepicker-picker{
    background-color: #fff !important;
}

.datepicker-cell{
    color: #000 !important;
}

.datepicker-cell:hover{
    background-color: #30CFD0 !important;
}

.datepicker-controls button{
    background-color: #30CFD0;
    transition: all 0.2s linear;
}

.datepicker-controls button:hover{
    background-color: #330867;
}

.button_search{
    width: 42px;
    height: 42px;
    background-color: #30CFD0;
    border-radius: 50%;
    transition: all 0.2s linear;
}

.button_search:hover{
    background-color: rgb(0, 255, 255);
}

.option__item{
    margin-top: 15px;
    padding: 10px 15px;
    border-radius: 10px;
    background-color: rgb(255, 99, 99);
    transition: all 0.2s linear;
}

.choose__option{
    background-color: lightgreen !important;
}

i{
    transition: all 0.2s linear;
    margin-left: 3px;
}

.option__item:hover i{
    transform: rotate(180deg);
}

/* This line can be removed it was just for display on CodePen: */
  
  .slider-labels {
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
  }
  
  /* Functional styling;
   * These styles are required for noUiSlider to function.
   * You don't need to change these rules to apply your design.
   */
  .noUi-target,.noUi-target * {
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -ms-touch-action: none;
    touch-action: none;
    -ms-user-select: none;
    -moz-user-select: none;
    user-select: none;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
  }
  
  .noUi-target {
    position: relative;
    direction: ltr;
  }
  
  .noUi-base {
    width: 100%;
    height: 100%;
    position: relative;
    z-index: 1;
  /* Fix 401 */
  }
  
  .noUi-origin {
    position: absolute;
    right: 0;
    top: 0;
    left: 0;
    bottom: 0;
  }
  
  .noUi-handle {
    position: relative;
    z-index: 1;
  }
  
  .noUi-stacking .noUi-handle {
  /* This class is applied to the lower origin when
     its values is > 50%. */
    z-index: 10;
  }
  
  .noUi-state-tap .noUi-origin {
    -webkit-transition: left 0.3s,top .3s;
    transition: left 0.3s,top .3s;
  }
  
  .noUi-state-drag * {
    cursor: inherit !important;
  }
  
  /* Painting and performance;
   * Browsers can paint handles in their own layer.
   */
  .noUi-base,.noUi-handle {
    -webkit-transform: translate3d(0,0,0);
    transform: translate3d(0,0,0);
  }
  
  /* Slider size and handle placement;
   */
  .noUi-horizontal {
    height: 4px;
  }
  
  .noUi-horizontal .noUi-handle {
    width: 18px;
    height: 18px;
    border-radius: 50%;
    left: -7px;
    top: -7px;
    background-color: #30CFD0;
  }
  
  /* Styling;
   */
  .noUi-background {
    background: #D6D7D9;
  }
  
  .noUi-connect {
    background: #30CFD0;
    -webkit-transition: background 450ms;
    transition: background 450ms;
  }
  
  .noUi-origin {
    border-radius: 2px;
  }
  
  .noUi-target {
    border-radius: 2px;
  }
  .container_option__filter{
  	margin-top: 150px;
  }
  
  
  /* Handles and cursors;
   */
  .noUi-draggable {
    cursor: w-resize;
  }
  
  .noUi-vertical .noUi-draggable {
    cursor: n-resize;
  }
  
  .noUi-handle {
    cursor: default;
    -webkit-box-sizing: content-box !important;
    -moz-box-sizing: content-box !important;
    box-sizing: content-box !important;
  }
  
  .noUi-handle:active {
    border: 8px solid #30CFD0;
    border: 8px solid #30d0d04b;
    -webkit-background-clip: padding-box;
    background-clip: padding-box;
    left: -14px;
    top: -14px;
  }
  
  /* Disabled state;
   */
  [disabled].noUi-connect,[disabled] .noUi-connect {
    background: #B8B8B8;
  }
  
  [disabled].noUi-origin,[disabled] .noUi-handle {
    cursor: not-allowed;
  }

  .rangeCost{
    margin-top: 15px;
  }
  
  .datepicker-dropdown{
    top: 43px !important;
   }
   
   h1 {
            text-align: center;
            margin-bottom: 40px;
        }
        .room {
            display: flex;
            flex-direction: column;
            gap: 20px;
            align-items: center;
            margin-top: 150px;
        }
        .room-list {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 95%;
        } 
        .room-list h2 {
            margin-top: 0;
            border-bottom: 2px solid #ddd;
            padding-bottom: 10px;
        }
        .room-list.booked {
            background-color: #e0ffe0;
        }
        .room-list.unbooked {
            background-color: #ffe0e0;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .book-button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 15px;
            cursor: pointer;
            border-radius: 5px;
        }
        .book-button:hover {
            background-color: #0056b3;
        }
	
		#form-submit{
        	position: fixed;
        	padding: 20px; 
        	border-radius: 5px;
        	background-color: #fff;
        	z-index: 5;
        	top: 50%;
        	left: 50%;
        	transform: translate(-50%,-50%);
        }
        
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        .input,
        select,
        textarea {
            width: calc(100% - 5px); 
            padding: 10px !important;
            margin: 5px 0 !important;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        
        .select {
            padding: 10px !important;
            margin: 5px 0 !important;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        input[readonly] {
            background-color: #f4f4f4;
            cursor: not-allowed;
        }

        .input-group {
            display: flex;
            justify-content: space-between;
        }

        .input-group label,
        .input-group input {
            width: calc(100% - 22px);
        }

        .img_room_booking { 
            width: 100%;
            border-radius: 10px;
            margin-bottom: 15px;
        } 
        
        .background-shadow {
        	background-color: rgba(0,0,0,0.2);
        	position: fixed;
        	width: 100%;
        	height: 100%;
        	top: 0;
        	left: 0;
        	z-index: 4;
        }
        .button-service {
        	all: unset;
        	cursor: pointer;
        }
        .unCheckIn {
        	background-color: #cfcfcf !important;
        }
        .buttonUnCheckIn {
        	border: none;
            padding: 10px 15px;
            cursor: pointer;
            border-radius: 5px;
        }
        .bg-green {
        	background-color: #a8e5a8 !important;
        }
</style>
</head>
<body class="main">
<jsp:include page="../navBarStaff.jsp"/> 
	<div class="room">
		<div class="room-list booked bookedCheckIn">
            <h2>Phòng đã check in</h2>
            <table>
                <thead>
                    <tr>
                        <th>Loại phòng</th>
                        <th>Tên phòng</th>
                        <th>CCCD</th>
                        <th>Số người lớn</th>
                        <th>Số trẻ em</th>
                        <th>Ngày đến</th>
                        <th>Ngày trả phòng</th>
                        <th>Ngày Check In</th>
                        <th>Giá phòng</th>
                        <th>Phụ thu</th>
                        <th>Tổng tiền</th>
                        <th>Số tiền đã trả</th>
                        <th>Trả phòng</th>
                    </tr>
                </thead>
                <tbody> 
                    <%
                    	ArrayList<IFBookRoom> listIFBookRoomCheckIn = request.getAttribute("listIFBookRoomCheckIn") != null ? (ArrayList<IFBookRoom>)request.getAttribute("listIFBookRoomCheckIn") : null;
                    	if(listIFBookRoomCheckIn != null){
                    		for(int i = 0; i < listIFBookRoomCheckIn.size(); ++i){
                    			Room room = RoomDAOimpl.getInstance().selectByID(listIFBookRoomCheckIn.get(i).getIDRoom());
                    			TypeRoom tr = room != null ? TypeRoomDAOimpl.getInstance().selectByID(room.getIDTypeRoom()) : null;
                    			Bill bill = BillDAOimpl.getInstance().selectByIDIFBookRoom(listIFBookRoomCheckIn.get(i).getIDIFBookRoom());
                    			
                    			Customer customer = CustomerDAOimpl.getInstance().selectByID(bill.getIDCustomer());
                    			
                    			LocalDate comeInDate = listIFBookRoomCheckIn.get(i).getComeInDate();
                    			LocalDate comeOutDate = listIFBookRoomCheckIn.get(i).getComeOutDate();
                    			long daysBetween = ChronoUnit.DAYS.between(comeInDate, comeOutDate);
                    	        int surcharge = bill.getTotal() - (int)(daysBetween * tr.getPrice());
                    	        
                    	        String strComeOutDate = String.format("%02d-%02d-%d", comeOutDate.getYear(), comeOutDate.getMonthValue(), comeOutDate.getDayOfMonth());
                    			%>
                    				<tr>
                        				<td><%= tr != null ? tr.getTypeRoomName() : "" %></td>
                        				<td><%= room != null ? room.getRoomName() : "" %></td>
                        				<td><%= customer.getCCCD() %></td>
                        				<td><%= listIFBookRoomCheckIn.get(i).getNumberAdult() %></td>
                        				<td><%= listIFBookRoomCheckIn.get(i).getNumberChild() %></td>
                        				<td><%= listIFBookRoomCheckIn.get(i).getComeInDate() %></td>
                        				<td><%= listIFBookRoomCheckIn.get(i).getComeOutDate() %></td>
                        				<td><%= listIFBookRoomCheckIn.get(i).getComeInDateReal() %></td>
                        				<td><%= tr != null ? tr.getPrice() : "Khong ton tai" %></td>
                        				<td><%= surcharge %></td>
                        				<td><%= bill != null ? bill.getTotal() : "Khong ton tai"  %></td>
                        				<td><%= bill != null ? bill.getPrepayment() : "Khong ton tai" %></td>
                        				<td>
                        					<button style="background-color: #cfcfcf;" class="buttonUnCheckIn" onclick="checkOut('<%= listIFBookRoomCheckIn.get(i).getIDIFBookRoom() %>')">Trả phòng</button>
                        					<button style="background-color: #fff; border: 1px solid gray;" class="buttonUnCheckIn" onclick="extend('<%= customer.getCCCD() %>','<%= room.getRoomName() %>','<%= strComeOutDate %>','<%= listIFBookRoomCheckIn.get(i).getIDIFBookRoom() %>')">Gia hạn phòng</button>
                        					<%
                        						if(LocalDate.now().isAfter(listIFBookRoomCheckIn.get(i).getComeOutDate())){
                        							%>
                        								<button style="background-color: rgb(255, 99, 99);" class="buttonUnCheckIn">Quá hạn</button>
                        							<%
                        						}
                        					%>
                        				</td>
                    				</tr>
                    			<%
                    		}
                    	}
                    %>
                </tbody>
            </table>
            <form action="<%= url.urlServer + "checkOut" %>" class="dp-n" method="post">
            	<input type="text" id="IDIFBookRoom" name="IDIFBookRoom">
            	<input type="submit" id="submitCheckOut">
            </form>
            
            <form class="dp-n" action="<%= url.urlServer + "extendRoom" %>" id="form-submit" method="post" onsubmit="return validateInput()">
            	<label for="RoomName">Tên phòng: </label>
        		<input class="input" type="text" id="RoomName" name="RoomName" readonly>
        		
        		<label for="CCCD">CCCD: </label>
        		<input class="input" type="text" id="CCCD" name="CCCD" readonly>
        		
        		<label for="ComeOutDate">Ngày trả phòng: </label>
        		<input class="input" type="date" id="ComeOutDate" name="ComeOutDate" readonly>
        		
        		<label for="ComeOutDateUpdate">Gia hạn đến ngày: </label>
        		<input class="input" type="date" id="ComeOutDateUpdate" name="ComeOutDateUpdate" required>
        		
        		<input class="dp-n" type="text" id="IDIFBookRoomUpdate" name="IDIFBookRoomUpdate">
        		
        		<input type="submit" id="submitExtend" value="Xác nhận gia hạn">
    		</form>
        </div> 
        <div class="background-shadow dp-n"></div>
	</div>
	<script>
		const submitCheckOut = document.getElementById('submitCheckOut');

		function checkOut(IDIFBookRoom){
			document.getElementById('IDIFBookRoom').value = IDIFBookRoom;
			submitCheckOut.click();
		}

		function extend(CCCD,RoomName,ComeOutDate,IDIFBookRoom){

			document.getElementById('form-submit').classList.remove('dp-n');
			document.querySelector('.background-shadow').classList.remove('dp-n');
			
			document.getElementById('CCCD').value = CCCD;
			document.getElementById('RoomName').value = RoomName;
			document.getElementById('ComeOutDate').value = ComeOutDate;
			document.getElementById('IDIFBookRoomUpdate').value = IDIFBookRoom;
		}

		document.querySelector('.background-shadow').addEventListener('click', () => {
			document.getElementById('form-submit').classList.add('dp-n');
			document.querySelector('.background-shadow').classList.add('dp-n');
		})
		
	</script>
</body>
</html>