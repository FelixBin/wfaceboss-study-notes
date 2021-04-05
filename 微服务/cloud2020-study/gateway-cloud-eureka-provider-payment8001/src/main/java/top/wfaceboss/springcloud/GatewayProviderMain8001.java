package top.wfaceboss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayProviderMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayProviderMain8001.class,args);
    }
}
