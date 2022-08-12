package com.example.codegen.code;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;

public class HelloWorld {
  public static void main(String[] args) throws IOException {
    MethodSpec main = MethodSpec.methodBuilder("main")
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
        .returns(void.class)
        .addParameter(String[].class, "args")
        .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
        .build();

    TypeSpec helloWorldCodegen = TypeSpec.classBuilder("HelloWorldCodegen")
        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
        .addMethod(main)
        .build();

    JavaFile javaFile = JavaFile.builder("com.example.codegen/codegen", helloWorldCodegen)
        .build();

    File file = new File("src/main/java");
    javaFile.writeTo(file);
  }
}
