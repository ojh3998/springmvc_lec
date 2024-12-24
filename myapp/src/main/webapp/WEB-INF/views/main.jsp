<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>

<jsp:include page="./layout/header.jsp">
  <jsp:param value="title" name="Welcome"/>
</jsp:include>


  <img src="${contextPath}/assets/images/architecture1.jpg">

  
   
</body>
</html>