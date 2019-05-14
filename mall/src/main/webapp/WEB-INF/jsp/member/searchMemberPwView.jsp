<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>searchPassword</title>
</head>
<body>
	<div>
		<ol>
			<c:if test="${searchPw == null}">
				<h1>가입된 정보가 없거나 입력된 정보가 다릅니다.</h1>
				<li><a href="/member/selectSearchMemberPwPhone">전화번호로 비밀번호 찾기</a></li>
				<li><a href="/member/selectSearchMemberPwEmail">이메일로 비밀번호 찾기</a></li>
				<li><a href="${pageContext.request.contextPath}/member/login">회원가입</a></li>
			</c:if>	
			<c:if test="${searchPw != null}">
			<li>
				사용자 이름 :${searchPw.memberName}
			</li>
			<li>
				사용자 아이디 :${searchPw.memberId}
			</li>
			<li>
				사용자 비밀번호 :${searchPw.memberPw}
			</li>
			<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
			</c:if>	
		</ol>
	</div>
</body>
</html>