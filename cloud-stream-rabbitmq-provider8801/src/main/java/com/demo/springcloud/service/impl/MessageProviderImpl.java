package com.demo.springcloud.service.impl;

import com.demo.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;


@EnableBinding(Source.class)//定义消息的推送管道 将Channel和Exchanges绑定在一起
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道/信道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String serial= UUID.randomUUID().toString();
        System.out.println("********serial:"+serial);
        output.send(MessageBuilder.withPayload(serial).build());
        return serial;
    }
}
