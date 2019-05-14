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
			<!-- 입력정보가 다른경우 값이 없을때 -->
			<c:if test="${searchId == null}">
				<h1>가입된 정보가 없거나 입력된 정보가 다릅니다.</h1>
				<li><a href="/member/searchMemberId">아이디 찾기</a></li>
				<li><a href="${pageContext.request.contextPath}/member/login">회원가입</a></li>
			</c:if>	
			<!-- 입력정보가 같아서 값이 있을떄 -->
			<c:if test="${searchId != null}">
			<li>
				<h3>사용자 이름 :</h3>${searchId.memberName}
			</li>
			<li>
				<h3>사용자 아이디 :</h3>${searchId.memberId}
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/member/login">로그인</a>
			</li>
			</c:if>	
		</ol>
	</div>
</body>
</html>