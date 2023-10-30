package com.example.msa2departmentservice.config;

import com.example.msa2departmentservice.client.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    /*
     * 부하 분산을 위한 필터 추가
     * */
    private final LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient employeeWebClient() {
        return WebClient.builder()
            .baseUrl("http://employee-service")
            .filter(filterFunction)
            .build();
    }

    @Bean
    public EmployeeClient employeeClient() {
        HttpServiceProxyFactory httpServiceProxyFactory
            = HttpServiceProxyFactory
            .builder(
                WebClientAdapter.forClient(employeeWebClient())
            )
            .build();

        return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }

}
