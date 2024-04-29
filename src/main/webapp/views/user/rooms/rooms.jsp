<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="com.appManageHotel.model.BEAN.Room" %>
<%@ page import="com.appManageHotel.model.DAO.RoomDAO" %>
<%@ page import="com.appManageHotel.model.BEAN.TypeRoom" %>
<%@ page import="com.appManageHotel.model.DAO.TypeRoomDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="views/user/home/style.css">
    <link rel="stylesheet" href="views/user/rooms/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/datepicker.min.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Trang chu</title>
</head>
<body class="container">
    <header class='header'>
        <div class='header__logo'>
            <button class='header__sign-button'>
                <span>HOME PAGE</span>
            </button>
            <button class='header__sign-button'>
                <span>ACCOMMODATION</span>
            </button>
            <button class='header__sign-button'>
                <span>SERVICES</span>
            </button>
            <button class='header__sign-button'>
                <span>ABOUT US</span>
            </button>
        </div>
        <div class='header__sign'>
            <button class='header__sign-button'>
                <span>SIGN UP</span>
            </button>
            <button class='header__sign-button'>
                <span>REGISTER</span>
            </button>
        </div>
    </header>
    <section class='background-opacity dp-n'>
    </section>

    <div class="body__rooms">
        <div class="container_option__filter">
            <p class="option__filter__title">Looking for your suitable room?</p>
            <div date-rangepicker class="flex items-center option__filter">
                <div class="relative">
                    <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                        <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                            <path
                                d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z" />
                        </svg>
                    </div>
                    <input name="start" type="text"
                        class="border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                        placeholder="Check in">
                </div>
                <div class="relative">
                    <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                        <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                            <path
                                d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z" />
                        </svg>
                    </div>
                    <input name="end" type="text"
                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                        placeholder="Check out">
                </div>
                <div class="relative">
                    <ion-icon class="icon_user" name="person-sharp"></ion-icon>
                    <input id="user_options" name="end" type="text"
                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                        placeholder="1 adults, 0 child">
                    <div class="QuantityPerson">
                        <div class="QuantityPerson__detail">
                            <div class="QuantityPerson__item">
                                <span class="QuantityPerson__label">Adults: </span>
                                <div class="QuantityPerson__options">
                                    <button class="QuantityPerson__operator__sub">
                                        <i class="fas fa-minus"></i>
                                    </button>
                                    <span class="QuantityPerson__amount">
                                        1
                                    </span>
                                    <button class="QuantityPerson__operator__plus">
                                        <i class="fas fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="QuantityPerson__item">
                                <span class="QuantityPerson__label">Children</span>
                                <div class="QuantityPerson__options">
                                    <button class="QuantityPerson__operator__sub">
                                        <i class="fas fa-minus"></i>
                                    </button>
                                    <span class="QuantityPerson__amount">
                                        0
                                    </span>
                                    <button class="QuantityPerson__operator__plus">
                                        <i class="fas fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="button_search">
                    <i class="fas fa-search"></i>
                </button>
            </div>
            <div class="option__filter">
                <button class="option__item">
                    <span>Beach view</span>
                    
                </button>
                <button class="option__item">
                    <span>Double bed</span>
                    
                </button>
                <button class="option__item">
                    <span>Luxury</span>
                    
                </button>
                
            </div>
            <div class="option__filter">
                <div class="rangeCost">
                    <div class="row">
                        <div class="col-sm-12">
                          <div id="slider-range"></div>
                        </div>
                    </div>
                      <div class="row slider-labels">
                        <div class="col-xs-6 caption">
                          <strong>Min:</strong> <span id="slider-range-value1"></span>
                        </div>
                        <div class="col-xs-6 text-right caption">
                          <strong>Max:</strong> <span id="slider-range-value2"></span>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-sm-12">
                          <form>
                            <input type="hidden" name="min-value" value="">
                            <input type="hidden" name="max-value" value="">
                          </form>
                        </div>
                      </div>
                </div>
            </div>
        </div>

        <div class="rooms__list">
            <%
            	List<Room> list = RoomDAO.getInstance().selectAll();
            	for(int i = 0; i < list.size(); ++i)
            	{
            		TypeRoom typeRoom = TypeRoomDAO.getInstance().selectByID(list.get(i).getIDTypeRoom().toString());
            		%>
         <div class="room__item">
            <div class="container_item">
                <img src="./assets/image/beach_view_suite.jpg" alt="">
                <div class="bottom__infor">
                    <span>
                    	<%= list.get(i).getDescription() %>
                    </span>
                    <p class="star_room">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star-half-alt"></i>
                    </p>
                </div>
                <p class="infor__cost__maxPeople">
                    <button class="infor__cost">
                        Price: <%= typeRoom.getPrice() %>$
                    </button>

                    <button class="infor__maxPeople">
                        Max People: <%= typeRoom.getMaxPeople() %>
                    </button>
                </p>
            </div>
            <h3 class="room__item__title"><%= typeRoom.getTypeRoomName() %></h3>
            <button class="book_now">
                BOOK NOW
                <div class="star-1">
                    <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1"
                        style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd"
                        viewBox="0 0 784.11 815.53" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <defs></defs>
                        <g id="Layer_x0020_1">
                            <metadata id="CorelCorpID_0Corel-Layer"></metadata>
                            <path class="fil0"
                                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z">
                            </path>
                        </g>
                    </svg>
                </div>
                <div class="star-2">
                    <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1"
                        style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd"
                        viewBox="0 0 784.11 815.53" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <defs></defs>
                        <g id="Layer_x0020_1">
                            <metadata id="CorelCorpID_0Corel-Layer"></metadata>
                            <path class="fil0"
                                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z">
                            </path>
                        </g>
                    </svg>
                </div>
                <div class="star-3">
                    <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1"
                        style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd"
                        viewBox="0 0 784.11 815.53" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <defs></defs>
                        <g id="Layer_x0020_1">
                            <metadata id="CorelCorpID_0Corel-Layer"></metadata>
                            <path class="fil0"
                                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z">
                            </path>
                        </g>
                    </svg>
                </div>
                <div class="star-4">
                    <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1"
                        style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd"
                        viewBox="0 0 784.11 815.53" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <defs></defs>
                        <g id="Layer_x0020_1">
                            <metadata id="CorelCorpID_0Corel-Layer"></metadata>
                            <path class="fil0"
                                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z">
                            </path>
                        </g>
                    </svg>
                </div>
                <div class="star-5">
                    <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1"
                        style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd"
                        viewBox="0 0 784.11 815.53" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <defs></defs>
                        <g id="Layer_x0020_1">
                            <metadata id="CorelCorpID_0Corel-Layer"></metadata>
                            <path class="fil0"
                                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z">
                            </path>
                        </g>
                    </svg>
                </div>
                <div class="star-6">
                    <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1"
                        style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd"
                        viewBox="0 0 784.11 815.53" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <defs></defs>
                        <g id="Layer_x0020_1">
                            <metadata id="CorelCorpID_0Corel-Layer"></metadata>
                            <path class="fil0"
                                d="M392.05 0c-20.9,210.08 -184.06,378.41 -392.05,407.78 207.96,29.37 371.12,197.68 392.05,407.74 20.93,-210.06 184.09,-378.37 392.05,-407.74 -207.98,-29.38 -371.16,-197.69 -392.06,-407.78z">
                            </path>
                        </g>
                    </svg>
                </div>
            </button>
        </div>
            		<%
            	}
            %>
        </div>
    </div>
</body>
<script src="views/user/rooms/rooms.js"></script>
<script src="views/user/rooms/rangeCost.js"></script>
</html>