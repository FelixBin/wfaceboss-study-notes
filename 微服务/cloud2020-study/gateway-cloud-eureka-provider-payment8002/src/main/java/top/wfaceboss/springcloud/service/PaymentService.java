package top.wfaceboss.springcloud.service;

import top.wfaceboss.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long  id);
}
