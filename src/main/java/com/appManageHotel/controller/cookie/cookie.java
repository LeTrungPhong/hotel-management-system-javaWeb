package com.appManageHotel.controller.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class cookie {
	public static Cookie findCookieByName(HttpServletRequest request, String cookieName) {
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals(cookieName)) {
	                return cookie;
	            }
	        }
	    }
	    return null;
	}
}
