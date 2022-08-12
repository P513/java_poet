package com.example.codegen.gen;

import java.lang.String;
import java.lang.System;

public final class ControlFlowNestedCodegen {
  public static void main(String[] args) {
    long now = System.currentTimeMillis();
    if (System.currentTimeMillis() < now) {
      System.out.println("Time travelling, woo hoo!");
    } else if (System.currentTimeMillis() == now) {
      System.out.println("Time stood still!");
    } else {
      System.out.println("Ok, time still moving forward");
    }
  }
}
