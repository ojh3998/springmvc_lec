package com.min.app01.pkg03_component;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component(value = "p") // 이 Contact 클래스는 person 인 bean 으로 만들어집니다.
                        // 이름 바꿀 수있음~!
@Getter
public class Person {
  
 private String name = "김성율";
 private Contact contact = new Contact("010-1111-1212", "ojh3998@naver.com");
 
}
