package com.kevin.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by spirit on 2016/4/22.
 */
public class ProxyTest implements MethodInterceptor {

    private Object srcTarget;

    public ProxyTest(Object srcTarget) {
        this.srcTarget = srcTarget;
    }

    public ProxyTest() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T proxyTarget(T t) {
        Enhancer en = new Enhancer();
        en.setSuperclass(t.getClass());
        en.setCallback(new ProxyTest(t));
        T tt = (T) en.create();
        return tt;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("intercept");
        Object o = method.invoke(srcTarget, args);
        return o;
    }

    class Person{
        void active(String str){
            System.out.println("active"+str);
        }

        void stop(String str){
            System.out.println("active"+str);
        }


    }

    public static void main(String[] args) {
        // 未实现接口的类的代理
        Person p = new ProxyTest().new Person();
        Person person = ProxyTest.proxyTarget(new ProxyTest().new Person());
        person.active("Tom speaking ........");
        person.stop("stop");
        // 实现接口的类的代理
    }
}
