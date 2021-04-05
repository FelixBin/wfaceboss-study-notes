package top.wfaceboss.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.wfaceboss.springcloud.entities.CommonResult;
import top.wfaceboss.springcloud.entities.Payment;
import top.wfaceboss.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
