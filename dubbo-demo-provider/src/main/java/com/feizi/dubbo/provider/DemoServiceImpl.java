package com.feizi.dubbo.provider;

import com.feizi.dubbo.DemoService;

/**
 * Created by feizi on 2017/8/15.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name, int age) {
        return "Hello, " + name + ", your age is: " + age;
    }
}
