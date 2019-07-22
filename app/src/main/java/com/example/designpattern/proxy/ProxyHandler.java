package com.example.designpattern.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 简介:
 *      该类是代理处理器,
 *      这个类可以用newProxyInstance 这个方法来动态创建一个代理对象的类
 *      由于他实现了InvocationHandler接口,因此它生成的代理对象调用一个方法时,
 *      这个方法的调用会被转为代理处理器的invoke方法进行调用
 * 评价:
 *      SubjectInvocationHandler并不是真正的代理类，
 *      而是用于定义代理类需要扩展、增强那些方法功能的类。
 */
public class ProxyHandler implements InvocationHandler {
    private final String TAG = ProxyHandler.class.getSimpleName();
    /**
     * 这个是真实的类对象由newProxyInstance方法传入生成
     */
    Object targetObj;

    /**
     * 动态类Proxy对象是通过newProxyInstance方法来生成的
     * @param targetObj
     * @return
     */
    public Object newProxyInstance(Object targetObj){
        this.targetObj = targetObj;
        /**
         * Proxy这个类，这个类的作用就是用来动态创建一个代理对象的类,
         * 用的最多的就是 newProxyInstance 这个方法
         * public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         * 第一个参数loader：
         * 一个ClassLoader对象，用来加载 Class 的,定义了由哪个ClassLoader对象来加载代理对象
         * 第二个参数interfaces:
         * 一个Interface对象的数组，表示要让代理类实现的接口类型;
         * 第三个参数一个InvocationHandler对象,
         * 表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
         * 从而实现当我们通过代理对象调用一个方法时,
         * 这个方法的调用会被转为由InvocationHandler这个接口的invoke方法进行调用
         */
        return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(),
                targetObj.getClass().getInterfaces(), this);
    }

    /**
     * invoke意为调用,最简单的用法是可以把方法参数化,它位于 InvocationHandler(Interface)接口中
     * 每个代理类的实例都关联到一个handler,当我们通过代理对象调用一个方法时,
     * 这个方法的调用会被转为由InvocationHandler这个接口的invoke方法进行调用
     * 对代理对象的所有方法的调用都被转发至该函数处理。在这里可以灵活的自定义各种你能想到的逻辑。
     * @param proxy 生成的代理对象
     * @param method 指我们所要调用真实对象的某个方法的Method对象；
     * @param args 指代的是调用真实对象某个方法时接受的参数
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret;
        //在代理真实对象前我们可以添加一些自己的操作
        Log.i(TAG, "method name:" + method.getName());

        ret = method.invoke(targetObj, args);

        return ret;
    }
}
