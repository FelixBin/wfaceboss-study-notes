package top.wfaceboss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import top.wfaceboss.myRinbonRule.MySelfRule;

@SpringBootApplication
@EnableDiscoveryClient
// 选择要接收的服务和配置类
@RibbonClient(name = "cloud-zk-ribbon-provider-payment",configuration = MySelfRule.class)
public class ZKRibbonConsumerMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(ZKRibbonConsumerMain8080.class, args);
    }
}
