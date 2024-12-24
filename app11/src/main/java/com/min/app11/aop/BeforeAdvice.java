package com.min.app11.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect  // Aspect 선언입니다. 나는 AOP 방식으로 동작합니다.
public class BeforeAdvice {

  /**
   * PointCut 등록 메소드 작성 방법
   * 1. 반환타입 : void
   * 2. 메소드명 : 마음대로 작성
   * 3. 매개변수 : 없음
   * 4. 본문     : 없음
   */
  
  // 이름이 Controller로 끝나는 모든 클래스의 모든 메소드를 포인트컷으로 등록합니다.
  @Pointcut("execution (* com.min.app11.controller.*Controller.*(..))")
  public void preparePointCut() {
    
  }
  
  /**
   * Before Advice 작성 방법 (After Advice 작성 방법도 동일합니다.)
   * 1. 반환타입 : void
   * 2. 메소드명 : 마음대로 작성
   * 3. 매개변수 : JoinPoint joinPoint 
   * @param joinPoint 
   */
  @Before(value="preparePointCut()")
  public void beforeAdvice(JoinPoint joinPoint) {
    
    // Advice 작성 : 동작할 코드를 작성하는 곳입니다.
    System.out.println("Before Advice가 동작합니다.");
    
  }
  
}