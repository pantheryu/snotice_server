package com.kevin.framework.serializer;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by spirit on 2015/10/8.
 * 实现序列化接口
 */
public interface Serializer {
    /**
     * 序列化指定对象.
     * @param obj
     */
    byte[] serialize(Object obj);

    /**
     * 反序列化对象.
     * @param klass
     * @param data
     * @return
     * 反序列化的对象
     */
    <T> T deserialize(Class<T> klass, byte[] data);

    /**
     * 序列化.
     *
     * @param obj
     * @param outputStream
     * @return
     * 写入的字节数.
     */
    int serialize(Object obj, OutputStream outputStream);

    /**
     * 反序列化.
     * @param klass
     * @param inputStream
     * @return
     */
    <T> T deserialize(Class<T> klass, InputStream inputStream);
}
