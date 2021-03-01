package com.project.ServletControl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Service.MemberService;

/**
 * 회원 로그인 서블렛
 * @author 이종찬
 * @since jdk 1.8
 * @version 1.0
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		if(memberId == null || memberId.trim().length() == 0) {
			//System.out.println("아이디 미입력 ");
			request.setAttribute("message", "아이디 미입력 ");//첫 키는 내가 정하는 이름 
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
			return;//입력이 안되면 밑에걸 수행할 이유가 없어서 리턴을 해줌 -> 아이디 비번 둘다 안적어도 아이디미입력만 출력된느 이유
		}
		if(memberPw == null || memberPw.trim().length() == 0) {
			request.setAttribute("message", "비밀번호 미입력 ");//첫 키는 내가 정하는 이름 
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
			return; //입력이 안되면 밑에걸 수행할 이유가 없어서 리턴을 해줌
		}
		
		MemberService service = new MemberService();
		String grade = service.login(memberId, memberPw);
		
		if(grade != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("memberId", memberId);
			session.setAttribute("grade", grade);
			response.sendRedirect("main.jsp");
			
		}else {
			request.setAttribute("message", "로그인정보가 올바르지 않습니다");
			request.getRequestDispatcher("message.jsp").forward(request, response);;

			
		}
		
	}

}
