<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 
<!-- jquery를 사용하기위한 CDN주소 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
<!-- bootstrap javascript소스를 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
<title>BOARD ADD(spring mvc + mybatis 방식)</title>
</head>
<body>
<div class="container">
    <h1>BOARD ADD(spring mvc + mybatis 방식)</h1>
    <form id="addForm" 
    		action="${pageContext.request.contextPath}/board/addBoard" 
    		method="post"
    		enctype="multipart/form-data">
        <div class="form-group">
            <label for="boardPw">boardPw :</label>
            <input class="form-control" name="boardPw" id="boardPw" type="password"/>
        </div>
        <div class="form-group">
            <label for="boardTitle">boardTitle :</label>
            <input class="form-control" name="boardTitle" id="boardTitle" type="text"/>
        </div>
        <div class="form-group">
            <label for="boardContent">boardContent :</label>
            <textarea class="form-control" name="boardContent" id="boardContent" rows="5" cols="50"></textarea>
        </div>
        <div class="form-group">
            <label for="boardName">boardName :</label>
            <input class="form-control" name="boardUser" id="boardUser" type="text"/>
        </div>
        <div class="form-group">
            <label for="boardFile">boardFile :</label>
            <input class="form-control" name="boardFile" id="boardFile" type="file"/>
        </div>
        <div>
            <input class="btn btn-default" id="addButton" type="submit" value="글입력"/>
            <input class="btn btn-default" type="reset" value="초기화"/>
            <a class="btn btn-default" href="${pageContext.request.contextPath}/board/getBoardList">글목록</a>
        </div>
    </form>
</div>
</body>
</html>
