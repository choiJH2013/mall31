<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>remove title here</title>
</head>
<body>
	<h3>회원탈퇴 페이지</h3>
	<div>
		<form method="post" action="${pageContext.request.contextPath}/member/removeMember">
			<div>
				<table class="bg-primary text-white">
					<tr>
						<td>탈퇴 아이디</td>
						<td><input type="text" name="memberId" value="${member.memberId}" readonly="readonly" ></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="memberPw"></td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="회원탈퇴">
						</td>
					</tr>
				</table>	
			</div>
		</form>
	</div>
</body>
</html>