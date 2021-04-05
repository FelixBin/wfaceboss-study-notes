package top.wfaceboss.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;


@RestController
public class TestZipKinSleuthController {

    @GetMapping("/getRandom")
    public String getRandom(){
        return UUID.randomUUID().toString();
    }
}
