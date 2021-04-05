package top.wfaceboss.springcloud.alibaba.service.Impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import top.wfaceboss.springcloud.alibaba.dao.StorageDao;
import top.wfaceboss.springcloud.alibaba.service.StorageService;

import javax.annotation.Resource;

@Service

public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;


    @Override
    public void decrease(Long productId, Integer count) {
        System.out.println("我执行了的");
         storageDao.decrease(productId, count);

    }
}
