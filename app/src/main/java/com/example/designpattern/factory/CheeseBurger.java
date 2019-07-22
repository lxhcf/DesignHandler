package com.example.designpattern.factory;

public class CheeseBurger implements IBurgers {
    @Override
    public String makeBurger() {
        return "芝士汉堡包";
    }
}
