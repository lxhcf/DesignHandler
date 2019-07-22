package com.example.designpattern.factory;

public class MilkShack implements ISnacks {
    @Override
    public String makeSnack() {
        return "奶昔";
    }
}
