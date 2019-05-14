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
    <h1>회원정보 수정 페이지</h1>
    <form id="addForm" 
    		action="${pageContext.request.contextPath}/member/getUpdateMember" 
    		method="post">
        <div class="form-group">
            <label for="memberId">아이디 :</label>
            <input class="form-control" name="memberId" id="memberId" type="text" value="${member.memberId}" readonly="readonly" />
        </div>
        <div class="form-group">
            <label for="memberName">이름 :</label>
            <input class="form-control" name="memberName" id="memberName" type="text" value="${member.memberName}"/>
        </div>
        <div class="form-group">
            <label for="memberPhone">전화번호 :</label>
            <input class="form-control" name="memberPhone" id="memberPhone" type="text" value="${member.memberPhone}"/>
        </div>
        <div class="form-group">
            <label for="memberAddress">주소 :</label>
            <input class="form-control" name="memberAddress" id="memberAddress" type="text" value="${member.memberAddress}"/>
        </div>
        <div class="form-group">
	        <label for="memberEmail">이메일 :</label>
	        <input class="form-control" name="memberEmail" id="memberEmail" type="text" value="${member.memberEmail}"/>
        </div>
        <div class="form-group">
            <label for="memberPw"></label>
            <input class="form-control" name="memberPw" id="memberPw" type="hidden" value="${member.memberPw}"/>
        </div>
        <div class="form-group text-center">
            <input type="submit" value="회원 정보 수정">
        </div>
    </form>
</div>
</body>
</html>