<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청사이트 메인페이지</title>
<!-- external css  -->
<link type="text/css" rel="stylesheet" href="css/common.css" >
</head>
<body>
<h3>메인페이지</h3>

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

<!-- <table border="1">
<th>이미지</th><th>강의 목록</th><th>강의이름</th><th>강사</th><th>가격</th>

<tr>
<td>000</td>
<td>123</td>
<td>456</td>
<td>1234</td>
<td>5555</td>
<td onclick="location.href='mainService(no).jsp'" style="cursor:pointer;">상세정보</td>
<td>수강신청</td>

</tr>

</table> -->

</body>
</html>