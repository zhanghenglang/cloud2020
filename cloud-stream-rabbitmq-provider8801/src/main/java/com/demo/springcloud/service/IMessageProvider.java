package com.demo.springcloud.service;

public interface IMessageProvider {
    /**
     * 定义消息的推送管道
     *
     * @return
     */
    String send();
}
