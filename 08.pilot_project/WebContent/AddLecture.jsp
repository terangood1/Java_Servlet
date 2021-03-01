<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의등록</title>
<!-- external css  -->
<link type="text/css" rel="stylesheet" href="css/common.css" >
</head>
<body>
<h3>강의등록 페이지</h3>
<hr>
<a href="lectureList" id="side_menu1">강의목록</a><span class="seperator">|</span>
<div id="main_menu">
	<%= session.getAttribute("memberId") %>
	<span class="seperator">|</span>
	<a href="logout">로그아웃</a><span class="seperator">|</span>
	&nbsp;
	[관리자] 
	<a href="AddLecture.jsp">강의등록</a><span class="seperator">|</span>
</div>
<hr>
<!--  contents menu  -->
<form action="addLecture" method="post">
<table border="1">
<tr>
	<th>강의번호</th>
	<td>
	<input type="text" name="lectureNo" autofocus="autofocus" required="required">
	</td>
</tr>
<tr>
	<th>강의이름</th>
	<td>
	<input type="text" name="lectureName" required="required">
	</td>
</tr><tr>
	<th>강사님 이름</th>
	<td>
	<input type="text" name="lectureTeacher" required="required">
	</td>
</tr>
<tr>
	<th>강의가격</th>
	<td>
	<input type="text" name="lecturePrice" required="required">
	</td>
</tr>
<tr>
	<th>강의 상세정보</th>
	<td>
	<input type="text" name="lectureInfo" required="required">
	</td>
</tr>
<tr>
	<th>강의 url</th>
	<td>
	<input type="text" name="lectureVideo" required="required">
	</td>
</tr>
<tr>
			<th colspan="2">
			<input type="submit" value="강의등록하기">
			<input type="reset" value="다시입력">
			</th>
		</tr>
</table>
</form>
</body>
</html>