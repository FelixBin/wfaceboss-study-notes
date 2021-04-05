package top.wfaceboss.springcloud.alibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import top.wfaceboss.springcloud.entities.CommonResult;

public class CustomerblockHandler {
    public static  CommonResult handleException2(BlockException exception){

        return new CommonResult(4444,"自定义解耦限流处理类 handleException =================== 1");
    }
}


