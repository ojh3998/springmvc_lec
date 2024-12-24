<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=devive-width, initial-scale=1.0">
<title></title>

  <style>
  
    /* 전체 페이지 높이를 100%로 설정하고, flexbox로 세로 중앙 정렬 */
    body, html {
      margin: 0;
      padding: 0;
      height: 100%; /* 페이지 전체 높이를 100%로 설정 */
      display: flex;
      flex-direction: column; /* 세로로 배치 */
      justify-content: center; /* 세로 중앙 정렬 */
      align-items: center; /* 가로 중앙 정렬 */
      font-family: Arial, sans-serif;
    }

    /* 페이지 콘텐츠를 감싸는 div */
    .container {
      text-align: center;  /* 텍스트를 중앙 정렬 */
      padding: 20px;
      width: 100%;
      max-width: 600px;    /* 최대 너비 설정 */
      box-sizing: border-box;
    }

    /* 각 제목(섹션)을 위한 스타일 */
    h3.sub-title {
      margin-top: 20px;
      font-size: 1.5em;
      color: #333;
    }

    /* 폼을 감싸는 div 스타일 */
    form {
      margin-bottom: 20px;
    }

    /* 버튼 스타일 */
    button {
      padding: 10px 20px;
      font-size: 1em;
      background-color: #007BFF;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056b3;
    }

    /* 입력 필드 스타일 */
    input[type="text"], input[type="file"] {
      padding: 10px;
      width: 100%;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 5px;
      font-size: 1em;
    }
  .sub-title {
    margin-top: 50px;
  }
  .sub-title::before {
    content: '*';
  }
  </style>
</head>
<body>

  <h1>Password Change</h1>
  
  <form id="form-repw" action="${contextPath}/user/repw.do" method="post">
    <input type="hidden" name="userId" value="${sessionScope.loginUser.userId}">
    <input type="password" name="userPw" id="userPw" placeholder="신규 비밀번호"><br/>
    <input type="password" id="userPw2"  placeholder="비밀번호 확인"><br/>
    <button type="submit">비밀번호변경하기</button>
  </form>

  <script>
    function submitForm() {
      const formRepw = document.getElementById('form-repw');
      const userPw = document.getElementById('userPw');
      const userPw2 = document.getElementById('userPw2');
      formRepw.addEventListener('submit', (event) => {
        if(userPw.value !== userPw2.value) {
          alert('입력한 비밀번호를 확인하세요.');
          event.preventDefault();
          return;
        }
      })
    }
    submitForm();
  </script>

</div>

</body>
</html>