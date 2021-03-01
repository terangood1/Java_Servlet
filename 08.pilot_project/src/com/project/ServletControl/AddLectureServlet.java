package com.project.ServletControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Service.LectureService;
import com.project.model.dto.LectureList;
import com.project.util.Utility;

public class AddLectureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String lectureNo = request.getParameter("lectureNo");
		String lectureName = request.getParameter("lectureName");
		String lectureTeacher = request.getParameter("lectureTeacher");
		String lecturePriceString = request.getParameter("lecturePrice");
		int lecturePrice =  Integer.parseInt(lecturePriceString);
		String lectureRegDate = Utility.getCurrentDate();
		String lectureInfo = request.getParameter("lectureInfo");
		String lectureVideo = request.getParameter("lectureVideo");
				
		LectureList list = new LectureList(lectureNo, lectureName, lectureTeacher, lecturePrice, lectureRegDate, lectureInfo, lectureVideo );
		LectureService service = new LectureService();
		boolean result = service.addLecture(list);
		
		if(result) {
			response.sendRedirect("main.jsp");
		}else {
			request.setAttribute("message", "강의등록 오류입니다.");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		
	}

}
