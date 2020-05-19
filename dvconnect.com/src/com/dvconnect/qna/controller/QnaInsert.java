package com.dvconnect.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.qna.model.QnaDAO;
import com.dvconnect.qna.model.QnaVO;

@WebServlet("/QnaInsert.do")
public class QnaInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/qna/qnaInsert.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("utf-8"); 
		QnaDAO dao = new QnaDAO();
		QnaVO vo = new QnaVO();
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String nickName = (String)request.getSession().getAttribute("nickName");
		String id = (String) request.getSession().getAttribute("loginId");
		
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setNickName(nickName);
		vo.setId(id);
				
		dao.QnaInsert(vo);
		
		response.sendRedirect("QnaList.do");
	}

}
