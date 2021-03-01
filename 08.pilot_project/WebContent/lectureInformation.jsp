<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.project.model.dto.LectureList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 상세정보</title>
<!-- external css  -->
<link type="text/css" rel="stylesheet" href="css/common.css" >
</head>
<body>
<h3>강의 상세정보 페이지</h3>
<!--  메인 네비게이션  -->
<%
	if(session.getAttribute("memberId") == null){
%>
	<jsp:include page="inc/beforeMenu.jsp" />
<%
	}else{
%>
	<jsp:include page="inc/afterMenu.jsp" />
<%
	}
%>

<% 
ArrayList<LectureList> list = (ArrayList<LectureList>)request.getAttribute("list");
for(int index = 0; index < list.size(); index++){
	LectureList dto = list.get(index);
	int lecturePrice = dto.getLecturePrice();
	DecimalFormat commas = new DecimalFormat("#,###"); 
	String lectureprice = (String)commas.format(lecturePrice);
%>
<div>
<h3> 강의 이름 : <%= dto.getLectureName() %></h3>
</div>
<div>
<h3>강사님 이름 : <%= dto.getLectureTeacher() %></h3>
</div>
<div>
<h3> 강의 설명 : <%= dto.getLectureInfo() %></h3>
</div><div>
<h3>강의 등록일 : <%= dto.getLectureRegDate() %></h3>
</div><div>
<h3>강의 가격 : <%= lectureprice %> 원</h3>
</div>

<%
	}
%>

</body>
</html>