<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- external css  -->
<link type="text/css" rel="stylesheet" href="css/common.css" >

</head>
<body>
<h3>회원가입</h3>
<!--  메인 네비게이션  -->
<jsp:include page="inc/beforeMenu.jsp" />

<form action="memberInput" method="post">
<table>
		<!--  아이디 입력  -->
	<tr>
		<td>아이디</td>
		<td><input type="text" name="memberId" required="required" placeholder="6~30자"></td>
	</tr>
		<!--  비밀번호 입력  -->
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="memberPw" required="required" placeholder="6~30자"></td>
	</tr>	
		<!--  이름 입력  -->
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" required="required" ></td>
	</tr>	
		<!--  핸드폰 입력  -->
	<tr>
		<td>핸드폰</td>
		<td>	
			<input type="text" name="mobile1" value="010" readonly>
			<input type="number" name="mobile2" >
			<input type="number" name="mobile3" >
		</td>
	</tr>	
		<!--  이메일 입력  -->
	<tr>
		<td>이메일</td>
		<td>
				<input type="text" name="email_front" required="required">@
				<select name="email_end">
					<option value="@naver.com">naver.com</option>
					<option value="@daum.net">daum.net</option>
					<option value="@gmail.com">gmail.com</option>
				</select>
			</td>
	</tr>	

		<!--  회원가입정보 전송버튼  및 초기화 -->
	<tr>
		<th colspan="2"><input type="submit" value="가입하기">&nbsp;&nbsp;&nbsp;<input type="reset" value="초기화"></th>
	</tr>

</table>
</form>
</body>
</html>