<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류화면</title>
<!-- external css  -->
<link type="text/css" rel="stylesheet" href="css/common.css" >
</head>
<body>
<h3>오류화면</h3>
<!--  메인 네비게이션  -->
<jsp:include page="inc/beforeMenu.jsp" />
<h3> ${message} </h3>  
</body>
</html>