package com.example.designpattern.builder;
/**
 * 用途：第一种创造学生对象的类
 * 使用：该类提供了四种构造函数用来创建一个学生对象
 * 评价：不同属性之间的组合会产生许多种构造函数，构造函数太多，会导致代码的可读性和维护性变差。
 */
public class StudentFirst {
    private final int stuId;//必选属性
    private final String name;//必选属性
    private final int age;//可选
    private final int gender;//可选
    private final String address;//可选

    public StudentFirst(int stuId, String name){
        this(stuId,name,0,1,"");
    }
    public StudentFirst(int stuId, String name, int age){
        this(stuId,name,age,1,"");
    }
    public StudentFirst(int stuId, String name, int age, int gender){
        this(stuId,name,age,gender,"");
    }
    public StudentFirst(int stuId, String name, int age, int gender, String address) {
        this.stuId = stuId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
}
