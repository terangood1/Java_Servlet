package com.project.ServletControl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Service.MemberService;
import com.project.model.dto.Member;
import com.project.util.Utility;

/**
 * 회원가입 서블렛 클래스 
 * @author 이종찬
 * @since jdk 1.8
 * @version 1.0
 */
public class MemberInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//요청 데이터 가져오기 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile1 = request.getParameter("mobile1");
		String mobile2 = request.getParameter("mobile2");
		String mobile3 = request.getParameter("mobile3");
		String mobile = mobile1 + "-" + mobile2 + "-" + mobile3;
		String email_front = request.getParameter("email_front");
		String email_end = request.getParameter("email_end");
		String email = email_front+email_end;
		String entry_date = Utility.getCurrentDate();
		
		Member dto = new Member(memberId, memberPw, name,mobile, email, entry_date, "C" );
		
		MemberService service = new MemberService();
		boolean result = service.addMember(dto);
		
		if(result) {
			response.sendRedirect("login.jsp");
		}else {
			request.setAttribute("message", "회원가입이 정상적으로 이루어지지 않았습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}
	}

}
