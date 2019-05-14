<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LOGIN</h1>
	<h3>로그인 페이지</h3>
	<div>
		<ol>
			<c:if test='${loginMember == null}'>
				<form method="post" action="${pageContext.request.contextPath}/member/login">
					<div>
						<table class="bg-primary text-white">
							<tr>
								<td>아이디</td>
								<td><input type="text" name="memberId"></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" name="memberPw"></td>
							</tr>
							<tr>
								<td>
									<input type="submit" value="로그인">
								</td>
							</tr>
						</table>	
					</div>
				</form>
			</c:if>	
						
			<c:if test="${loginMember != null}">
				<li>사용자 : ${loginMember.memberName}님</li>
				<li><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/member/getMemberOne">개인정보확인</a></li>
			</c:if>	
		</ol>
	</div>
</body>
</html>