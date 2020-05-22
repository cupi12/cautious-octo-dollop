package com.dvconnect.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.community.model.CommunityDAO;
import com.dvconnect.qna.model.QnaDAO;
import com.dvconnect.qna.model.QnaVO;

@WebServlet("/CommunityUpdate.do")
public class CommunityUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = (Integer.parseInt(request.getParameter("seq")));
		if(seq ==0) {
			response.sendRedirect(request.getContextPath() + "/CommunityUpdate.do");
		}
		CommunityDAO dao = new CommunityDAO();
		
		request.setAttribute("vo", dao.getCommunity(seq));
		request.getRequestDispatcher("/qna/qnaUpdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8"); 	
		int seq=Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");				
		
		
		QnaDAO dao = new QnaDAO();
		QnaVO vo = new QnaVO();
		
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContents(contents);
		
		
		dao.QnaUpdate(vo);
		
		request.getRequestDispatcher("QnaList.do").forward(request, response);
		
	}

}
