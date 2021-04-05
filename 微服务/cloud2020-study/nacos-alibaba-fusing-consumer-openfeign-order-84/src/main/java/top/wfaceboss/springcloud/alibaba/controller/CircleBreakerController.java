package top.wfaceboss.springcloud.alibaba.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.wfaceboss.springcloud.alibaba.service.PaymentService;
import top.wfaceboss.springcloud.entities.CommonResult;
import top.wfaceboss.springcloud.entities.Payment;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}

