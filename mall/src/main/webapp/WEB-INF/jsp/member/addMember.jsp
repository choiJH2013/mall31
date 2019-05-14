<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <h1>회원가입 페이지</h1>
    <form id="addForm" 
    		action="${pageContext.request.contextPath}/member/addMember" 
    		method="post">
    		
        <div class="form-group">
            <label for="memberId">아이디 :</label>
            <input class="form-control" name="memberId" id="memberId" type="text"/>
        </div>
        <div class="form-group">
            <label for="memberPw">비밀번호 :</label>
            <input class="form-control" name="memberPw" id="memberPw" type="password"/>
        </div>
        <div class="form-group">
            <label for="memberName">이름 :</label>
            <input class="form-control" name="memberName" id="memberName" type="text"/>
        </div>
        <div class="form-group">
            <label for="memberPhone">전화번호 :</label>
            <input class="form-control" name="memberPhone" id="memberPhone" type="text"/>
        </div>
        <div class="form-group">
            <label for="memberAddress">주소 :</label>
            <input class="form-control" name="memberAddress" id="memberAddress" type="text"/>
        </div>
        <div class="form-group">
        	<label for="memberEmail">이메일 :</label>
        	<input class="form-control" name="memberEmail" id="memberEmail" type="text"/>
        </div>
        <div class="form-group">
            <label for="memberGender">성별 :</label><br>
		남자	<input name="memberGender" id="memberGender" type="radio" value="남" />
		여자	<input name="memberGender" id="memberGender" type="radio" value="여" />
        </div>
        <div class="form-group">
            <label for="memberLevel">계급은 hidden이며 employee입니다.</label>
            <input class="form-control" name="memberLevel" id="memberLevel" type="hidden" value="employee" readonly="readonly"/>
        </div>
        <div class="form-group text-center">
            <input type="submit" value="회원가입">
        </div>
    </form>
</div>
</body>
</html>