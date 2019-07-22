package com.example.designpattern.factory;

public class ChocolateShack implements ISnacks {
    @Override
    public String makeSnack() {
        return "巧克力奶昔";
    }
}
