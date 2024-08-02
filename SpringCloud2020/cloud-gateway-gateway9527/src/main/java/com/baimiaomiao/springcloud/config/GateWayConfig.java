package com.baimiaomiao.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className GateWayConfig
 * @since 1.0
 */

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        return routes.route("path_route_baimiaomiao",
                r -> r.path("/politics")
                        .uri("http://www.news.cn/politics")).build();
    }

}
