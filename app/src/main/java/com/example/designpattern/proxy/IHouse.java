package com.example.designpattern.proxy;

/**
 * 这是一个抽象主题房屋接口
 * 提供三个方法,分别是获取房屋信息,签合同和府租金
 */
public interface IHouse {
    void getHouseInfo();
    void signContract();
    void payFees();
}
