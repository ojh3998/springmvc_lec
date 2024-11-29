package com.min.app03.controller;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.app03.vo.PageVo;

@Controller
public class MvcController3 {

  @RequestMapping(value="/webdir3/main")
  public String main() {
    return "webdir3/main";
  }
  
  @RequestMapping(value="/webdir3/req1")
  public String req1() {
    return "webdir3/req1";
  }
  
  
  /*
   * Query String
   * Query String 이란 URL 의 ? 뒤에 추가된 파라미터를 의미합니다.
   */
  
  
  /*
   * Query String 처리하기 1
   * HttpServletRequest 활용하기
   * 모든 요청에 관한 정보는 HttpServletRequest 인터페이스가 담당합니다.
   * Query String 은 Parameter 형태로 HttpServletRequest 인터페이스 객체에 저장되어 있습니다.
   * getParameter() 또는 getParameterValues() 메소드를 이용해 Parameter 를 확인할 수 있습니다.
   * getParameter() 메소드는 String 을 반환하고, getParameterValues() 메소드는 String[] 을 반환합니다.
   */
  
  @RequestMapping(value="/webdir3/req2")
  public String req2(HttpServletRequest request) {
    String sort = request.getParameter("sort");
    int page = Integer.parseInt(request.getParameter("page"));
    System.out.println(sort + ", " + page);
    return "webdir3/req2";
  }

  
  @RequestMapping(value="/webdir3/req3")
  public String req3(HttpServletRequest request) {
    String[] flowers = request.getParameterValues("flowers");
    System.out.println(Arrays.toString(flowers));
    return "webdir/req3";
  }
  
  
  // Query String 없음
  @RequestMapping(value="/webdir3/req4")
  public String req4(HttpServletRequest request) {
    
    
    String sort = request.getParameter("sort");
    
    
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
    
    
    int page = Integer.parseInt(opt.orElse("1"));
    
    System.out.println(sort + ", " + page);
    
    return "webdir3/req4";
  
  }
  
  /*
   *  Query String 처리하기 2
   *  @RequestParam Annotation 활용하기
   *  각 파라미터 마다 @RequestParam Annotation 추가하여 파라미터를 직접 변수로 받을 수 있음.
   *  파라미터의 필수 여부 와 디폴트 값 설정을 할 수 있 음.
   *  @RequestParam Annotation은 생략이 가능. 생략 하면 선언된 변수로 추론하여 값을 받음.
   *  
   */
  
  // Query String : sort=ASC
  @RequestMapping(value="webdir3/req5")
      public String req5(
          @RequestParam(value="sort") String sort    // Parameter sort 가 전달 되지 않으면 잘못된 요청(400) 예외가 발생한다.
        , @RequestParam(value="page", required=false, defaultValue="1")  int page ) //  Parameter page가 전달 되지 않으면 기본값으로 "1" 을 사용
  {
    System.out.println(sort);
    return "webdir3.req5";
  }
  
  /*
   * Query String 처리하기 3
   * 커맨드 객체 활용하기
   * Parameter 를 필드로 가지고 있는 클래스 타입의 객체 (커맨드 객체)를 이용해서 Parameter 를 받을 수 있음.
   * 커맨드 객체에는 Setter가 정의되어 있어야 합니다.
   */
  
  // Query String : sort=ASC&page=1
  @RequestMapping(value="/webdir3/req6")
  public String req6(PageVo pageVo) {
    System.out.println(pageVo.getSort() + ", " + pageVo.getPage());
    return "webdir3/req6";
    
  }
  
  

  

  
  
  
  
  
  
  
  
  
  
  
}