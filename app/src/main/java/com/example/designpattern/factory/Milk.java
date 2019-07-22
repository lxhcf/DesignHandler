package com.example.designpattern.factory;

public class Milk implements IBeverages {
    @Override
    public String makeDrinking() {
        return "牛奶";
    }
}
