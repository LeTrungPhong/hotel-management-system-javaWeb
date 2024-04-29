<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="views/user/assets/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
<script crossorigin
	src="https://unpkg.com/react@17/umd/react.development.js"></script>
<script crossorigin
	src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"></script>
<script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>
<script src="views/user/index.js"></script>
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
            <button class='header__sign-button header__sign-in'>
                <span>SIGN UP</span>
            </button>
            <button class='header__sign-button header__sign-up'>
                <span>REGISTER</span>
            </button>
        </div>
    </header>
    <section class='background-opacity dp-n'></section>
    <article class='sign dp-n'>
        <div class='sign-in sign-item dp-n'>
            <i class="sign-in__close sign-item__close fas fa-times"></i>
            <p class='sign-in__title sign-item__title'>Đăng nhập</p>
            <form action="" class="sign-in__form sign-item__form" method="POST">
                <input type="text" class="sign-in__form-input sign-item__form-input" placeholder=" Nhập tài khoản"
                    name="username" />
                <input type="password" class="sign-in__form-input sign-item__form-input" placeholder=" Nhập mật khẩu"
                    name="password" />
                <input class="sign-in__form-submit sign-item__form-submit" type="submit" value="Đăng nhập"/>
                <input type="text" class="dp-n" name="signIn" value="signIn">
            </form>
        </div>
        <div class='sign-up sign-item dp-n'>
            <i class="sign-up__close sign-item__close fas fa-times"></i>
            <p class='sign-up__title sign-item__title'>Đăng ký</p>
            <form action="" class="sign-up__form sign-item__form" method="POST">
                <input type="text" class="sign-up__form-input sign-item__form-input" placeholder=" Nhập tài khoản"
                    name="username" />
                <input type="password" class="sign-up__form-input sign-item__form-input" placeholder=" Nhập mật khẩu"
                    name="password" />
                <input type="password" class="sign-up__form-input sign-item__form-input"
                    placeholder=" Xác nhận lại mật khẩu" name="confirmPassword" />
                <input class="sign-up__form-submit sign-item__form-submit" type="submit" value="Đăng ký" />
                <input type="text" class="dp-n" name="signUp" value="signUp">
            </form>
        </div>
    </article>
    <div class="body__image">
        <img class="body__image__instance" src="./assets/image/1543331218(1).jpg" alt="">
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

        <button class="viewAllRooms">
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
            <div class="room__item">
                <div class="container_item">
                    <img src="http://localhost:8080/javaWeb-hms-pbl3/views/user/assets/image/beach_view_suite.jpg" alt="">
                    <div class="bottom__infor">
                        <span>The Beach View Suite offers a breathtaking panorama of the shimmering ocean, seamlessly
                            blending luxurious comfort with a serene, picturesque backdrop.</span>
                        <p class="infor__cost__maxPeople">
                            <button class="infor__cost">
                                Price: 20$
                            </button>

                            <button class="infor__maxPeople">
                                Max People: 2
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
                <h3 class="room__item__title">BEACH VIEW SUITE</h3>
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
            <div class="room__item">
                <div class="container_item">
                    <img src="./assets/image/standard_double.jpg" alt="">
                    <div class="bottom__infor">
                        <span>The Standard Double room in a hotel offers a cozy, efficiently designed space featuring
                            two double beds, ideal for couples or small families seeking comfortable
                            accommodation.</span>
                        <p class="infor__cost__maxPeople">
                            <button class="infor__cost">
                                Price: 35$
                            </button>

                            <button class="infor__maxPeople">
                                Max People: 4
                            </button>
                        </p>
                        <p>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                        </p>
                    </div>
                </div>
                <h3 class="room__item__title">STANDARD DOUBLE</h3>
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
            <div class="room__item">
                <div class="container_item">
                    <img src="./assets/image/beach_view_single.jpg" alt="">
                    <div class="bottom__infor">
                        <span>The Beach View Single room offers a cozy, inviting space with a stunning view of the
                            ocean, perfect for solo travelers seeking serenity and scenic beauty.</span>
                        <p class="infor__cost__maxPeople">
                            <button class="infor__cost">
                                Price: 25$
                            </button>

                            <button class="infor__maxPeople">
                                Max People: 2
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
                <h3 class="room__item__title">BEACH VIEW SINGLE</h3>
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
        </div>
    </div>

    <div class="body__amenity__service">
        <h1 class="pattern__title">
            AMENITIES & SERVICES
        </h1>

        <button class="viewAllRooms">
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
            <div class="service__item">
                <div class="card">
                    <img src="https://easysalon.vn/wp-content/uploads/2019/11/phan-biet-spa-va-tham-my-vien-4.jpeg"
                        alt="">
                    <div class="card__content">
                        <p class="card__title">SPA Service</p>
                        <p class="card__description">Luxury hotel spas provide a serene retreat with professional
                            massages, facials, and hydrotherapy in a plush setting.</p>
                        <div class="card__rating">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        </div>
                    </div>
                </div>
                <h3 class="room__item__title">SPA</h3>
            </div>
            <div class="service__item">
                <div class="card">
                    <img src="./assets/image/meal_service.jpg" alt="">
                    <div class="card__content">
                        <p class="card__title">Buffet Service</p>
                        <p class="card__description">
                            Hotel buffets offer a variety of dishes and cuisines in an all-you-can-eat format, catering
                            to diverse tastes in a casual dining environment.
                        </p>
                        <div class="card__rating">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                        </div>
                    </div>
                </div>
                <h3 class="room__item__title">BUFFET</h3>
            </div>
            <div class="service__item">
                <div class="card">
                    <img src="./assets/image/bike_rental.jpg" alt="">
                    <div class="card__content">
                        <p class="card__title">Rental Service</p>
                        <p class="card__description">Bike rental services at hotels provide guests with convenient
                            access to bicycles for easy exploration of the surrounding area.
                        </p>

                        <div class="card__rating">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        </div>
                    </div>
                </div>
                <h3 class="room__item__title">RENTAL</h3>
            </div>
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
</body>
</html>