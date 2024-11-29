package com.min.app01.pkg01_constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

  public static void main(String[] args) {
    // AnnotationConfigApplicationContext 클래스
    //JAVA Annotation(@Configuration, @Bean) 을 이용해 생성된 bean 관리
    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class); 
                                    // new AnnotationConfigApplicationContext("com.min.app01.pkg03");
  
    Contact contact = ctx.getBean("contact", Contact.class);
    System.out.println(contact.getMobile());
    System.out.println(contact.getEmail());
    
    Person person = ctx.getBean("person", Person.class);
    System.out.println(person.getName());
    System.out.println(person.getContact().getMobile());
    System.out.println(person.getContact().getEmail());
    
    ctx.close();
  }

}
