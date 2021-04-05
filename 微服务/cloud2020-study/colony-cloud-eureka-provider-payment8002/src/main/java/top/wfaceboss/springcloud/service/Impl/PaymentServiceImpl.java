package top.wfaceboss.springcloud.service.Impl;

import org.springframework.stereotype.Service;
import top.wfaceboss.springcloud.dao.PaymentDao;
import top.wfaceboss.springcloud.entities.Payment;
import top.wfaceboss.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return  paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}