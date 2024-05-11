package com.appManageHotel.controller.general;

import java.io.IOException;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.BO.AccountBO;
import com.appManageHotel.model.DAO.AccountDAOImpl;
import com.appManageHotel.controller.cookie.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/changePassWord"})
public class changePassWord extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO GET /changePassWord");
		
		HttpSession session = request.getSession();
		
		String IDAccount = session.getAttribute("IDAccount") != null ? (String)session.getAttribute("IDAccount") : "";
		if(!IDAccount.equals("")) {
			Account account = AccountDAOImpl.getInstance().selectByID(IDAccount);
			if(account != null) {
				request.setAttribute("Account", account);
				RequestDispatcher rd1 = request.getRequestDispatcher("/views/general/changePassWord/changePassWord.jsp");
				rd1.forward(request, response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post in changePassWord");
		String typeRequest = req.getParameter("type");
		String show = "";
		if(typeRequest.equals("changePassWord")) {
			System.out.println("changePassWord");
			
			String UserName = req.getParameter("UserName");
			String PassWord = req.getParameter("PassWord");
			String NewPassWord = req.getParameter("NewPassWord");
			
			HttpSession session = req.getSession();
			
			String IDAccount = session.getAttribute("IDAccount") != null ? (String)session.getAttribute("IDAccount") : "";
			
			if(!IDAccount.equals("")) {
				System.out.println(IDAccount + " " + UserName + " " + PassWord + " " + NewPassWord);
				if(AccountBO.getInstance().updateAccount(new Account(IDAccount, UserName, PassWord, ""), NewPassWord)) {
					 System.out.println("Cap nhat mat khau thanh cong");
					 show = "Cap nhat mat khau thanh cong";
				} else {
					System.out.println("Loi khong the cap nhat mat khau");
					show = "Loi khong the cap nhat mat khau";
				}
			}
		}
		resp.sendRedirect(url.urlServer + "changePassWord?show=" + show);
	}
}