package com.dvconnect.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.community.model.CommunityDAO;
import com.dvconnect.community.model.CommunityVO;

@WebServlet("/CommunityContents.do")
public class CommunityContents extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		int seq1 = Integer.parseInt(seq);
		
		CommunityVO vo = new CommunityVO();
		CommunityDAO dao = new CommunityDAO();
				
		request.setAttribute("vo", dao.getCommunity(seq1));
		request.getRequestDispatcher("/community/communityContents.jsp").forward(request, response);
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunityDAO dao = new CommunityDAO();
		CommunityVO vo = new CommunityVO();
		
		dao.CommunityUpdate(vo);
		request.getRequestDispatcher("/community/communityList.jsp").forward(request, response);
	}

}
