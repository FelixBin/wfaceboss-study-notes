package top.wfaceboss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZKConsumerMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(ZKConsumerMain8080.class,args);
    }
}
