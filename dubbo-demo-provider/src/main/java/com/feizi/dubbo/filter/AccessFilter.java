package com.feizi.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

import java.util.Arrays;

/**
 * 访问拦截器（消费方调用信息,扩展拦截器）
 * Created by feizi on 2017/8/17.
 */
@Activate(group = Constants.PROVIDER)
public class AccessFilter implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = invoker.invoke(invocation);

        StringBuffer sb = new StringBuffer();
        sb.append("[result]->" + result.getValue()).append(" | ");
        sb.append("[consumer]->" + RpcContext.getContext().getRemoteAddress()).append(" | ");
        sb.append("[provider]->" + RpcContext.getContext().getLocalAddress()).append(" | ");
        sb.append("[interface]->" + invoker.getInterface()).append(" | ");
        sb.append("[method]->" + invocation.getMethodName()).append(" | ");
        sb.append("[parameterType]->" + Arrays.toString(invocation.getParameterTypes())).append(" | ");
        sb.append("[parameters]->" + Arrays.toString(invocation.getArguments()));

        System.out.println(sb.toString());
        return result;
    }
}