package com.dh.gatewayservice.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import reactor.core.publisher.Mono;

@Component
public class InfoFilter extends AbstractGatewayFilterFactory<InfoFilter.Config> {

    public static Logger logger = LoggerFactory.getLogger(InfoFilter.class);

    public InfoFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            logger.info("Endpoint: " + exchange.getRequest().getPath());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("Port: " + exchange.getResponse().getHeaders().get("port"));
            }));
        }));
    }

    public static class Config {

    }
}
