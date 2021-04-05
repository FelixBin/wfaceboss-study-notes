package top.wfaceboss.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wfaceboss.springcloud.alibaba.myHandler.CustomerblockHandler;
import top.wfaceboss.springcloud.entities.CommonResult;
import top.wfaceboss.springcloud.entities.Payment;


@RestController
public class RateLimitController {

    /**
     * 按照资源名称限流
     *
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    //@SentinelResource（参数1，参数2） 参数1指明按那种方式进行限流 参数2：配置异常处理兜底方法
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    /**
     * sentinel 控制台配置异常兜底处理方法
     *
     * @param exception
     * @return
     */
    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    /**
     * 客户自定义限流处理逻辑
     *
     * @return
     * @SentinelResource(参数1，参数2，参数3) ：参数1 ：限流方式 参数2：那个类  参数3：那个方法
     */
    @GetMapping("/customerblockHandler")
    @SentinelResource( value = "customerblockHandler",
            blockHandlerClass=CustomerblockHandler.class,
            blockHandler = "handleException2")
    public CommonResult customerblockHandler(){

        return new CommonResult(200,"按照自定义限流ok",new Payment(2020L,"serial001"));
    }
}



