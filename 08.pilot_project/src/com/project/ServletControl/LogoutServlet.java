package com.project.ServletControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			if(session.getAttribute("memberId") !=null && session.getAttribute("grade")!=null) {
				session.removeAttribute("memberId");
				session.removeAttribute("grade");
				session.invalidate();
				response.sendRedirect("main.jsp");
				return;
			}
		}
		request.setAttribute("message", "올바르지 않은 로그아웃 요청입니다.");
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
