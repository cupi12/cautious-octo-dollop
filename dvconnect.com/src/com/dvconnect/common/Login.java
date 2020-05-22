package com.dvconnect.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dvconnect.member.model.MemberDAO;
import com.dvconnect.member.model.MemberVO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("common/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");		

		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);

		if (vo.getId() == null) { // id 오류
			out.print("id 오류!");
		} else if (!vo.getPwd().equals(pwd)) { // pwd 오류
			out.print("pwd 오류!");
		} else { // 로그인 성공
			// 세션에 로그인 여부를 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			session.setAttribute("nickName", vo.getNickName());
			session.setAttribute("loginMember", vo);
			request.getRequestDispatcher("/").forward(request, response);
			out.print("로그인 성공");
		}
//		doGet(request, response);
	}

}
