package com.min.app13.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {

  @RequestMapping(value={"/", "/main.do"})
  public String main() {
    return "main"; // main.jsp 열어주기
  }
  
}