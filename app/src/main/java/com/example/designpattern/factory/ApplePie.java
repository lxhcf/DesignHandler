package com.example.designpattern.factory;

public class ApplePie implements ISnacks {
    @Override
    public String makeSnack() {
        return "苹果派";
    }
}
