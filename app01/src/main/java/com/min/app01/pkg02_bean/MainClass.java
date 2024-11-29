package com.min.app01.pkg02_bean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;

public class MainClass {

  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("pkg02/appCtx.xml");
    
    Contact c = ctx.getBean("contactBean", Contact.class);
    System.out.println(c.getMobile());
    System.out.println(c.getEmail());
    
    Person p = ctx.getBean("personBean", Person.class);
    System.out.println(p.getName());
    System.out.println(p.getContact());
    System.out.println(p.getContact());
    
    ctx.close();
  }

}
