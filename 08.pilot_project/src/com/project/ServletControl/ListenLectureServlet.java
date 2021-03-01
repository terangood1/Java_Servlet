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

public class ListenLectureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("memberId")!=null) {
			if(request.getParameter("lectureNo")!=null) {
				String lectureNo = request.getParameter("lectureNo");
				LectureService service = new LectureService();
				ArrayList<LectureList> list = service.getListenLecture(lectureNo);
				if(list != null) {
					request.setAttribute("list", list);
					request.getRequestDispatcher("listenLecture.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "강의시청 실패");
					request.getRequestDispatcher("message.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("message", "수강신청을 먼저 하세요.");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}

			
		}else {
		request.setAttribute("message", "회원정용 서비스다 인증해라.");
		request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
