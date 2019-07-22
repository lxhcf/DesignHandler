package com.example.designpattern;

import android.util.Log;

import com.example.designpattern.proxy.House;
import com.example.designpattern.proxy.IHouse;
import com.example.designpattern.proxy.ProxyHouse;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        IHouse house = new House("Downton Abbey", 5000);

        IHouse proxyHouse = new ProxyHouse(house);
//        Log.i("TAG", "looking for a perfect house");
        proxyHouse.getHouseInfo();
//        Log.i("TAG", "thinking");
        proxyHouse.signContract();
        proxyHouse.payFees();
//        Log.i("TAG", "so easy");
    }
}