package com.min.app02.pkg01_field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.app02.domain.Address;
import com.min.app02.domain.Contact;

import lombok.ToString;

/*
 * DI 방식 1 - 필드 주입
 * Spring Container 에 있는 bean 을 필드에 주입(전달) 하는 방식.
 * 필드 마다 @Autowired Annotation을 추가하면 됨.
 * */

@Component // Spring Container 에 person 이라는 이름의 bean 이 만들어 집니다.

@ToString // Person 타입의 bean을 sysout 으로 곧바로 확인할 수 있다.
public class Person {

  //field
  
  @Autowired // Spring Container 에서 타입이 Address 인 bean을 가져옴,
  private Address address;
  
  
  @Autowired // Spring Container 에서 타입이  Contact 인 bean을 가져옴,
  private Contact contact;
  
}
