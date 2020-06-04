package cn.chennan.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn
 * @date 2020-06-04 13:20
 */
@Configuration
public class GateWayConfig {
    /**
     * 配置了一个id为route-name的路由规则.
     * 当访问地址http://localhost:9527/guonei会自动转发到地址:http://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_config", r->r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_config", r->r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
