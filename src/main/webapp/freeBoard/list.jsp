<%--
  Created by IntelliJ IDEA.
  User: lsm01
  Date: 25. 5. 4.
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/community/freeBoard/list.css" rel="stylesheet" type="text/css">
    <link href="/resources/static/css/headerGnb1.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <title>자유게시판 목록</title>
</head>
<body>
<%--고정 헤더 파일--%>
<%@include file="/resources/static/html/headerGnb.jsp"%>
<div class="wrap">
    <div class="aside">
        <div class="profile">
            <div class="myInfo">
                <p>회원등급  ??</p>
                <h2>환영합니다 OOO님!</h2>
            </div>
        </div>
        <div class="sideMenu">
            <h2 class="sideMenuTitle">커뮤니티</h2>
            <a href="/post/searchListPage" class="select">자유게시판</a>
            <a href="/edu/searchListPage">교육 정보 게시판</a>
            <a href="/info/searchListPage">대입 정보 게시판</a>
            <a href="/activity/searchListPage">대외활동 게시판</a>
            <a href="/lib/searchListPage">자료실 게시판</a>
            <a href="/news/searchListPage">뉴스 게시판</a>
        </div>
    </div>
    <div class="main">
        <div class="writeTit">
            <h2>자유 게시판</h2>
            <p>자유롭게 소통하는 공간입니다.</p>
            <div class="wtBtn">
                <a href="/edu/writePage">글쓰기</a>
            </div>
        </div>
        <form class="searchInput" method="GET" action="">
            <div class="searchBoxs">
                <select id="search_category" name="search_category" class="selectOption">
                    <option value="title">제목</option>
                    <option value="admin_id">작성자</option>
                </select>
                <input type="text" id="search_word" name="search_word" class="search_in" placeholder="검색어를 입력해주세요." value="${pageDTO.search_word}">
                <input type="submit" class="search_btn" name="serch_btn" value="검색">
            </div>
        </form>
        <div class="writeList">
            <table class="wlHeader">
                <tr>
                    <th class="listNo"><p >번호</p></th>
                    <th class="listTit"><p >제목</p></th>
                    <th class="listName"><p >작성자</p></th>
                    <th class="listDate"><p >작성일</p></th>
                    <th class="listCnt"><p >조회수</p></th>
                </tr>
            </table>
            <table class="wlBody">
                <tr>
                    <td><p class="listNo">번호</p></td>
                    <td><p class="listTit">제목</p></td>
                    <td><p class="listName">작성자</p></td>
                    <td><p class="listDate">작성일</p></td>
                    <td><p class="listCnt">조회수</p></td>
                </tr>
            </table>

            <div class="pagingBox">
                <p>123456</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
