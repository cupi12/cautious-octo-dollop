package com.dvconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.dvconnect.member.model.MemberDAO;
import com.dvconnect.member.model.MemberVO;

@WebServlet("/MemberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();		
		String id =(String) request.getSession().getAttribute("loginId");		
		
		request.setAttribute("vo", dao.getMember(id));
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		String id = (String) request.getSession().getAttribute("loginId");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String nickName = request.getParameter("nickName");
		
		
		vo.setEmail(email);
		vo.setNickName(nickName);
		vo.setPwd(pwd);
		vo.setId(id);
		
		
		dao.memberUpdate(vo);
//		response.sendRedirect("/common/header.jsp");
		
		request.getRequestDispatcher("/common/main.jsp").forward(request, response);
	}

}
