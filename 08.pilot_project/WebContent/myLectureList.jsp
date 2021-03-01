<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.project.model.dto.LectureList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내수강목록</title>
<!-- external css  -->
<link type="text/css" rel="stylesheet" href="css/common.css" >
</head>
<body>
<h3>내 수강목록</h3>
<!--  메인 네비게이션  -->
<jsp:include page="inc/afterMenu.jsp" />

<!--  contents  -->
<table border="1">

<th>이미지</th><th>강의번호</th><th>강의이름</th><th>강사이름</th><th>등록일</th>
<% 
ArrayList<LectureList> list = (ArrayList<LectureList>)request.getAttribute("list");
for(int index = 0; index < list.size(); index++){
	LectureList dto = list.get(index);
%>
	<tr>
	<td>이미지들어갈예정</td>
	<td><%= dto.getLectureNo()%></td>
	<td><%= dto.getLectureName()%></td>
	<td><%= dto.getLectureTeacher()%></td>
	<td><%= dto.getLectureSignDate() %></td>
	<td><a href="listenLecture?lectureNo=<%= dto.getLectureNo()%>">강의듣기</a></td>
	</tr>

<%
	}
%>
</table>

	

</table>
</body>
</html>