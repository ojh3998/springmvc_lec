<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=devive-width, initial-scale=1.0">
<title>My Page</title>
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



<script>
  function toRepw() {
    location.href = '${contextPath}/user/repw.form';
  }
  function deleteAccount() {
    if(confirm('모든 회원 정보가 삭제됩니다. 탈퇴하시겠습니까?')) {
      location.href = '${contextPath}/user/deleteAccount.do';
    }
  }
</script>

<body>
  <h1>My Page</h1>
  
  <h3 class="sub-title">개인정보변경</h3>
  <form action="${contextPath}/user/modifyInfo.do" method="post">
    <input type="hidden" name="userId" value="${u.userId}">
    <div>
      <label for="userEmail">이메일</label>
      <input type="text" name="userEmail" id="userEmail" value="${u.userEmail}">
    </div>
    <div>
      <label for="userName">성명</label>
      <input type="text" name="userName" id="userName" value="${u.userName}">
    </div>
    <div>
      <button type="submit">개인정보변경하기</button>
    </div>
  </form>
  
  <h3 class="sub-title">프로필이미지변경</h3>
  <form action="${contextPath}/user/modifyProfile.do" method="post" enctype="multipart/form-data">
    <input type="hidden" name="userId" value="${u.userId}">
    <div>
      <c:if test="${empty u.profileImg}"><img src="${contextPath}/assets/images/avatar.png" width="80px"></c:if>
      <c:if test="${not empty u.profileImg}"><img src="${contextPath}${u.profileImg}" width="80px"></c:if>  <%-- 이 경로를 해석하려면 servlet-context.xml 파일에 정적 파일의 경로 인식을 추가해 줘야 합니다. --%>
    </div>
    <div>
      <label for="profile">신규 프로필 선택</label>
      <input type="file" name="profile" id="profile">
    </div>
    <div>
      <button type="submit">프로필 변경하기</button>
    </div>
  </form>
  
  <h3 class="sub-title">비밀번호변경</h3>
  <div><button type="button" onclick="toRepw()">비밀번호변경페이지로이동하기</button></div>

  <h3 class="sub-title">회원탈퇴</h3>
  <div><button type="button" onclick="deleteAccount()">회원탈퇴하기</button></div>

</div>

</body>
</html>