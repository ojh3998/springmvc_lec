<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=devive-width, initial-scale=1.0">
<link rel="stylesheet" href="${contextPath}/resources/css/list.css?dt=<%=System.currentTimeMillis()%>">                       <!--  css 불러오는 법 -->
<title>Single File Upload</title>
</head>
<body>

	<img src="${contextPath}/resources/images/logo_google.png" width="300px">

  <div class="form-wrap">
   <h1>File Upload</h1>
   <!-- 파일 업로드를 위한 <form> 태그는 method 속성과 enctype 속성이 정해져 있습니다. -->
   <form action="${contextPath}/single/upload.do" method="post" enctype="multipart/form-data">
    <input type="text" name="writer" placeholder="작성자"><br/>
    <input type="file" name="file" id="file" accept="image/*"><br/>                           <!--  accept="image/*" 를 이용해서 첨부파일을 이미지로 제한 -->
    <button type="submit">제출</button> 
   </form>
  </div>
  
  <hr>
  
  <div>
  	<h1>Upload File List</h1>
    <c:forEach items="${fileList}" var="f">
      <div class="file">
       <img src="${contextPath}${f.filePath}/${f.filesystemName}" width="100px">
       작성자 : ${f.writer} | 파일명 : ${f.originalFilename} | 저장명 : ${f.filePath}/${f.filesystemName}
      </div>
    </c:forEach>
  </div>
    
  
  <script> 	 
  
 	const msg = '${msg}';
 	if(msg !== '')
 		alert(msg);
 	
 	document.getElementById('file').addEventListener('change', (event) => {
 	const limit = 1024 * 1024 * 10;
 	const size = event.currentTarget.files[0].size;
 	if(size > limit) {
 		alert('첨부 파일의 크기는 최대 10MB 입니다.')
 	 }
 	})
 		
  </script>

</body>
</html>
     
     
     