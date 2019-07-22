package com.example.designpattern.factory;

public class DoubleCheeseBurger implements IBurgers {
    @Override
    public String makeBurger() {
        return "双层芝士汉堡包";
    }
}
