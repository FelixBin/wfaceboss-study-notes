package top.wfaceboss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OpenFeignEurekaPaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignEurekaPaymentMain8002.class, args);
    }
}
