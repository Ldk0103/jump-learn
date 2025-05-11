<%--
  Created by IntelliJ IDEA.
  User: DongGyu
  Date: 25. 5. 11.
  Time: 오후 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html lang="ko_KR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/static/css/changePw.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/aa252fc318.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.umd.min.js"></script>
    <title>JL - 비밀번호 변경</title>
</head>
<body>
<div class="wrap">
    <header>
        <img class="header_logo" src="/resources/static/images/registLogo2.svg" alt="메인로고">
        <i class="fa-solid fa-circle-chevron-down"></i>
        <p class="header_comment">완료!</p>
    </header>
    <main>
        <form id="fpw_form" class="fpw_form" action="" method="post">
            <div class="fpw_input_box">
                <p class="fpw_tit">아이디</p>
                <input type="text" name="memberId" id="username" class="fpw_input" value="기존아이디" readonly>
            </div>
            <div class="fpw_input_box">
                <p class="fpw_tit">변경 할 비밀번호</p>
                <input type="password" name="memberPwd" id="password" class="fpw_input" placeholder="8~16자 미만의 영문 소문자, 숫자, 특수문자 포함">
                <div id="passwordError" class="pwerror"></div>
            </div>
            <div class="fpw_input_box">
                <p class="fpw_tit">변경 할 비밀번호 확인</p>
                <input type="password" name="confirmPassword" id="confirmPassword" class="fpw_input" placeholder="8~16자 미만의 영문 소문자, 숫자, 특수문자 포함">
                <div id="confirmPasswordError" class="conerror"></div>
            </div>
            <div class="btm_line"></div>
            <input id="checkKey" class="fpw_btn" type="submit" name="fpw_btn" value="비밀번호 변경">
        </form>
    </main>
</div>
<script>
    document.getElementById('fpw_form').addEventListener('submit', function(event) {
        let valid = true;

        // 비밀번호 유효성 검사
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;
        const passwordError = document.getElementById('passwordError');
        const confirmPasswordError = document.getElementById('confirmPasswordError');
        passwordError.textContent = ''; // Clear previous error messages
        confirmPasswordError.textContent = '';

        const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,16}$/; // 영어+숫자+특수문자, 8~16자
        if (!passwordRegex.test(password)) {
            passwordError.textContent = '비밀번호는 8~16자 사이의 영어, 숫자, 특수문자만 사용할 수 있습니다.';
            valid = false;
        }

        // 비밀번호 확인
        if (password !== confirmPassword) {
            confirmPasswordError.textContent = '비밀번호가 일치하지 않습니다.';
            valid = false;
        }

        if (!valid) {
            event.preventDefault(); // Prevent form submission if validation fails
        }
    });
</script>
</body>
</html>
