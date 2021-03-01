package com.project.ServletControl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Service.LectureService;
import com.project.model.dto.LectureList;

/**
 * 수강신청 서블렛 
 * 
 * @author 이종찬
 * @since jdk 1.8
 * @version 1.0
 */
public class InsertMyLectureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("memberId")!=null) {
			String memberId = (String)session.getAttribute("memberId");
			String lectureNo = request.getParameter("lectureNo");
			String lectureName = request.getParameter("lectureName");
			String lectureTeacher = request.getParameter("lectureTeacher");

			LectureService service = new LectureService();
			String existResult = service.existLecture(memberId, lectureNo);
			if(existResult.equals("0")) {
				boolean result = service.insertMyLecture(memberId, lectureNo,lectureName, lectureTeacher);
				
					if(result) {
						response.sendRedirect("lectureList");
						
					}else {
						request.setAttribute("message", "수강신청 실패");
						request.getRequestDispatcher("message.jsp").forward(request, response);
					}
			}else {
				request.setAttribute("message", "이미 신청한 강의입니다.");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
			
		}else {
		request.setAttribute("message", "수강 신청은 회원정용 서비스다 인증해라.");
		request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
