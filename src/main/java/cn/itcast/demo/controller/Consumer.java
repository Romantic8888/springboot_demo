package cn.itcast.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 接收消息 监听器
 *
 */
@Component
public class Consumer {
    @JmsListener(destination = "message")
    public void reciverMessage(Map<String,String> map){
        System.out.println("手机号:"+map.get("phone"));
        System.out.println("验证码:"+map.get("code"));
    }
}
