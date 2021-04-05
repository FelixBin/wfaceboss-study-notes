package top.wfaceboss.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "nacos-payment-provider")
public interface OrderNacosService {

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id")Integer id);

}
