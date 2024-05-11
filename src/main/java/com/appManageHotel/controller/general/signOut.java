package com.appManageHotel.controller.general;

import java.io.IOException;

import com.appManageHotel.controller.url.url;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/signOut"})
public class signOut extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO POST /signOut");
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		Cookie cookie = new Cookie("IDSession", "");
		cookie.setMaxAge(0);
		
		resp.addCookie(cookie);
		String show = "Dang xuat thanh cong";
		resp.sendRedirect(url.urlServer + "home?show=" + show);
	}
}
