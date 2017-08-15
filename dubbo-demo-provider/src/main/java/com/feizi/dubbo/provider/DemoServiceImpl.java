package com.feizi.dubbo.provider;

import com.alibaba.dubbo.rpc.RpcContext;
import com.feizi.dubbo.DemoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by feizi on 2017/8/15.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }
}
