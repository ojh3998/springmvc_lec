package com.min.app02.pkg03_constructor;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.app02.domain.Address;
import com.min.app02.domain.Contact;

// import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;



/*
 * DI 방식 3 - Constructor 주입
 * Spring Container 에 있는 bean을 Constructor 형식의 메소드의 매개변수에 주입
 * Constructor 형식의 메소드에 @Autowired 를 한번만 추가 하면 됨.
 * Spring Framework 4.3 이후 버전에서는 @Autowired 생략가능
 * 생성자 주입을 이용하면 필드에 final 키워드를 추가하여 좀더 안전한 코드를 작성 가능하다.
 * final 추가된 필드의 초기화를 위한 생성자는 @AllArgsConstructor 가 아니라
 * 필드에 final 키워드를 추가한 뒤 @RequiredArgsConstructor를 사용합니다.
 * 
 * */



//@AllArgsConstructor // 생성자 를 만들어 주는 코드 이기때문에 이것만 적으면 끝~!~!~
 @RequiredArgsConstructor // Person(Address, Contact) + @NonNull                  
 // final field를 위한 생성자 자동생성방식
@Component
@ToString
public class Person {
  
  // field
  // final field 는 생성자에서 주입받아야 함!
  private final Address address;
  private final Contact contact;           // final키워드는 원래 생성과 동시에 초기화를 진행해야 하지만, 생성자가있으면 가능하다~!~!~!
  
  
  // constructor
  
  
  /*
  @Autowired // 생성자의 Autowired 는 생략가능!~!~!~!~!
  public Person(Address address, Contact contact) {

    this.address = address;
    this.contact = contact;
    
  }
  */
}
