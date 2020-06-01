package cn.chennan.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cn
 * @date 2020-05-31 20:38
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){

        int current, next;
        do{
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("****第几次访问, 次数next: "+ next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
