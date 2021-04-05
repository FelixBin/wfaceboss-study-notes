package top.wfaceboss.springcloud.alibaba.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.wfaceboss.springcloud.alibaba.service.OrderNacosService;

import javax.annotation.Resource;

@RestController
public class OrderNacosController {
    @Resource
    private OrderNacosService orderNacosService;


    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return orderNacosService.getPayment(id);
    }
}
