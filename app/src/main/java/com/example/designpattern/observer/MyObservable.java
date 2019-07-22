package com.example.designpattern.observer;

import java.util.Observable;

public class MyObservable extends Observable {
    public void sendChangeMeg(String content) {
        //方法继承自Observable，标示状态或是内容发生改变
        setChanged();
        //方法继承自Observable，通知所有观察者，最后会调用每个Observer的update方法
        notifyObservers(content);
    }
}
