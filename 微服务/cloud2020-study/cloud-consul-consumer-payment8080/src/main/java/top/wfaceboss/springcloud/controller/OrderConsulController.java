package top.wfaceboss.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderConsulController {
    public static final String INVOKE_URL = "http://cloud-consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String payment() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
