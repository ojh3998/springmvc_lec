package com.min.app02.pkg01_field;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.min.app02.pkg01_field", "com.min.app02.domain");
                                                                                                       // "com.min.app02" 상위패키지 하나로적을 수 있음.
    
    Person person = ctx.getBean("person", Person.class);
    System.out.println(person);
    
    ctx.close();

  }

}
