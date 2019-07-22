package com.example.designpattern.observer;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer{
    private String mName;

    public MyObserver(String name) {
        mName = name;
    }

    @Override
    public void update(Observable observable, Object o) {
        Log.d("TAG",mName + "-->" + "update: " + o);
    }
}
