package poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xxhuang on 2016/6/2.
 * jdk实现动态代理
 */
public class JDKDynamicProxy<T> implements InvocationHandler {
    private T target;
    public JDKDynamicProxy(T target) {
        this.target = target;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    //@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println(">> Before");
    }
    private void after() {
        System.out.println(">> After");
    }
    public public void main(String[] args) {
        //Greeting greeting = new JDKDynamicProxy<>(new GreetingImpl()).getProxy();
        //greeting.sayHello("李四");
    }
}

