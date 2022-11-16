package com.demo.springcloud.contorller;

import com.demo.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProviderService;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProviderService.send();
    }
}
