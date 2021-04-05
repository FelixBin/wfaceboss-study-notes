package top.wfaceboss.springcloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wfaceboss.springcloud.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {

        String serial = UUID.randomUUID().toString();
        return messageProvider.send(serial);
    }
}
