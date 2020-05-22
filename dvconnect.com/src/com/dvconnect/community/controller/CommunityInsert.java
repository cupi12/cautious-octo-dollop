package com.dvconnect.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.community.model.CommunityDAO;
import com.dvconnect.community.model.CommunityVO;

@WebServlet("/CommunityInsert.do")
public class CommunityInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/community/communityInsert.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("utf-8"); 
		CommunityDAO dao = new CommunityDAO();
		CommunityVO vo = new CommunityVO();
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String nickName = (String)request.getSession().getAttribute("nickName");
		String id = (String) request.getSession().getAttribute("loginId");
		
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setNickName(nickName);
		vo.setId(id);
				
		dao.CommunityInsert(vo);
		
		response.sendRedirect("CommunityList.do");
	}

}
