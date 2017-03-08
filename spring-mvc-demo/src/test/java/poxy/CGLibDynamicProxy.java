package poxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by xxhuang on 2016/6/2.
 * cglib实现动态代理
 */
public class CGLibDynamicProxy implements MethodInterceptor {
    private static CGLibDynamicProxy instance = new CGLibDynamicProxy();

    public static CGLibDynamicProxy getInstance() {
        return instance;
    }
    public CGLibDynamicProxy() {}

    public <T> T getProxy(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }

    private void before() {
        System.out.println(">> Before");
    }
    private void after() {
        System.out.println(">> After");
    }


    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(target, objects);
        after();
        return result;
    }

    public void main(String[] args) {
        GreetingImpl greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("Jack");
    }


}
