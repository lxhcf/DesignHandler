package com.example.designpattern.adapter;

/**
 * 该接口为目标接口,提供5V电压,这是手机需要的电压
 */
public interface TargetVolt {
    /**
     * 返回5V电压
     * @return 电压值
     */
    public int getVolt5();
}
