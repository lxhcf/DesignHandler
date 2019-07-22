package com.example.designpattern.adapter;

/**
 * 这是适配器类,目标是把日常的220V电压转换为手机需要的5V电压
 * 实现目标接口,重写目标接口的方法,以便输出想要的结果
 * 在类中定义被适配对象,相当于继承被适配对象,可以调用被适配对象的一些方法
 */
public class VoltAdapter implements TargetVolt {
    /**
     * 该属性是被适配的接口,日常的220c电压
     */
    AdapteredVolt adapteredVolt;

    /**
     * 该构造函数传进来一个被适配的对象,即日常的220V电压
     * @param adapteredVolt
     */
    public VoltAdapter(AdapteredVolt adapteredVolt) {
        this.adapteredVolt = adapteredVolt;
    }

    /**
     * 重写了目标接口方法,返回一个5V的电压
     * @return
     */
    @Override
    public int getVolt5() {
        return adapteredVolt.getVolt220()-215;
    }

    /**
     * 相当于继承了被适配的接口的方法,可以返回一个220V的电压
     * @return
     */
    public int getVolt220() {
        return adapteredVolt.getVolt220();
    }

}
