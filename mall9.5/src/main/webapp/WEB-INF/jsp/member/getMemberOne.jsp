<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>getMemberOne</title>
</head>
<body>
	<h1>getMemberOne</h1>
	<h3>개인정보 페이지</h3>
	<ol>
		<li>사용자 아이디 : ${member.memberId}</li>
		<li>현재 사용자 비밀번호 : ${member.memberPw} 
			<a href="${pageContext.request.contextPath}/member/passwordUpdate">비밀번호 수정</a>
		</li>	
		<li>사용자 이름 : ${member.memberName}님</li>
		<li>사용자 전화번호 : ${member.memberPhone}</li>
		<li>사용자 주소 : ${member.memberAddress}</li>
		<li>사용자 성별 : ${member.memberGender}</li>
		<li>사용자 계급 : ${member.memberLevel}</li>
		<li>사용자 이메일 : ${member.memberEmail}</li>
	</ol>
	<a href="${pageContext.request.contextPath}/member/getUpdateMember">회원 정보 수정</a>
	<a href="${pageContext.request.contextPath}/member/removeMember">회원 탈퇴</a>
</body>
</html>