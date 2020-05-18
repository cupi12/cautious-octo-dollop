package com.dvconnect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvconnect.member.model.MemberDAO;
import com.dvconnect.member.model.MemberVO;

@WebServlet("/MemberInsert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberInsert() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String nickName = request.getParameter("nickName");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setId(id);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setNickName(nickName);
		int r = dao.memberInsert(vo);

		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/Main.do");
		
	}

}
