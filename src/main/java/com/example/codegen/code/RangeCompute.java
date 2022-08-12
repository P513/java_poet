package com.example.codegen.code;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;

public class RangeCompute {
  public static void main(String[] args) throws IOException {
    MethodSpec main = MethodSpec.methodBuilder("main")
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
        .returns(void.class)
        .addParameter(String[].class, "args")
        .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
        .build();

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
