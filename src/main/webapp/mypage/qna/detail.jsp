<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head><title>MyPage</title></head>
<body>
<h1>[QnA 게시글 조회]</h1>
<form action='update' method='post'>
번호: <input type='text' name='no' value="${qna.qnaNo}" readonly><br>
제목: <input type='text' name='title' value="${qna.title}"><br>
내용: <textarea name='content'>${qna.content}</textarea><br>
등록일: ${qna.createdDate}<br>
<p>
<button>변경</button>
<a href='delete?no=${qna.qnaNo}'>삭제</a>
</p>
</form>
</body>
</html>
