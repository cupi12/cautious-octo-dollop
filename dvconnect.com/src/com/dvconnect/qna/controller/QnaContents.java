package com.dvconnect.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.qna.model.QnaDAO;
import com.dvconnect.qna.model.QnaVO;

/**
 * Servlet implementation class QnaContents
 */
@WebServlet("/QnaContents.do")
public class QnaContents extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		int seq1 = Integer.parseInt(seq);
		
		QnaVO vo = new QnaVO();
		QnaDAO dao = new QnaDAO();
				
		request.setAttribute("vo", dao.getQna(seq1));
		request.getRequestDispatcher("/qna/qnaContents.jsp").forward(request, response);
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnaDAO dao = new QnaDAO();
		QnaVO vo = new QnaVO();
		
		dao.QnaUpdate(vo);
		request.getRequestDispatcher("/qna/qnaList.jsp").forward(request, response);
	}

}
