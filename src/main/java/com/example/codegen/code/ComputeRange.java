package com.example.codegen.code;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;

// name과 from, to, op 값에 해당하는 method 호출
public class ComputeRange {
  public static void main(String[] args) throws IOException {
    // 값 입력 예시
    System.out.println(computeRange("multiply10to20", 10, 20, "*"));
  }

  private static MethodSpec computeRange(String name, int from, int to, String op) {
    return MethodSpec.methodBuilder(name)
        .returns(int.class)
        .addStatement("int result = 1")
        .beginControlFlow("for (int i = " + from + "; i < " + to + "; i++)")
        .addStatement("result = result " + op + " i")
        .endControlFlow()
        .addStatement("return result")
        .build();
  }
}
