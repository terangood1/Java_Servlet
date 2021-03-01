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

public class LectureInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String lectureNo = request.getParameter("lectureNo");
		if(lectureNo != null) {
			LectureService service = new LectureService();
			ArrayList<LectureList> list = service.getLectureInformation(lectureNo);
			if(list != null) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("lectureInformation.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "상세정보를 읽어오는 도중 오류 발생");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("message", "잘못된 접근. 강의 상세정보를 할 수 없음");
			request.getRequestDispatcher("message.jsp").forward(request, response);
				}
	}

}
