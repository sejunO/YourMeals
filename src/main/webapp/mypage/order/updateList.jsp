<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <title>MyPage</title>
</head>

<body>
    <h1>[나의 주문 취소/교환/환불내역]</h1>
    <table border='1'>
        <tr>
            <th>주문일자</th>
            <th>주문번호</th>
            <th>우편번호</th>
            <th>배송지주소</th>
            <th>주문항목</th>
            <th>주문금액</th>
            <th>상태</th>
        </tr>
        <c:forEach items="${list}" var="o">
            <tr>
                <td>${o.orderDate}</td>
                <td>${o.orderNo}</td>
                <td>${o.postNo}</td>
                <td>${o.address} ${o.detailAddress}</td>
                <td>${o.orderLists.get(0).orderProduct.content}
                    <c:if test="${o.orderLists.size() -1 > 0}">외 ${o.orderLists.size() -1} 건</c:if>
                </td>
                <td>${o.totalPrice}</td>
                <td>
                    <c:choose>
                        <c:when test="${o.status == 11}">
                            취소신청
                        </c:when>
                        <c:when test="${o.status == 12}">
                            취소진행중
                        </c:when>
                        <c:when test="${o.status == 13}">
                            취소(환불)완료
                        </c:when>
                        <c:when test="${o.status == 21}">
                            반품신청
                        </c:when>
                        <c:when test="${o.status == 22}">
                            반품진행중
                        </c:when>
                        <c:when test="${o.status == 23}">
                            반품(환불)완료
                        </c:when>
                        <c:when test="${o.status == 31}">
                            교환신청
                        </c:when>
                        <c:when test="${o.status == 32}">
                            교환진행중
                        </c:when>
                        <c:when test="${o.status == 33}">
                            교환완료
                        </c:when>

                        <c:otherwise>
                            상태값오류
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href=../index.html>뒤로가기</a><br>

    <a href=../../index.html>홈으로</a><br>