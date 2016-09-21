package com.hhp.jvm;

/**
 * Created by huanghaopeng on 16/9/20.
 */
public class MainTest {
    public static void main(String[] args) {
        String[] strings = new String[]{"Cifa.java"};
        int result = compile(strings);
        System.out.print(result);
    }

    public  static int compile(String[] args){
        com.sun.tools.javac.main.Main compiler =
                new com.sun.tools.javac.main.Main("javac");
        return compiler.compile(args);
    }
}
