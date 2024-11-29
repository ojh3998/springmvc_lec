package com.min.app01.ex03;

import org.springframework.stereotype.Component;

@Component
public class Subtractor { 
  
 public int subtract(int a, int b) {
    return a >= b ? a - b : b - a;
  }

}
