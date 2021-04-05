package top.wfaceboss.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"top.wfaceboss.springcloud.alibaba.dao"})
public class MyBatisConfig {

}
