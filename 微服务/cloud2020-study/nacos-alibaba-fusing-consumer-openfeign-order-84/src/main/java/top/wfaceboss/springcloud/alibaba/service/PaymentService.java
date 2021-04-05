package top.wfaceboss.springcloud.alibaba.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.wfaceboss.springcloud.alibaba.MyHandler.PaymentFallbackService;
import top.wfaceboss.springcloud.entities.CommonResult;
import top.wfaceboss.springcloud.entities.Payment;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
