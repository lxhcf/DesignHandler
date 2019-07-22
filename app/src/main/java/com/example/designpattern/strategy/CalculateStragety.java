package com.example.designpattern.strategy;

/**
 * 这是一个计算车费的接口,可以由不同类型的车辆去实现
 */
public interface CalculateStragety {
    /**
     * 根据公里数计算价格
     *
     * @param km 公里数
     * @return 价格
     */
    int calculatePrice(int km);
}
