package com.example.designpattern.builder;

/**
 * 用途：第三种创造学生对象的类
 * 使用：该类使用建造者模式来创建一个学生对象
 * 评价：该类的创建由建造者者执行，可以指定必须属性，自由赋值额外属性，并且以build为结束标志
 *        提高代码的可读性
 */
public class StudentThird {
    private final int stuId;//必须
    private final String name;//必须
    private final int age;//可选
    private final int gender;//可选
    private final String address;//可选

    public StudentThird(StudentBuilder builder) {
        this.stuId = builder.stuId;
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.address = builder.address;
    }
    public int getStuId() {
        return stuId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    /**
     * 用途：静态内部类用来创建学生类对象
     */
    public static class StudentBuilder{
        private final int stuId;
        private final String name;
        private int age;
        private int gender;
        private String address;

        /**
         * 静态内部类的构造函数指定了两个必须的函数
         * @param stuId
         * @param name
         */

        public StudentBuilder(int stuId,String name){
            this.stuId = stuId;
            this.name = name;
        }
        public StudentBuilder setAge(int age){
            this.age = age;
            return this;
        }
        public StudentBuilder setGender(int gender){
            this.gender = gender;
            return this;
        }
        public StudentBuilder setAddress(String address){
            this.address = address;
            return this;
        }
        public StudentThird build(){
            return new StudentThird(this);
        }
    }
}
