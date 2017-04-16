package demo.Thread;


import org.junit.Test;

/**
 * Created by huangxiaoxu on 31/03/2017.
 */
public class VolatitleTest {

    private volatile boolean stop = false;


    public void fun(){
        while(!stop){
            System.out.println("test");
        }
    }

    @Test
    public void threadTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                fun();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                stop=true;
            }
        }).start();
    }

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }


    public static void main(String[] args) {
        final VolatitleTest test = new VolatitleTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
