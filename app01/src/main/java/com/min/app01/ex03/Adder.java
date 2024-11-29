package com.min.app01.ex03;

import org.springframework.stereotype.Component;

@Component

public class Adder {
  
public  int add(int...args) {
    int total = 0;
    for(int i = 0; i < args.length; i++)
      total += args[i];
    return total;
  }
}
