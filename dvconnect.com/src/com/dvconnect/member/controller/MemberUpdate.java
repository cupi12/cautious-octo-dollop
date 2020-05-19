package com.dvconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.member.model.MemberDAO;
import com.dvconnect.member.model.MemberVO;

@WebServlet("/MemberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/common/memberupdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String nickName = request.getParameter("nickName");
		
		vo.setEmail(email);
		vo.setNickName(nickName);
		vo.setPwd(pwd);
		
		
		dao.memberUpdate(vo);
		
		request.getRequestDispatcher("/common/header.jsp").forward(request, response);
	}

}
