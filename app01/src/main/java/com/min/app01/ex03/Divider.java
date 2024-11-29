package com.min.app01.ex03;

import org.springframework.stereotype.Component;

@Component
public class Divider {
  
public double divide(int a, int b) {
    return a >= b ? (double)a / b : (double)b / a;
    }

}
