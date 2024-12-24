package com.min.myapp.intercept;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/*
 * 인터셉터
 * 
 * 1. Controller 로 이동하는 요청을 가로챕니다.
 * 2. Controller 로 이동하는 요청을 그대로 유지하거나 취소 할 수 있습니다.
 * 3. 생성방법
 *  1) HandlerInterceptor 인터페이스를 구현합니다. (추천)
 *  2) HandlerInterceptorAdaptor 클래스를 상속합니다.
 * 4. 구현 할 수 있는 추상 메소드
 *  1) preHandle(); 요청 이전에 동작할 코드를 작성한다. 이 메소드를 이용해서 요청을 취소할 수 있습니다.
 *  2) postHandle(); 요청 이후에 동작할 코드를 작성한다.
 *  3) afterCompletion(); View 처리가 끝난 이후에 동작할 코드를 작성한다. 
 *  
 */

/*
 * 인터셉터의 동작 순서
 * 
 * View 에서 요청  ->  Filter  ->  DispatcherServlet  ->  Interceptor  -> Controller  -> Service  -> DAO(repository)
 *                    (web.xml)   (servlet-context.xml)   
 *                                 언제 어떤 인터셉터가  * 어떤 일을
 *                                 동작하는가?             수행하는가?
 */

public class LoginConfirmInterceptor implements HandlerInterceptor {
  
  /**
   * 요청을 처리하는 HttpServletRequest 와
   * 응답을 처리하는 HttpServletResponse를 사용
   * @return 요청을 그대로 진행하는 경우 true, 요청을 취소하는 경우 false 를 반환 (boolean 타입)
   */
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    
    // 세션에 loginUser 값이 없으면 로그인 화면으로 이동하는 기능을 구현하기
    
    HttpSession session = request.getSession();
    if(session.getAttribute("loginUser") == null) {
      
      // HTML 태그로 응답을 만들거야
      response.setContentType("text/html; charset=UTF-8");
      
      // 응답을 위한 문자출력 스트림(Writer)이 필요해~~
      PrintWriter out = response.getWriter();
      out.println("<script>");
      out.println("if(confirm('로그인이 필요한 기능입니다. 로그인 하시겠습니까?')) {");
      out.println("location.href = '" + request.getContextPath() + "/user/login.form?url=" + request.getRequestURL() + "'");
      out.println("} else {");
      out.println("history.back()"); //이전페이지로이동
      out.println("}");
      out.println("</script>");
      out.close();
      
      // 기존 요청을 처리하지 않습니다.
      return false;
      
    } // if()
    
    // 기존 요청을 그대로 처리합니다.
    return true;
    
  } // preHandle()
  

}
