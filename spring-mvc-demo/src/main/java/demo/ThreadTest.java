package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xxhuang on 2016/5/19.
 */
public class ThreadTest extends Thread {
    int count= 1, number;
    public void run() {
        while(true)
        {
            System.out.println("线程 " + number + ":计数 " + count);
            if(++count== 6) return;
            yield();

        }
    }

    public void main(String args[]) throws InterruptedException {
        ThreadTest ts = new ThreadTest();
        ExecutorService sss = Executors.newCachedThreadPool();
        Lock accountLock = new ReentrantLock();
        sleep(11);
        for(int i = 0;i < 5; i++)
            new ThreadTest().start();
    }
}
