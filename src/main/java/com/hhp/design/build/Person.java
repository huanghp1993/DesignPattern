package com.hhp.design.build;

/**
 * Created by huanghaopeng on 16/11/10.
 */
public class Person {

    private String name;

    private int sex;

    public Person(String name) {
        this.name = name;
    }

    public Person(int sex) {
        this.sex = sex;
    }

    public Person(String name, int sex) {
        this.name = name;
        this.sex = sex;
    }
}
