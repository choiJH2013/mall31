<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>INDEX</h1>
	<h3>쇼핑몰 메인 페이지(github에서 수정...)</h3>
	<div>
		<ol>
			<li><a href="/member/login">로그인</a></li>
			
			<c:if test="${loginMember == null}">
				<li><a href="${pageContext.request.contextPath}/member/addMember">회원가입</a></li>
				<li><a href="${pageContext.request.contextPath}/member/searchMemberId">아이디 찾기</a></li>
				<li><a href="${pageContext.request.contextPath}/member/selectSearchMemberPwPhone">DB에 저장된 전화번호로 비밀번호 찾기</a></li>
				<li><a href="${pageContext.request.contextPath}/member/selectSearchMemberPwEmail">DB에 저장된 이메일로 비밀번호 찾기</a></li>
				<li><a href="${pageContext.request.contextPath}/member/searchEmailMemberPw">이메일로 메일을 발송하여 비밀번호 찾기</a></li>
			</c:if>	
		</ol>
	</div>
	
	<div>
		<!-- 쇼핑몰 메뉴 -->
	</div>
	<div>
		<ul>
			<c:forEach var="category" items="${categoryList}">
				<li>
					<a href="${pageContext.request.contextPath}/product/getProductListByCategory?categoryNo=${category.categoryNo}&currentPage=1">${category.categoryName}</a>
				</li>
			</c:forEach>
		</ul>
	
	</div>
	
	
</body>
</html>
