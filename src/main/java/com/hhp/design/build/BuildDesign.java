package com.hhp.design.build;

/**
 * Created by huanghaopeng on 16/8/13.
 */
public class BuildDesign {
    private String name;

    private Integer age;

    public BuildDesign(Builder builder) {
        name = builder.name;
        age = builder.age;
    }

    public static class Builder{
        private String name;

        private Integer age;

        public Builder(){

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public BuildDesign build(){
            return new BuildDesign(this);
        }
    }

    public static void main(String[] args) {
        new BuildDesign.Builder().setName("huang").setAge(8).build();
    }
}
