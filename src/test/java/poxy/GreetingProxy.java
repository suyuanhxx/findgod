package poxy;

/**
 * Created by xxhuang on 2016/6/2.
 * 普通代理模式
 */
public class GreetingProxy implements Greeting {
    private GreetingImpl greeting;
    public GreetingProxy() {
        greeting = new GreetingImpl();
    }

    public void sayHello(String name) {
        before();
        greeting.sayHello(name);
        after();
    }

    private void before() {
        System.out.println(">> Before");
    }
    private void after() {
        System.out.println(">> After");
    }

    public static void main(String[] args) {
        Greeting greeting = new GreetingProxy();
        greeting.sayHello("张三");
    }
}

