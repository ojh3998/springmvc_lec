package com.min.app03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// "/standard로 시작하는 모든 요청 주소는 이 컨트롤러가 처리한다.
@RequestMapping(value = "/standard")

@Controller
public class MvcController2 {
  
  @RequestMapping(value = "/update")
  public String method1( ) {
    return "webdir1/update";
  }

}
