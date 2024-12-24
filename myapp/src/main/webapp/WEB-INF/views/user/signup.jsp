<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>  
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 가입</title>
  <style>
    /* 전체 페이지를 flexbox로 설정하여 세로, 가로 중앙 정렬 */
    body, html {
      margin: 0;
      padding: 0;
      height: 100%; /* 페이지 높이를 100%로 설정 */
      display: flex;
      justify-content: center;  /* 가로 중앙 정렬 */
      align-items: center;      /* 세로 중앙 정렬 */
      font-family: Arial, sans-serif;
      background-color: #f4f4f9; /* 배경색 */
    }

    /* 회원가입 폼을 감싸는 div */
    .container {
      text-align: center;
      background-color: white; /* 폼 배경색 */
      padding: 30px;
      border-radius: 8px; /* 둥근 모서리 */
      box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
      width: 100%;
      max-width: 400px; /* 최대 너비 설정 */
      box-sizing: border-box;
    }

    /* 폼 제목 */
    h1 {
      font-size: 2em;
      margin-bottom: 20px;
      color: #333;
    }

    /* 입력 필드 스타일 */
    input[type="text"], input[type="password"] {
      padding: 12px;
      width: 100%;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 5px;
      font-size: 1em;
    }

    /* 버튼 스타일 */
    button {
      padding: 12px 20px;
      font-size: 1.1em;
      background-color: #007BFF;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      width: 100%; /* 버튼을 전체 너비로 설정 */
    }

    button:hover {
      background-color: #0056b3;
    }

    /* 입력 필드에 포커스 시 스타일 */
    input:focus {
      border-color: #007BFF;
      outline: none;
    }
  </style>
</head>

<body>
  <div class="container">
    <h1>회원 가입</h1>

    <form action="${contextPath}/user/signup.do" method="post">
      <input type="text" name="userEmail" placeholder="이메일" required><br/>
      <input type="password" name="userPw" placeholder="비밀번호" required><br/>
      <input type="text" name="userName" placeholder="성명" required><br/>
      <button type="submit">가입</button>
    </form>
  </div>
</body>
