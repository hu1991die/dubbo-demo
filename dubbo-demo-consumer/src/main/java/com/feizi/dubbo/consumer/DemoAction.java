package com.feizi.dubbo.consumer;

import com.feizi.dubbo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by feizi on 2017/8/15.
 */
public class DemoAction {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();

        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法

        System.out.println(hello); // 显示调用结果
    }
}
