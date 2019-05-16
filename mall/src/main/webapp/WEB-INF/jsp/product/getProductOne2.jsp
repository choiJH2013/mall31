<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	/* $ == jquery  document.getElementById('test') jQuery('#test') */
	/* load 는 도큐먼트가 다만들어져야된다   ready태그만 읽혀지면된다- */

	/* 제이쿼리 3.0 이전 버전에서는, ready 메서드를 호출할 수 있는 몇 가지 방법이 있다.

	document 엘리먼트로 호출 : $(document).ready(handler);
	빈 엘리먼트로 호출 : $().ready(handler);
	또는 특정 엘리먼트 없이 바로 호출 : $(handler); */
	
	$(document).ready(function () {
	
		$('#productColor').change(function () {
			$('#selectOptionColorFrom').submit();
			
		$('#productSize').change(function () {
			$('#selectOptionSizeFrom').submit();  // 기능은 자바스크립트가 하는것
		});
	});
</script>

<title>상품상세보기</title>
</head>
<body>
	<c:if test="${pc.productCommonNo != null}">
		<div>
		    <h1>상품상세보기</h1>
		    <form id="productForm" method="post" action="${pageContext.request.contextPath}/">
				<table border=1>
					<thead>	
						<tr>
							<td width="50%">카테고리번호</td>
							<td>${pc.categoryNo}</td>
						</tr>
						<tr>
							<td>상품이미지</td>
							<td><img src="${pageContext.request.contextPath}/hari.jpg"></td>
						</tr>
						<tr>
							<td>상품이름</td>
							<td>${pc.productCommonName}</td>
						</tr>
						<tr>
							<td>상품가격</td>
							<td>${pc.productCommonPrice}</td>
						</tr>
						<tr>
							<td>종류</td>
							<td>${pc.productCommonDescription}</td>
						</tr>	
						<tr>
							<td>날짜</td>
							<td>${pc.productCommonDate}</td>
						</tr>
					</thead>	
				</table>
			</form>	
			
	<c:if test="${pCO.productColor == null}">
		선택된 컬러 : <input type="text" value="선택된 컬러가 없습니다." readonly="readonly">
	</c:if>
	<c:if test="${pSO.productSize == null}">
		선택된 사이즈 : <input type="text" value="선택된 사이즈가 없습니다." readonly="readonly">
	</c:if>		
			
	<c:if test="${pCO.productColor != null}">
	선택된 컬러<input type="text" value="${pO.productColor}" readonly="readonly">
	</c:if>
	<c:if test="${pSO.productSize != null}">
	선택된 사이즈<input type="text" value="${pO.productSize}" readonly="readonly">
	</c:if>

	<!-- 컬러표시 및 선택옵션  -->
	<form id="selectOptionColorFrom" action="${pageContext.request.contextPath}/product/getProductOne?productCommonNo=${pc.productCommonNo}" method="post">	
		
		<!-- select tag -->컬러선택:	
		<select id="productColor" name="productColor">
			<option value="" selected>==선택==</option>
			
			<!-- String color = "default" -->
			<c:set var="color" value="default"></c:set>
			
			<!-- forEach문  -->
			<c:forEach var="p" items="${products}">
			
				<!-- 조건 가져온 컬러중 컬러변수에 담긴값과 다를경우 -->
				<c:if test="${p.productColor ne color}">
				
					<!-- 그 컬러값으로 옵션을 추가한다 -->
					<option value="${p.productColor}">${p.productColor}</option>

					<%-- String color = 추가한 컬러값을담는다 for문 반복 다음if문에서 비교  --%>
					<c:set var="color" value="${p.productColor}"></c:set>
				
				</c:if>
				
			</c:forEach>
		</select>
		
	</form>
	
	<c:if test="pCO != null">
		
		<!-- 사이즈표시 및 선택옵션 폼  -->
		<form id="selectOptionSizeFrom" action="${pageContext.request.contextPath}/product/getProductOne?productCommonNo=${pc.productCommonNo}" method="post">	
			<!-- 상품사이즈 -->사이즈선택:
			<select id="productSize" name="productSize">
				<option value="" selected>==선택==</option>
				
				<!-- String color = "default" -->
				<c:set var="size" value="0"></c:set>
				
				<!-- forEach문  -->
				<c:forEach var="p" items="${products}">
				
					<!-- 조건 가져온 컬러중 컬러변수에 담긴값과 다를경우 -->
					<c:if test="${p.productSize ne size}">
					
						<!-- 그 컬러값으로 옵션을 추가한다 -->
						<option value="${p.productSize}">${p.productSize}</option>
						
						<%-- String color = 추가한 컬러값을담는다 for문 반복 다음if문에서 비교  --%>
						<c:set var="size" value="${p.productSize}"></c:set>
					
					</c:if>
					
				</c:forEach>
			</select>
	
		</form>

	</c:if>
	

		
		
		<br><br>
		<!-- 그냥표시 -->현재 재고량	
			<table border="1">		
				<tr>
					<td width="10%">컬러</td>
					<td>사이즈</td>
					<td>현재수량</td>
				</tr>
				<c:forEach var="p" items="${products}">
					<tr>	
						<td>${p.productColor}</td>
						<td>${p.productSize}</td>
						<td>${p.productStock}</td>
					</tr>
				</c:forEach>
			</table>	
			<div>
			사이즈 :<select>
					<option value="100">100</option>
					<option value="200">200</option>	
				</select>
			수량 :<select>
					<option value="1">1개</option>
					<option value="2">2개</option>
					<option value="3">3개</option>
					<option value="4">4개</option>
					<option value="5">5개</option>
					<option value="6">6개</option>
					<option value="7">7개</option>	
					<option value="8">8개</option>
					<option value="9">9개</option>
					<option value="10">10개</option>		
				</select>	
			</div>
			<button id="bakBtn" type="button">장바구니담기</button>
			<button id="paymentBtn" type="button">결제하기</button>
		</div>
	</c:if>
	
	
	<c:if test="${pc.productCommonNo == null}">
		<h1>현재 상품 준비중 입니다</h1>
	</c:if>
	
</body>
</html>