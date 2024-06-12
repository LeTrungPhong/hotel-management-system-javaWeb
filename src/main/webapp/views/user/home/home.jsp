<%@page import="com.appManageHotel.model.DAO.ImageDAOimpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.appManageHotel.model.BEAN.Account" %>
<%@ page import="com.appManageHotel.controller.cookie.cookie" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="com.appManageHotel.model.DAO.AccountDAOImpl" %>
<%@ page import="com.appManageHotel.controller.url.*"%>
<%@ page import="com.appManageHotel.model.BEAN.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="views/user/home/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
<script crossorigin
	src="https://unpkg.com/react@17/umd/react.development.js"></script>
<script crossorigin
	src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"></script>
<script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>
<title>Trang chu</title>
<style>
	.flex-direction-column {
		flex-direction: column !important;
		gap: 5px;
	}
</style>
</head>
<body class="container">
    <jsp:include page="../header/header.jsp"/> 
    <div class="body__image">
        <img class="body__image__instance" src="<%= url.urlImgHome %>" alt="">
        <div class="body__background__pattern">
            <h1 class="pattern__title">
                WELCOME TO BEACHFRONT BLISS HOTEL
            </h1>

            <h3 class="pattern__short">
                Immerse yourself in the serene ambiance of Beachfront Bliss Hotel, ideally situated right on the edge of
                a shimmering coastline. This luxurious retreat is designed as a sanctuary where the rhythmic sounds of
                the waves set a peaceful backdrop to every moment
            </h3>

            <p class="pattern__content">
                Located directly on a stunning beach, Beachfront Bliss Hotel offers an idyllic retreat with luxurious
                accommodations and breathtaking ocean views. Our hotel features 100 beautifully appointed rooms and
                suites, each designed with modern amenities and elegant coastal decor. Guests can enjoy exclusive beach
                access, a spectacular infinity pool, and a full-service spa for ultimate relaxation. Dine at our seaside
                restaurant, unwind at the beachfront bar, or indulge in unique experiences like seafood cooking classes.
                With a commitment to sustainability, Beachfront Bliss Hotel ensures a serene and environmentally
                responsible getaway. Perfect for those who cherish both luxury and the tranquility of the ocean.
            </p>

            <button class="Learn__More">
                <h4>Learn More</h4>
            </button>
        </div>
    </div>
    <div class="body__rooms">
        <h1 class="pattern__title">
            ACCOMMODATION
        </h1>
        <button class="viewAllRooms" onclick="window.location.href='<%= url.urlServer + "rooms" %>'">
            <span class="circle1"></span>
            <span class="circle2"></span>
            <span class="circle3"></span>
            <span class="circle4"></span>
            <span class="circle5"></span>
            <span class="text">VIEW ALL ROOMS</span>
        </button>

        <p class="room__content">
            From materials, textures and finishes to lighting and color palate, smartly designed guestrooms are enhanced
            by furniture that is custom made to embrace the individuality of each space-conscious room type.
        </p>

        <div class="room__list">
            <%
            	ArrayList<TypeRoom> listTypeRoomMaxBooked = (ArrayList<TypeRoom>)request.getAttribute("listTypeRoomMaxBooked");
                if(listTypeRoomMaxBooked != null){
                	for(int i = 0; i < listTypeRoomMaxBooked.size(); ++i){
                		ArrayList<Image> listImage = ImageDAOimpl.getInstance().selectByIDTypeRoom(listTypeRoomMaxBooked.get(i).getIDTypeRoom());
                		%>
              <div class="room__item">
                <div class="container_item">
                    <img src="<%= listImage != null ? listImage.get(0).getPath() : "https://i.ibb.co/RbVrNbX/default-image.png" %>" alt="">
                    <div class="bottom__infor">
                        <span><%= listTypeRoomMaxBooked.get(i).getDescription() %></span>
                        <p class="infor__cost__maxPeople flex-direction-column">
                            <button class="infor__cost">
                                Price: <%= listTypeRoomMaxBooked.get(i).getPrice() %>$
                            </button>
                            <button class="infor__maxPeople">
                                Max Adult: <%= listTypeRoomMaxBooked.get(i).getMaxAdult() %>
                            </button>
                            <button class="infor__maxPeople">
                                Max People: <%= listTypeRoomMaxBooked.get(i).getMaxChild() %>
                            </button>
                        </p>
                        <p>
                            <i class="fas fa-star"></i> 
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        </p>
                    </div>
                </div>
                <h3 class="room__item__title"><%= listTypeRoomMaxBooked.get(i).getTypeRoomName() %></h3>
                <button class="book_now" onclick="window.location.href='<%= url.urlServer + "bookRoom?IDTypeRoom=" + listTypeRoomMaxBooked.get(i).getIDTypeRoom() %>'">
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
                }
            %>
        </div>
    </div>

    <div class="body__amenity__service">
        <h1 class="pattern__title">
            AMENITIES & SERVICES
        </h1>

        <button class="viewAllRooms" onclick="window.location.href='<%= url.urlServer + "services" %>'">
            <span class="circle1"></span>
            <span class="circle2"></span>
            <span class="circle3"></span>
            <span class="circle4"></span>
            <span class="circle5"></span>
            <span class="text">VIEW ALL SERVICES</span>
        </button>

        <div class="body__background__amenity__service">
            <div class="amenity__service__list">
                <div class="amenity__service__item">
                    <img src="https://riversidetowerhotel.com/wp-content/uploads/2023/06/cafe.png" alt="">
                    <h3 class="amenity__service__item__title">Cafe</h3>
                </div>
                <div class="amenity__service__item">
                    <img src="https://riversidetowerhotel.com/wp-content/uploads/2023/06/business-center.png" alt="">
                    <h3 class="amenity__service__item__title">Business Center</h3>
                </div>
                <div class="amenity__service__item">
                    <img src="https://riversidetowerhotel.com/wp-content/uploads/2023/06/gym.png" alt="">
                    <h3 class="amenity__service__item__title">Gym</h3>
                </div>
                <div class="amenity__service__item">
                    <img src="https://riversidetowerhotel.com/wp-content/uploads/2023/06/wifi.png" alt="">
                    <h3 class="amenity__service__item__title">Wifi</h3>
                </div>
                <div class="amenity__service__item">
                    <img src="https://riversidetowerhotel.com/wp-content/uploads/2023/06/air-conditioning.png" alt="">
                    <h3 class="amenity__service__item__title">Air Condition</h3>
                </div>
            </div>
        </div>

        <div class="list__service">
            <%
            	ArrayList<Service> listServiceMaxUsed = (ArrayList<Service>)request.getAttribute("listServiceMaxUsed");
            	if(listServiceMaxUsed != null){
            		for(int i = 0; i < listServiceMaxUsed.size(); ++i){
            			Image image = ImageDAOimpl.getInstance().selectByID(listServiceMaxUsed.get(i).getIDImage());
            			%>
            <div class="service__item">
                <div class="card">
                    <img src="<%= image != null ? image.getPath() : "https://i.ibb.co/RbVrNbX/default-image.png" %>" alt="">
                    <div class="card__content">
                        <p class="card__title"><%= listServiceMaxUsed.get(i).GetServiceName() %></p>
                        <p class="card__description"><%= listServiceMaxUsed.get(i).getDescription() %></p>
                        <div class="card__rating">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        </div>
                    </div>
                </div>
                <h3 class="room__item__title"><%= listServiceMaxUsed.get(i).GetServiceName() %></h3>
            </div>
            			<%
            		}
            	}
            %>
        </div>
    </div>
    <div class="containerContactUs">
        <div class="content">
            <div class="left-side">
                <div class="address details">
                    <i class="fas fa-map-marker-alt"></i>
                    <div class="topic">Address</div>
                    <div class="text-one">54 Nguyen Luong Bang</div>
                    <div class="text-two">Hoa Khanh, Da Nang</div>
                </div>
                <div class="phone details">
                    <i class="fas fa-phone-alt"></i>
                    <div class="topic">Phone</div>
                    <div class="text-one">+84868880471</div>
                    <div class="text-two">+84765126302</div>
                </div>
                <div class="email details">
                    <i class="fas fa-envelope"></i>
                    <div class="topic">Email</div>
                    <div class="text-one">trung9204@gmail.com</div>
                    <div class="text-two">trungproasdasd@gmail.com</div>
                </div>
            </div>
            <div class="right-side">
                <div class="topic-text">Send us a message</div>
                <p>If you have any work from me or any types of quries related to my tutorial, you can send me message
                    from here. It's my pleasure to help you.</p>
                <form action="#">
                    <div class="input-box">
                        <input type="text" placeholder="Enter your name">
                    </div>
                    <div class="input-box">
                        <input type="text" placeholder="Enter your email">
                    </div>
                    <div class="input-box message-box">
                        <textarea placeholder="Enter your message"></textarea>
                    </div>
                    <div class="button">
                        <input type="button" value="Send Now">
                    </div>
                </form>
            </div>
        </div>
    </div>
<script>
	const urlParams = new URLSearchParams(window.location.search);
	const paramValue = urlParams.get('show');
	if(paramValue){
		alert(paramValue);
	}
</script>
</body>
</html>