<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Password Update</title>
</head>
<body>
	<h3>비밀번호 수정 페이지</h3>
		<form method="post" action="${pageContext.request.contextPath}/member/passwordUpdate">
			<div>
				<table class="bg-primary text-white">
					<tr>
						<td><input type="hidden" name="memberId" readonly="readonly" value="${member.memberId}"></td>
					</tr>
					<tr>
						<td>현재 비밀번호</td>
						<td><input type="password" name="memberPw"></td>
					</tr>
					<tr>
						<td>변경 비밀번호</td>
						<td><input type="password" name="memberUpdatePw"></td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="비밀번호 변경">
						</td>
					</tr>
				</table>	
			</div>
		</form>
</body>
</html>