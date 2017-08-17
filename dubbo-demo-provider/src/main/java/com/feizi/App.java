package com.feizi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 入口
 * Created by feizi on 2017/8/15.
 */
public class App {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/dubbo-demo-provider.xml"});
        context.start();

        System.out.println("注册服务提供者........");

        System.in.read(); // 按任意键退出
    }
}
