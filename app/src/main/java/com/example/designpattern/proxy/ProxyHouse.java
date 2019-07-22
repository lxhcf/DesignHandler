package com.example.designpattern.proxy;

import android.util.Log;

/**
 * 这是一个房屋代理类
 * 传入一个实现房屋接口的类,然后在重写的方法中,调用实际房屋类的同名方法
 */
public class ProxyHouse implements IHouse {
    private final String TAG = ProxyHouse.class.getSimpleName();
    private IHouse house;
    public ProxyHouse(IHouse house){
        this.house = house;
    }
    @Override
    public void getHouseInfo() {
//        Log.i(TAG, "searching");
        house.getHouseInfo();
//        Log.i(TAG, "search finished");
    }

    @Override
    public void signContract() {
//        Log.i(TAG, "prepare contract");
        house.signContract();
    }

    @Override
    public void payFees() {
        house.payFees();
    }
}
