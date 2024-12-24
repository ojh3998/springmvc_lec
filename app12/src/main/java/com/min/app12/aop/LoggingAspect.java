package com.min.app12.aop;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LoggingAspect {


//이름이 Controller로 끝나는 모든 클래스의 모든 메소드를 포인트컷으로 등록합니다.
 @Pointcut("execution (* com.min.app12.controller.*Controller.*(..))")
 public void preparePointCut() {
 
 }
 @Before(value="preparePointCut()") // 메소드 동작 이전에 자동으로 동작해라
 public void logging(JoinPoint joinPoint) {
  // log.debug("Before Advice 동작");
  
  // HttpServletRequest를 이용해서 요청 메소드 / 요청 주소 / 요청 파라미터 확인해보기
  
  HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
  
  String requestMethod = request.getMethod(); // 요청 메소드
  String requestURI = request.getRequestURI();// 요청 주소
  Map<String, String[]> params = request.getParameterMap(); // 모든 요청 파라미터를 Map으로 반환
  String str = "{";
  if(!params.isEmpty()) {
    for(Entry<String, String[]> entry : params.entrySet()) // Map을 for문 돌리기
     str += entry.getKey() + ":" + Arrays.toString(entry.getValue()) + ", "; 
  }
  str = str.substring(0, Math.max(1, str.length() -2)) + "}";
  
  
  log.debug("Method : {}, URI : {}, Parameters : {}", requestMethod, requestURI, str);
  
 }
 
}
   
   


   