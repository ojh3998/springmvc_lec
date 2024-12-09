package com.min.app02.domain;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component // Spring Container에 Contact 라는 이름의 bean 이 만들어집니다.
@ToString
public class Contact {
  
  private String mobile = "010-2541-4155";
  private String email = "dbtk159@nate.com";
 
  

}
