package top.wfaceboss.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderNacosOpenFeignApplication84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosOpenFeignApplication84.class,args);
    }
}
