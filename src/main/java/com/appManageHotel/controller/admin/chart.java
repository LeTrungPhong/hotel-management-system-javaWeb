package com.appManageHotel.controller.admin;

import java.io.IOException;
import java.time.LocalDate;

import com.appManageHotel.model.BO.ChartBO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/chart"})
public class chart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalDate timeNow = LocalDate.now();
		int Year = req.getParameter("year") != null ? Integer.parseInt(req.getParameter("year")) : timeNow.getYear();
		
		int Month = req.getParameter("month") != null ? Integer.parseInt(req.getParameter("month")) : timeNow.getMonthValue();
		
		req.setAttribute("chartMonth", ChartBO.getInstance().statisticByYear(Year));
		
		req.setAttribute("chartDay", ChartBO.getInstance().statisticByMonth(Month, Year));
		
		req.setAttribute("chartTypeRoomName", ChartBO.getInstance().getTypeRoom());
		
		req.setAttribute("chartNumberBook", ChartBO.getInstance().StatisticNumberBook());
		
		req.setAttribute("chartMoneyOfTypeRoom", ChartBO.getInstance().StatisticByTypeRoom());
		
		req.setAttribute("chartServiceName", ChartBO.getInstance().getServiceName());
		
		req.setAttribute("chartNumberUse", ChartBO.getInstance().StatisticByService());
		
		req.setAttribute("chartMoneyOfService", ChartBO.getInstance().MoneyOfService());
		
		for(int i = 0; i < ChartBO.getInstance().StatisticByService().size(); ++i) {
			System.out.println(ChartBO.getInstance().StatisticByService().get(i));
		}
		
		System.out.println("DO GET /chartMonth");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/admin/chart.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}
