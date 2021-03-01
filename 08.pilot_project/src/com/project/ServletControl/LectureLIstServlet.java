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
 * 강의목록화면 서블렛 클래스 
 * @author 이종찬
 * @since jdk 1.8
 * @version 1.0
 */
public class LectureLIstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		LectureService service = new LectureService();
		ArrayList<LectureList> list = service.getLectureList();
		
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("lectureList.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "강의목록 불러오는중 오류 발생");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
