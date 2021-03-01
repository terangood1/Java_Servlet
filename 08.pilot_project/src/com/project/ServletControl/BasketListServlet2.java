package com.project.ServletControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Service.LectureService;

public class BasketListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("memberId")!=null) {
			String memberId = (String)session.getAttribute("memberId");
			String lectureNo = request.getParameter("lectureNo");
			String lectureName = request.getParameter("lectureName");
			String lectureTeacher = request.getParameter("lectureTeacher");
			int lecturePrice = Integer.parseInt(request.getParameter("lecturePrice"));

			LectureService service = new LectureService();
			String existResult = service.existLecture(memberId, lectureNo);
			if(existResult.equals("0")) {
				String existBasket= service.existBasket(memberId, lectureNo);
				if(existBasket.equals("0")) {
					boolean result = service.insertMyBasket(memberId, lectureNo,lectureName, lectureTeacher,lecturePrice);
		
					if(result) {
						response.sendRedirect("lectureList");	
					}else {
						request.setAttribute("message", "장바구니 신청 실패");
						request.getRequestDispatcher("message.jsp").forward(request, response);
						}
				}else {
					request.setAttribute("message", "이미 장바구니에 있는 강의입니다.");
					request.getRequestDispatcher("message.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("message", "이미 수강목록에 있는 강의입니다.");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
		}else {
		request.setAttribute("message", "회원정용 서비스다 인증해라.");
		request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
