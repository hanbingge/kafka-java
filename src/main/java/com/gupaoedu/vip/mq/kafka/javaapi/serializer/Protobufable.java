package com.gupaoedu.vip.mq.kafka.javaapi.serializer;

/**
 * 序列化工具，将对象转为字节数组
 * 由 User类实现编码和解码
 */
public interface Protobufable {
    public byte[] encode();
}
