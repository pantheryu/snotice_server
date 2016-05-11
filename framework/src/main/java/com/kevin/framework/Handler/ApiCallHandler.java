package com.kevin.framework.Handler;

import com.kevin.framework.Handler.engine.ServiceEngine;
import com.kevin.framework.error.ApiErrorCodes;
import com.kevin.framework.error.ApiException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by spirit on 2015/10/12.
 */
public class ApiCallHandler {
    private Object service;
    private ServiceEngine serviceEngine = ServiceEngine.getInstance();
    public void setService(Object service) {
        this.service = service;
    }

    public Object execute(String apiName, Method method, Object parameter) {

        try {
            service = serviceEngine.getService(apiName);
            return method.invoke(service, parameter);

        } catch (IllegalAccessException e) {
            throw new ApiException(ApiErrorCodes.SYSTEM_ERROR.getValue(), "exception thrown when call api:" + apiName + "-" + e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ApiException(ApiErrorCodes.SYSTEM_ERROR.getValue(), "exception thrown when call api:" + apiName + "-" + e.getMessage(), e);
        } catch (InvocationTargetException e) {
            if(e.getTargetException() instanceof ApiException)
                throw (ApiException) e.getTargetException();
            else
                throw new ApiException(e.getTargetException());
        }
    }
}
