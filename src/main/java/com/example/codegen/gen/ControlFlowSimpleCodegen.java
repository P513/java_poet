package com.example.codegen.gen;

import java.lang.String;
import java.lang.System;

public final class ControlFlowSimpleCodegen {
  public static void main(String[] args) {
    int total = 0;
    for (int i = 0; i < 10; i++) {
      total += i;
      System.out.println(total);
    }
  }
}
