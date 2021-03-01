<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.project.model.dto.LectureList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- external css  -->
<link type="text/css" rel="stylesheet" href="css/common.css" >
</head>
<body>
<h3>강의듣기 페이지</h3>
<!--  메인 네비게이션  -->
<jsp:include page="inc/afterMenu.jsp" />

<%
	ArrayList<LectureList> list = (ArrayList<LectureList>)request.getAttribute("list");
	LectureList dto = list.get(0);
%>
<div>

<p align="middle">
	<iframe width="560" height="315" src="<%= dto.getLectureVideo()%>"></iframe>
</p>
<h3>강의 이름 :  <%= dto.getLectureName()%></h3>
<h3>강사님 :<%= dto.getLectureTeacher()%> </h3>
</div>
</body>
</html>