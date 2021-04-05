package top.wfaceboss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZKPaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ZKPaymentMain8001.class, args);
    }
}
