<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


 <a href='../../notice/noticeAdd.html'>새글</a><br>
 <table border=1>
 <c:forEach items="${list}" var="n">
 <tr>
        <td>공지사항 번호 : ${n.noticeNo}</td>
        <td>공지사항 타입 번호 :${n.noticeTypeNo}</td>
        <td>제목 : ${n.title}</td>
        <td>내용 : ${n.content} </td>
        <td>등록일 : ${n.registeredDate}</td>
          </tr>
       </c:forEach>
      </table> 
</body>
</html>