package com.min.app01.pkg01_constructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 나는 bean 을 만드는 클래스입니다.
public class AppConfig {
  
  /* 메소드 == bean */
  /*
   * 반환타입 : bean 의 타입. = <bean class="">
   * 메소드명 : bean 의 이름. = <bean id="">
   * 
   */
  
  @Bean // 나는 bean을 만드는 메소드입니다.
  Contact contact() {
    Contact contact = new Contact();
    contact.setMobile("010-2550-3998");
    contact.setEmail("ojh3998@naver.com");
    return contact;
  }
  
  @Bean(name = "person")
  Person akdfj() {
  Person person = new Person();
  person.setName("김성율");
  person.setContact(contact());
  return person;
  }
  
}
