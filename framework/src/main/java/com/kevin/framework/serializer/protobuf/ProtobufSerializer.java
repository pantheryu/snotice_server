package com.kevin.framework.serializer.protobuf;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.kevin.framework.error.ApiErrorCodes;
import com.kevin.framework.error.ApiException;
import com.kevin.framework.serializer.Serializer;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by spirit on 2015/10/8.
 */
public class ProtobufSerializer implements Serializer {
    private Map<Class, Schema> cachedSchemas = new HashMap<Class, Schema>();

    /**
     * Optimal buffer size for serializing messages
     */
    private int optimalBufferSize;

    /**
     * Local serialization buffer for each thread
     */
    private ThreadLocal<LinkedBuffer> linkedBuffer = new ThreadLocal<LinkedBuffer>() {
        @Override
        protected LinkedBuffer initialValue() {
            return LinkedBuffer.allocate(optimalBufferSize);
        }
    };

    /**
     * Default constructor
     *
     * @param optimalBufferSize
     *            Buffer size in bytes that is able to hold the largest message
     *            possible in this RPC protocol If you will provide a value that
     *            is too small, several sequential linked buffers will be
     *            created automatically (and the thing will be a little slower
     *            with that)
     */
    public ProtobufSerializer(int optimalBufferSize) {
        this.optimalBufferSize = optimalBufferSize;
    }

    public ProtobufSerializer() {
        this(1024 * 512);
    }


    public byte[] serialize(Object obj) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            serialize(obj, output);

            return output.toByteArray();
        }finally {
            try {
                output.close();
            } catch (IOException e) {
            }
        }
    }

    public <T> T deserialize(Class<T> klass, byte[] data) {
        ByteArrayInputStream input = new ByteArrayInputStream(data);
        try {
            return deserialize(klass, input);
        }finally {
            try {
                input.close();
            } catch (IOException e) {
            }
        }
    }

    @SuppressWarnings({ "rawtypes" })
    private Schema getSchema(Class klass) {

        Schema schema = this.cachedSchemas.get(klass);
        if(schema == null) {
            try {
//                schema = (Schema) klass.newInstance();
                  schema = RuntimeSchema.getSchema(klass);
            } catch (Exception e) {
                throw new ApiException(ApiErrorCodes.SYSTEM_ERROR.getValue(), "instantiate class failed:" + e.getMessage(), e);
            }
            this.cachedSchemas.put(klass, schema);
        }

        return schema;
    }

    public int serialize(Object obj, OutputStream outputStream) {
        LinkedBuffer linkedBuffer = this.linkedBuffer.get();
        linkedBuffer.clear();

        Schema schema = getSchema(obj.getClass());
        try {
            return ProtobufIOUtil.writeTo(outputStream, obj, schema, linkedBuffer);
        }catch(Exception e) {
            throw new ApiException(ApiErrorCodes.SYSTEM_ERROR.getValue(), "serialize error:" + e.getMessage(), e);
        }
    }

    public <T> T deserialize(Class<T> klass, InputStream inputStream) {

        LinkedBuffer linkedBuffer = this.linkedBuffer.get();
        linkedBuffer.clear();

        Schema schema = getSchema(klass);
        try {
            T obj = klass.newInstance();
            ProtobufIOUtil.mergeFrom(inputStream, obj,
                    schema, linkedBuffer);
            return obj;
        }catch(Exception e) {
            throw new ApiException(ApiErrorCodes.SYSTEM_ERROR.getValue(), "deserialize error:" + e.getMessage(), e);
        }
    }
}
