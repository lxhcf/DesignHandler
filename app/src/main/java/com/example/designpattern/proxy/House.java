package com.example.designpattern.proxy;

import android.os.SystemClock;
import android.util.Log;

import java.text.SimpleDateFormat;

/**
 * 这是一个真实主题房屋类
 */
public class House implements IHouse{
    private final String TAG = House.class.getSimpleName();
    /**
     * 定义了两个属性:房屋名称和价格
     */
    private String name;
    private double price;

    public House(String name, double price){
        this.name = name;
        this.price = price;
    }

    /**
     * 获取房屋信息的时候会打印房屋的名称和价格
     */
    @Override
    public void getHouseInfo() {
        Log.i(TAG, "House Info- name:" + name + "  ￥:" + price);
    }

    /**
     * 签合同的时候会打印出时间
     */
    @Override
    public void signContract() {
        Log.i(TAG, "Contract:" + name + "  signed at" +
                new SimpleDateFormat("HH:mm:ss").format(SystemClock.uptimeMillis()));
    }

    /**
     * 付费的时候打印出价格
     */
    @Override
    public void payFees() {
        Log.i(TAG, "Bill: name-" + name + "  $-" + price);
    }
}
