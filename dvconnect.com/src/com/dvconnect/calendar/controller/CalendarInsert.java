package com.dvconnect.calendar.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.calendar.model.CalendarDAO;
import com.dvconnect.calendar.model.CalendarVO;

@WebServlet("/CalendarInsert.do")
public class CalendarInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/common/calendarInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		CalendarDAO dao = new CalendarDAO();
		CalendarVO vo = new CalendarVO();

		String calendarDate = request.getParameter("calendarDate");

		String schedule = request.getParameter("schedule");
//		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-DD");
		String id = (String) request.getSession().getAttribute("loginId");

		vo.setId(id);
		vo.setCalendarDate(calendarDate);
		vo.setSchedule(schedule);

		dao.calInsert(vo);

		response.sendRedirect("Calendar.do");
	}

}
