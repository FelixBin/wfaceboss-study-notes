package top.wfaceboss.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GatewayEurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayEurekaMain7001.class, args);
    }
}
