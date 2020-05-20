package com.dvconnect.calendar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.calendar.model.CalendarDAO;
import com.dvconnect.calendar.model.CalendarVO;


@WebServlet("/CalendarSchedule.do")
public class CalendarSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CalendarDAO dao = new CalendarDAO();
		String calendarDate = request.getParameter("calendarDate");
		
		request.setAttribute("vo", dao.getCal(calendarDate));
		request.getRequestDispatcher("/common/calendarSchedule.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		CalendarDAO dao = new CalendarDAO();
		CalendarVO vo = new CalendarVO();
				
		String schedule = request.getParameter("schedule");
		String calendarDate = request.getParameter("calendarDate");
		
		vo.setSchedule(schedule);
		vo.setCalendarDate(calendarDate);
		
		dao.calUpdate(vo);
		
		request.setAttribute("vo", dao.getCal(calendarDate));
		request.getRequestDispatcher("/common/calendarSchedule.jsp").forward(request, response);
//		response.sendRedirect("CalendarSchedule.do?calendarDate="+calendarDate);

	}

}
