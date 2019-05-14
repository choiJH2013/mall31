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
			<li>
				발송된 이메일 :${member.memberId}
			</li>
			<li>
				발송된 임시 비밀번호 :${member.memberPw}
			</li>
			<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
		</ol>
	</div>
</body>
</html>