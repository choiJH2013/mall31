<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>searchPassword</title>
</head>
<body>
<h1>이메일로 임시비밀번호 전송</h1>
	<form method="post" action="${pageContext.request.contextPath}/member/searchEmailMemberPw">
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
					<td>사용자 이메일</td>
					<td><input type="text" name="memberEmail"></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="이메일전송 찾기">
					</td>
				</tr>
			</table>	
		</div>
	</form>
</body>
</html>