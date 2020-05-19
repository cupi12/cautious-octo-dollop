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
		QnaDAO dao = new QnaDAO();
		List<QnaVO> qnaList = dao.getQnaList();
		
		String strPage =request.getParameter("p");
		int p =1;
		if(strPage != null && !strPage.isEmpty()) {
			p = Integer.parseInt(strPage);
		}
		//페이징 객체를 생성
		Paging paging = new Paging();
		paging.setPageUnit(5); //한페이지에 출력할 레코드 건수
		paging.setPageSize(5); //한페이지에 출력할 페이지 번호 수
		paging.setPage(p); //현재 페이지
		paging.setTotalRecord(dao.getCount(title, contents)); //전체 레코드 건수 (조회 필수)!!!
		
		request.setAttribute("paging", paging);
		
		request.setAttribute("qnaList", qnaList);
		request.getRequestDispatcher("/qna/qnaList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
