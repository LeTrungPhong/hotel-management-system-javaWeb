<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.appManageHotel.model.BEAN.Account" %>
<%@ page import="com.appManageHotel.model.BO.*" %>
<%@ page import="com.appManageHotel.controller.cookie.cookie" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="com.appManageHotel.model.DAO.AccountDAOImpl" %>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="views/user/home/style.css">
<link rel="stylesheet" href="views/user/header/style.css">
</head>
<body>
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
            <%
            	Cookie findCookieIDAccount = cookie.findCookieByName((HttpServletRequest)request, "IDAccount");
            	Account account = AccountBO.getInstance().selectAccountByCookie(findCookieIDAccount);    			
            	
            	%> 
            		<button class='header__sign-button header__sign-in <%= account != null ?"dp-n":""%>'>
                		<span>SIGN IN</span>
            		</button>
            		<button class='header__sign-button header__sign-up <%= account != null ?"dp-n":""%>'>
                		<span>SIGN UP</span>
            		</button>
            		
    				<div class="header__dashboard-account <%= account != null?"":"dp-n"%>">
                    	<i class="far fa-user header__dashboard-account-avatar"></i>
                    	<div class="header__dashboard-account-name">
                        	<p class="header__dashboard-account-name-text">
                           		<%= account != null ? account.getUserName(): "" %>
                        	</p>
                    	</div>
                    	<div class="header__dashboard-account-job">
                        	<p class="header__dashboard-account-job-text">
                            	<%= account != null ? account.getRole() : ""%>
                        	</p>
                    	</div>
                    	<i
                        	class="fas fa-chevron-down header__dashboard-account-nav-img"
                    	></i>
                    	<div class="header__dashboard-account-nav dp-n">
                        	<a href="#" class="header__dashboard-account-nav-item"
                            	>Update profile</a
                        	>
                        	<button class="header__dashboard-account-nav-item" onclick="signOut()">Sign out</button>
                        	<form method="post" action="" class="dp-n">
                        		<input type="text" name="type" value="signOut">
                        		<input type="submit" class="sign-out">
                        	</form>
                    	</div>
                	</div>
        </div>
    </header>
    <section class='background-opacity dp-n'></section>
    <article class='sign dp-n'>
        <div class='sign-in sign-item dp-n'>
            <i class="sign-in__close sign-item__close fas fa-times"></i>
            <p class='sign-in__title sign-item__title'>Đăng nhập</p>
            <form action="" class="sign-in__form sign-item__form" method="post">
                <input type="text" class="sign-in__form-input sign-item__form-input" placeholder=" Nhập tài khoản"
                    name="username" />
                <input type="password" class="sign-in__form-input sign-item__form-input" placeholder=" Nhập mật khẩu"
                    name="password" />
                <input class="sign-in__form-submit sign-item__form-submit" type="submit" value="Đăng nhập" />
                <input class="dp-n" type="text" value="signIn" name="type"/>
            </form>
        </div>
        <div class='sign-up sign-item dp-n'>
            <i class="sign-up__close sign-item__close fas fa-times"></i>
            <p class='sign-up__title sign-item__title'>Đăng ký</p>
            <form action="" class="sign-up__form sign-item__form" method="post">
                <input type="text" class="sign-up__form-input sign-item__form-input" placeholder=" Nhập tài khoản"
                    name="username" />
                <input type="password" class="sign-up__form-input sign-item__form-input" placeholder=" Nhập mật khẩu"
                    name="password" />
                <input type="password" class="sign-up__form-input sign-item__form-input"
                    placeholder=" Xác nhận lại mật khẩu" name="confirmPassword" />
                <input class="sign-up__form-submit sign-item__form-submit" type="submit" value="Đăng ký" />
                <input class="dp-n" type="text" value="signUp" name="type"/>
            </form>
        </div>
    </article>
</body>
<script src="views/user/header/index.js"></script>
</html>