package com.dvconnect.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.community.model.CommunityDAO;
import com.dvconnect.community.model.CommunityVO;
import com.dvconnect.qna.model.QnaDAO;
import com.dvconnect.qna.model.QnaVO;

@WebServlet("/")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strPage = request.getParameter("p");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		int p =1;
	
		QnaDAO dao = new QnaDAO();
		
		Paging paging = new Paging();
		paging.setPageUnit(5); //한페이지에 출력할 레코드 건수
		paging.setPage(p); //현재 페이지
		paging.setTotalRecord(dao.getCount(title, contents)); //전체 레코드 건수 (조회 필수)!!!
		int start = paging.getFirst();
		int end = paging.getLast();
		List<QnaVO> qnaList = dao.getQnaList(start, end, title, contents);		
		request.setAttribute("qnaList", qnaList);
		
		CommunityDAO cDao = new CommunityDAO();
		List<CommunityVO> communityList = cDao.getCommunityList(start, end, title, contents);		
		request.setAttribute("communityList", communityList);
		
		request.getRequestDispatcher("/common/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
