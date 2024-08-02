package com.baimiaomiao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className LoadBalancer
 * @since 1.0
 */


public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
