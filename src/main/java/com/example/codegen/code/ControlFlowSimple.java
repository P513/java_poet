package com.example.codegen.code;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;

// ControlFlow로 조건문 코드젠
public class ControlFlowSimple {
  public static void main(String[] args) throws IOException {
    MethodSpec main = MethodSpec.methodBuilder("main")
        .addStatement("int total = 0")
        .beginControlFlow("for (int i = 0; i < 10; i++)")
        .addStatement("total += i")
        .endControlFlow()
        .build();

    /*
    MethodSpec main = MethodSpec.methodBuilder("main")
        .addCode(""
            + "int total = 0;\n"
            + "for (int i = 0; i < 10; i++) {\n"
            + "  total += i;\n"
            + "}\n")
        .build();
     */

    TypeSpec controlFlowSimple = TypeSpec.classBuilder("ControlFlowSimpleCodegen")
        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
        .addMethod(main)
        .build();

    JavaFile javaFile = JavaFile.builder("com.example.codegen.gen", controlFlowSimple)
        .build();

    File file = new File("src/main/java");
    javaFile.writeTo(file);
  }
}
