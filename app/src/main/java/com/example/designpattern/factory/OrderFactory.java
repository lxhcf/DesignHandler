package com.example.designpattern.factory;

/**
 * 订单对象工厂类,这里的订单工厂类对象可以创建一个复杂对象--order对象
 * 该复杂对象调用了若干简单对象生成,而用户不用去关心该复杂对象的制造过程,直接可以获得一个复杂对象
 */
public class OrderFactory {
    //创建一份巨无霸套餐(巨无霸+可乐+苹果派)
    public static Order createBigMacCombo(){
        return new Order.OrderBuilder()
                .addBurger( new BigMac())
                .addBeverage( new Coke())
                .addSnack( new ApplePie())
                .build();
    }
    //创建一份吉士汉堡套餐(吉士汉堡+牛奶+奶昔)
    public static Order createCheeseBurgerCombo(){
        return new Order.OrderBuilder()
                .addBurger( new CheeseBurger())
                .addBeverage( new Milk())
                .addSnack( new MilkShack())
                .build();
    }
    //创建一份双层吉士汉堡套餐(双层吉士汉堡+橙汁+巧克力奶昔)
    public static Order createDoubleBurgerCombo(){
        return new Order.OrderBuilder()
                .addBurger( new DoubleCheeseBurger())
                .addBeverage( new OrangeJuice())
                .addSnack( new ChocolateShack())
                .build();
    }
}
