package com.example.designpattern.factory;

public class Order {
    private IBurgers mBurger;
    private IBeverages mBeverages;
    private ISnacks mSnack;

    private Order(OrderBuilder builder) {
        mBurger = builder.mBurger;
        mBeverages = builder.mBeverages;
        mSnack = builder.mSnack;
    }

    public String makeOrder() {
        StringBuilder sb = new StringBuilder();
        if (mBurger != null) {
            sb.append(mBurger.makeBurger()).append(" ");
        }
        if (mBeverages != null) {
            sb.append(mBeverages.makeDrinking()).append(" ");
        }
        if (mSnack != null) {
            sb.append(mSnack.makeSnack());
        }
        return sb.toString();
    }
    public static class OrderBuilder{
        private IBurgers mBurger;
        private IBeverages mBeverages;
        private ISnacks mSnack;
        public OrderBuilder(){

        }
        public OrderBuilder addBurger(IBurgers burgers){
            this. mBurger = burgers;
            return this;
        }
        public OrderBuilder addBeverage(IBeverages beverages){
            this. mBeverages = beverages;
            return this;
        }
        public OrderBuilder addSnack(ISnacks snacks){
            this. mSnack = snacks;
            return this;
        }
        public Order build(){
            return new Order( this);
        }
    }
}
