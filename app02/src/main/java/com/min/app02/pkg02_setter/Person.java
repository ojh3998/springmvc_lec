package com.min.app02.pkg02_setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.app02.domain.Address;
import com.min.app02.domain.Contact;

import lombok.ToString;

/*
 * DI 방식 2 - Setter 주입
 * Spring Container 에 있는 bean을 Setter 형식의 메소드의 매개변수에 주입
 * Setter 형식의 메소드에 @Autowired 를 한번만 추가 하면 됨.
 * */
@Component // Spring Container에 Person 이라는 이름의 bean 을 만들어 준다.
@ToString
public class Person {
  
  // field
  private Address address;
  private Contact contact;
  
 
  // Setter 형식의 메소드
  // 한번에 쓸 수있음.,.,,.,.,.!~!~!~!~!~!~
  @Autowired // 매개변수에 선언된 Address 타입과 Contact 타입의 bean 이 매개변수에 자동으로 주입됩니다.
  public void setBeans(Address address, Contact contact) {
    this.address = address;
    this.contact = contact;
  }
  
  
  /* 실제 Setter에 작업 가능하나 할 필요 없음 
  @Autowired
  public void setAddress(Address address) {
    this.address = address;
  }
  @Autowired
  public void setContact(Contact contact) {
    this.contact = contact;
  }
  */
}
