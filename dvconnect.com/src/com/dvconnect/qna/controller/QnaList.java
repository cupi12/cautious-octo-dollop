package com.dvconnect.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.common.Paging;
import com.dvconnect.qna.model.QnaDAO;
import com.dvconnect.qna.model.QnaVO;

@WebServlet("/QnaList.do")
public class QnaList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		String strPage = request.getParameter("p");
		int p =1;		
		
		
		QnaDAO dao = new QnaDAO();
		
		if(strPage != null && !strPage.isEmpty()) {
			p=Integer.parseInt(strPage);
		}
		
		Paging paging = new Paging();
		paging.setPageUnit(10); //한페이지에 출력할 레코드 건수
		paging.setPageSize(10); //한페이지에 출력할 페이지 번호 수
		paging.setPage(p); //현재 페이지
		paging.setTotalRecord(dao.getCount(title, contents)); //전체 레코드 건수 (조회 필수)!!!
		
		request.setAttribute("paging", paging);
		//목록 조회
		int start = paging.getFirst();
		int end = paging.getLast();
		
		List<QnaVO> qnaList = dao.getQnaList(start, end, title, contents);	
		
		request.setAttribute("qnaList", qnaList);
		request.getRequestDispatcher("/qna/qnaList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("QnaList.do");
	}

}
