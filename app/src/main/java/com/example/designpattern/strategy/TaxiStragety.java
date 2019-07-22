package com.example.designpattern.strategy;
/**
 * 出租车计算车费的策略
 */
public class TaxiStragety implements CalculateStragety {
    /**
     * 出租车车费为每公里2元
     *
     * @param km 公里数
     * @return 出租车车费
     */
    @Override
    public int calculatePrice(int km) {
        return km * 2;

    }
}
