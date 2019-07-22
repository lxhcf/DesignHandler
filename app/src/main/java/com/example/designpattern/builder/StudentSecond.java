package com.example.designpattern.builder;
/**
 * 用途：第二种创造学生对象的类
 * 使用：该类提供了空参构造函数用来创建一个学生对象
 * 评价：属性太多，不知道对象需要赋予多少属性
 */
public class StudentSecond {
    private int stuId;//必须
    private String name;//必须
    private int age;//可选
    private int gender;//可选
    private String address;//可选

    public StudentSecond() {

    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}