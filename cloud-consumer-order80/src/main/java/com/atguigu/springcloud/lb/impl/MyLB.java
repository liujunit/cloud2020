package com.atguigu.springcloud.lb.impl;

import com.atguigu.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MyLB implements LoadBalancer {

    private  AtomicInteger atomicInteger = new AtomicInteger(0);


    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("第几次查询*****：" + next);
        return next;
    }

    @Override
    public ServiceInstance intances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
