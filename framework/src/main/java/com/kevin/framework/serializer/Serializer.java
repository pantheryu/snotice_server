package com.kevin.framework.serializer;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by spirit on 2015/10/8.
 * ʵ�����л��ӿ�
 */
public interface Serializer {
    /**
     * ���л�ָ������.
     * @param obj
     */
    byte[] serialize(Object obj);

    /**
     * �����л�����.
     * @param klass
     * @param data
     * @return
     * �����л��Ķ���
     */
    <T> T deserialize(Class<T> klass, byte[] data);

    /**
     * ���л�.
     *
     * @param obj
     * @param outputStream
     * @return
     * д����ֽ���.
     */
    int serialize(Object obj, OutputStream outputStream);

    /**
     * �����л�.
     * @param klass
     * @param inputStream
     * @return
     */
    <T> T deserialize(Class<T> klass, InputStream inputStream);
}
