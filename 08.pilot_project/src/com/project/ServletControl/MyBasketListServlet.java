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

public class MyBasketListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("memberId")!=null) {
			String memberId = (String) session.getAttribute("memberId");
			
			LectureService service = new LectureService();
			ArrayList<LectureList> list = service.getMyBasketList(memberId);
			
			if(list!=null) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("myBasketList.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "내 강의목록 불러오는중 오류 발생");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("message", "[실패] 회원전용 서비스입니다. 사용자 인증후 이용하시기 바랍니다.");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
