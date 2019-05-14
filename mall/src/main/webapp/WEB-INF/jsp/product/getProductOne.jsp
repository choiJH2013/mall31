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
	$(document).ready(function () {
		$('#paymentBtn').click(function () {
			$('#productForm').submit(); // 기능은 자바스크립트가 하는것
		});
	});
</script>
<title>상품상세보기</title>
</head>
<body>
	<div>
	    <h1>상품상세보기</h1>
	    <form id="productForm" method="post" action="${pageContext.request.contextPath}/product/getProductOne">
			<table border=1>
				<tr>
					<td>카테고리</td>
					<td>${categoryNo}</td>
				</tr>
				<tr>
					<td>상품이미지</td>
					<td><img src="${pageContext.request.contextPath}/upload/Penguins.jpg" ></td>
				</tr>
				<tr>
					<td>상품이름</td>
					<td>${productCommonName}</td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td>${productCommonPrice}</td>
				</tr>
				<tr>
					<td>종류</td>
					<td>${productCommonDescription}</td>
				</tr>	
				<tr>
					<td>날짜</td>
					<td>${productCommonDate}</td>
				</tr>	
			</table>
			<div>
			수량 :<select>
					<option>1개</option>
					<option>2개</option>
					<option>3개</option>
					<option>4개</option>
					<option>5개</option>
					<option>6개</option>
					<option>7개</option>	
					<option>8개</option>
					<option>9개</option>
					<option>10개</option>		
				</select>
			색깔 :<select>
					<option>white</option>
					<option>black</option>	
				</select>
			사이즈 :<select>
					<option>100</option>
					<option>200</option>	
				</select>
			</div>
			<button id="bakBtn" type="button">장바구니담기</button>
			<button id="paymentBtn" type="button">결제하기</button>
		</form>
	</div>
</body>
</html>