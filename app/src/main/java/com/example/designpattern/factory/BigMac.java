package com.example.designpattern.factory;

public class BigMac implements IBurgers {
    @Override
    public String makeBurger() {
        return "巨无霸汉堡包";
    }
}
