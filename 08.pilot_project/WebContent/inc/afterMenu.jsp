<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- main menu : 실습 3개의 html 파일 작성 -->
<hr>
<a href="lectureList" id="side_menu1">강의목록</a><span class="seperator">|</span>
<a href="myLectureList">내수강목록</a><span class="seperator">|</span>
<a href="myBasketList">장바구니</a><span class="seperator">|</span>
<div id="main_menu">
	<%= session.getAttribute("memberId") %>님 반갑습니다.
	<span class="seperator">|</span>
	<a href="logout">로그아웃</a><span class="seperator">|</span>
	<%
	if (session.getAttribute("grade").equals("A")) {
	%>
	관리자
	<a href="AddLecture.jsp">강의등록</a><span class="seperator">|</span>
	<%
		}
	%>	


</div>
<hr>