package com.freedom.demo;

/**
 * Created by xxhuang on 2016/4/26.
 */
public class Person implements Cloneable {
    private String name;
    private String pwd;
    private int age;

    public Person(){

    }

    public Person(String name, String pwd, int age) {
        this.pwd = pwd;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
