<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>searchPassword</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/member/searchMemberPw">
		<div>
			<table class="bg-primary text-white">
				<tr>
					<td>사용자 이름</td>
					<td><input type="text" name="memberName"></td>
				</tr>
				<tr>
					<td>사용자 아이디</td>
					<td><input type="text" name="memberId"></td>
				</tr>
				<tr>
					<td>사용자 휴대전화</td>
					<td><input type="text" name="memberPhone"></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="비밀번호 찾기">
					</td>
				</tr>
			</table>	
		</div>
	</form>
</body>
</html>