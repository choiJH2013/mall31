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
		$('#searchBtn').click(function () {
			$('#searchForm').submit(); // 기능은 자바스크립트가 하는것
		});
	});
</script>
<title>category</title>
</head>
<body>
	<div>
	    <h1>상품 리스트</h1>
	    <form>
		    <table border="1">
		        <thead>
		            <tr>
		                <th>productCommonNo</th>
		                <th>categoryNo</th>
		                <th>productCommonName</th>
		                <th>productCommonPrice</th>
		                <th>productCommonDescription</th>
		                <th>productCommonDate</th>  
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach var="list" items="${list}">
		                <tr>   
		                    <td>${list.productCommonNo}</td>
		                    <td>${list.categoryNo}</td>
		                    <td>${list.productCommonName}</td>
		                    <td>${list.productCommonPrice}</td>
		                    <td>${list.productCommonDescription}</td>
		                    <td>${list.productCommonDate}</td>
		                    <!-- 클릭시 상세정보가 나와야하고 주문버튼 및 로그인된건지 확인 -->
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
	    </form>
	    											<!-- form안에 hidden으로 넘기는방법도있따 -->
	    <form id="searchForm" action="${pageContext.request.contextPath}/product/getProductListByCategory?categoryNo=${categoryNo}" method="get">
	    	productName 검색어 : <input type="text" name="searchWord">
	    	<button id="searchBtn" type="button">검색</button>
	    </form>
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    <ul>
	        <c:if test="${currentPage > 1}">
	            <li>
	            	<a href="${pageContext.request.contextPath}/product/getProductListByCategory?category=${list.categoryNo}&currentPage=${currentPage-1}">
	            	이전	            
	            	</a>
	            </li>
	        </c:if>
	        <c:if test="${currentPage < lastPage}">
	            <li>
	            	<a href="${pageContext.request.contextPath}/product/getProductListByCategory?category=${list.categoryNo}&currentPage=${currentPage+1}">
	            	다음
	            	</a>
	            </li>
	        </c:if>
	    </ul>
	</div>
</body>
</html>