package top.wfaceboss.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-zk-ribbon-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
