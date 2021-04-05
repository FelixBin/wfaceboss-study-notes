package top.wfaceboss.springcloud.service.Impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import top.wfaceboss.springcloud.service.IMessageProvider;

import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;


//@EnableBinding 指信道channel和exchange绑定在一起
//@EnableBinding(Source.class) 就是将 Source(源) 放到 Channel 的意思

@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;// 消息发送管道

    @Override
    public String send(String serial) {

        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("发送消息: "+serial);
        return null;
    }
}
