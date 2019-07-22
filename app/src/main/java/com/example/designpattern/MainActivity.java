package com.example.designpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.designpattern.adapter.AdapteredVolt;
import com.example.designpattern.adapter.VoltAdapter;
import com.example.designpattern.factory.Order;
import com.example.designpattern.factory.OrderFactory;
import com.example.designpattern.builder.StudentFirst;
import com.example.designpattern.builder.StudentSecond;
import com.example.designpattern.builder.StudentThird;
import com.example.designpattern.observer.MyObservable;
import com.example.designpattern.observer.MyObserver;
import com.example.designpattern.proxy.House;
import com.example.designpattern.proxy.IHouse;
import com.example.designpattern.proxy.ProxyHandler;
import com.example.designpattern.proxy.ProxyHouse;
import com.example.designpattern.strategy.BusStragety;
import com.example.designpattern.strategy.TaxiStragety;
import com.example.designpattern.strategy.TrafficCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builderTest();
        factoryTest();
        adapterTest();
        observerTest();
        strategyTest();
        peoxyTest();

    }

    /**
     * 设计模式之建造者模式的应用
     * 例子简介:
     *      对比分别三种方式来创建学生对象
     * 结论:
     *      建造者模式适合用来创建多属性的对象
     * 源码中的应用:
     *      AlertDialog
     */
    private void builderTest() {
          /*
         方式一：这种方式通过构造函数来给对象赋予属性，不灵活
         */
        StudentFirst studentFrist1 = new StudentFirst(1, "张三");
        StudentFirst studentFrist2 = new StudentFirst(1, "张三", 18);
        StudentFirst studentFrist3 = new StudentFirst(1, "张三", 18, 0);
        /*
        方式二：这种方式通过方法来给对象赋予属性，没有返回一个对象创建成功的信号
         */
        StudentSecond studentSecond = new StudentSecond();
        studentSecond.setAge(18);
        studentSecond.setAddress("地址");
        studentSecond.setGender(0);
        studentSecond.setStuId(1);
          /*
        方式三：这种方式适合用来创建多属性的对象,AlertDialog也是用这种方式创建
         */
        StudentThird studentThird = new StudentThird.StudentBuilder(1, "张三")
                .setAddress("地址")
                .setAge(18)
                .setGender(1)
                .build();



    }

    /**
     * 设计模式之简单工厂模式的应用
     * 例子简介:
     *         该例子将通过工厂类来创建一个订单对象,该对象内部调用了汉堡,饮料,小吃等简单对象
     * 结论:
     *         简单工厂模式适合用来创建复杂的对象(该对象的创建需要使用多个简单对象)
     * 源码中的应用:
     *         多线程中的Executors
     */
    void factoryTest(){
        Order order = OrderFactory. createBigMacCombo();
        Log.d("TAG",order.makeOrder());
    }

    /**
     * 设计模式之适配器模式
     * 例子简介:
     *          该例子实例化了一个适配器对象
     *          将被适配对象(例如插座的220V电压)转换成手机充电需要的5V电压
     * 结论:
     *          当碰到一个接口中想调用另一个类部分方法的情况时,
     *          可以用一个中间的适配器实现该接口,
     *          然后在适配器中实例化一个被适配的对象,或继承被适配对象的类
     * 源码中的应用:
     *          ListView、GridView、RecyclerView等的Adapter
     */
    void adapterTest(){
        //接受一个被适配对象,比如日常插座的220V电压
        VoltAdapter voltAdapter=new VoltAdapter(new AdapteredVolt());
        //输出一个适配器转换后的电压,例如手机充电需要的5v电压
        voltAdapter.getVolt5();

    }

    /**
     * 设计模式之观察者模式
     * 例子简介:
     *          该例子实例化了一个被观察对象和两个观察者对象,
     *          并将观察者添加给被观察对象
     *          当被观察者发生改变时,发布通知,其他两个观察者的update方法会被调用
     * 结论:
     *          一类事物的状态的改变会影响到另一类事物,应当用该设计模式
     * 源码中的应用:
     *          常见的发布-订阅模式
     *          ListView的Adapter的notifyDataSetChanged更新方法
     *          BroadcastReceiver
     *          开源库EventBus
     *          RxJava
     */
    void observerTest(){
        //实例化一个被观察对象
        MyObservable myObservable = new MyObservable();
        //实例化两个观察者
        MyObserver myObserver1 = new MyObserver("observer-1");
        MyObserver myObserver2 = new MyObserver("observer-2");
        //给被观察者添加观察者
        myObservable.addObserver( myObserver1);
        myObservable.addObserver(myObserver2);
        //当被观察者发生改变时,发布消息,两个观察者中的uodate方法随之被调用
        myObservable.sendChangeMeg("发布更新啦");

    }

    /**
     * 设计模式之普通代理模式
     * 例子简介:
     *          该例子定义了一个真实主题房屋和房屋代理,
     *          把房屋委托给代理后,客户要找房子,签合同直接找代理就好了
     * 实现过程:
     *          1.定义了一个IHouse接口,所有房屋都要实现这个接口
     *          接口内有房屋信息,签订合同等方法
     *          2.定义一个房屋类实现IHouse接口
     *          3.定义一个房屋代理类ProxyHouse,可以根据传入的不同的实现房屋接口的房屋类,调取房屋类的信息
     *          4.用户不需要去找真实的房屋类,只要去找代理即可
     */
    void peoxyTest(){
        IHouse house = new House("Downton Abbey", 5000);
        IHouse proxyHouse = new ProxyHouse(house);
        Log.i("TAG", "looking for a perfect house");
        proxyHouse.getHouseInfo();
        Log.i("TAG", "thinking");
        proxyHouse.signContract();
        proxyHouse.payFees();
        Log.i("TAG", "so easy");
    }

    /**
     * 设计模式之动态代理模式
     * 例子简介:
     *          普通代理关系都是固定的,当代理多个真实对象的时候就要写多个代理类,
     *          而且会产生冗余的代码,扩展性和可维护性都不高,
     *          而动态代理是基于反射实现了在程序执行的过程中才决定代理什么对象
     *          像AOP的核心思想就是动态代理.
     *          代理类在程序运行前不存在、运行时由程序动态生成的代理方式称为动态代理。
     * 实现过程:
     *          1.定义了一个IHouse接口,所有房屋都要实现这个接口
     *          接口内有房屋信息,签订合同等方法
     *          2.定义一个房屋类实现IHouse接口
     *          3.定义一个房屋代理处理器类ProxyHandler,该处理器类可以生成动态代理,
     *          并实现了InvocationHandler接口,可以统一处理动态代理的方法
     *          4.用户不需要去找真实的房屋类,只要去找代理即可
     * 结论:
     *          动态代理类比普通代理类强在这种代理不是只针对某类对象的代理,比如房屋代理,
     *          但它作为代理针对很多类对象的方法的处理,没有办法很精细地加工,只能重现原有的方法,
     *          否则可扩展性会变差
     * 源码中的应用:
     *          OkHttp
     */
    void peoxyTest2(){
        ProxyHandler proxy = new ProxyHandler();
        IHouse proxyHouse = (IHouse) proxy.newProxyInstance(new House("Downton Abbey", 5000));
        Log.i("TAG", "looking for a perfect house");
        proxyHouse.getHouseInfo();
        Log.i("TAG", "thinking");
        proxyHouse.signContract();
        proxyHouse.payFees();
        Log.i("TAG", "so easy");
    }

    /**
     * 设计模式之策略模式
     * 例子简介:
     *          该例子实例化一个交通费用计算者对象,
     *          根据传入乘坐策略不同,公里数不同,所产生的费用也不一样
     * 实现过程:
     *          1.定义了一个CalculateStragety接口,所有出现方式都要实现这个计算策略的接口,
     *            接口内有一个计算费用的方法
     *          2.定义了两种出行策略类BusStragety(公交出行)和TaxiStragety(出租车出行),
     *            实现了计算策略接口,重写了计算费用的方法.
     *          3.定义了一个交通出行计算类,
     *            setCalculateStragety方法,传入参数为CalculateStragety接口,可以设置出行方式
     *            calculatePrice方法,返回CalculateStragety接口的计算费用方法
     * 结论:
     *          不同的策略(出行方式)需要进行相同的某种操作(计算费用)可以采用策略模式,
     *          可以避免去源码中添加if else分支而改动源码,只需要新增一个出行策略,去实现计算策略接口
     * 源码中的应用:
     *          Android中属性动画的时间差值器分为线性差值器、加速减速差值器等，
     *          这些差值器里面就用到了策略模式来隔离不同的动画速率计算算法
     */
    void strategyTest(){
        TrafficCalculator trafficCalculator = new TrafficCalculator();
        trafficCalculator.setCalculateStragety(new BusStragety());
        trafficCalculator.calculatePrice(66);

        trafficCalculator.setCalculateStragety(new TaxiStragety());
        trafficCalculator.calculatePrice(66);

    }
}
