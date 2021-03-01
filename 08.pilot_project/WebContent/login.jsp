<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- external css  -->
<link type="text/css" rel="stylesheet" href="css/common.css" >
</head>
<body>
<h3> 로그인 </h3>
<!--  메인 네비게이션  -->
<jsp:include page="inc/beforeMenu.jsp" />
	<!--  로그인 폼  -->
<form action="login" method="post">
	<table>
	<!--  아이디  -->
	<tr>
		<td>아이디</td>
		<td><input type="text" name="memberId" autofocus="autofocus" required="required"></td>
	</tr>
	<!--  비밀번호  -->
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="memberPw" autofocus="autofocus" required="required"></td>
	</tr>
	<!--  로그인 전송 버튼  -->
	<tr>
		<th colspan="2"><input type="submit" value="로그인"></th>
	</tr>
	</table>
</form>
</body>
</html>