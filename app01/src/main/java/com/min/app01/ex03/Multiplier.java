package com.min.app01.ex03;

import org.springframework.stereotype.Component;

@Component
public class Multiplier {
  
 public int multiply(int...args) {
    int product = 1;
    for(int i = 0; i < args.length; i++)
      product *=args[i];
    return product;
  }

}
