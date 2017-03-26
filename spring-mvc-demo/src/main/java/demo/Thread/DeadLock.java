package demo.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangxiaoxu on 26/03/2017.
 * 多线程死锁的产生
 * 当一个线程永远地持有一个锁，并且其他线程都尝试去获得这个锁时，那么它们将永远被阻塞。
 * 如果线程A持有锁L并且想获得锁M，线程B持有锁M并且想获得锁L，那么这两个线程将永远等待下去，这种情况就是最简单的死锁形式。
 * 检测死锁产生：
 * 1、先找到可疑进程，jps获得当前Java虚拟机进程的pid
 * 2、使用jstack打印堆栈，jstack打印内容的会报告发现了一个死锁，同时也能够通过分析waiting，locked得出结论
 * 避免死锁的方式
 * 1、让程序每次至多只能获得一个锁。当然，在多线程环境下，这种情况通常并不现实
 * 2、设计时考虑清楚锁的顺序，尽量减少嵌在的加锁交互数量
 * 3、既然死锁的产生是两个线程无限等待对方持有的锁，那么只要等待时间有个上限不就好了。当然synchronized不具备这个功能，但是我们可以使用Lock类中的tryLock方法去尝试获取锁，这个方法可以指定一个超时时限，在等待超过该时限之后变回返回一个失败信息
 * @see ReentrantLock#tryLock(long timeout, TimeUnit unit) 获取锁
 */
public class DeadLock {
    private final Object left = new Object();
    private final Object right = new Object();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void leftRight() throws Exception {
        synchronized (left) {
            Thread.sleep(2000);
            synchronized (right) {
                System.out.println("leftRight end!");
            }
        }
    }

    public void rightLeft() throws Exception {
        synchronized (right) {
            Thread.sleep(2000);
            synchronized (left) {
                System.out.println("rightLeft end!");
            }
        }
    }

    public void lock1() throws Exception {
        if(lock1.tryLock(1000, TimeUnit.MILLISECONDS)){
            Thread.sleep(2000);
            if(lock2.tryLock(1000,TimeUnit.MILLISECONDS)) {
                System.out.println("lock1 end!");
            }
        }
    }

    public void lock2() throws Exception {
        if(lock2.tryLock(1000, TimeUnit.MILLISECONDS)){
            Thread.sleep(2000);
            if(lock1.tryLock(1000,TimeUnit.MILLISECONDS)) {
                System.out.println("lock2 end!");
            }
        }
    }


    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Thread1 thread1 = new Thread1(deadLock);
        Thread2 thread2 = new Thread2(deadLock);
        thread1.start();
        thread2.start();

        /**
         * 上面代码，两个线程会相互竞争锁，会产生死锁
         * 下面代码通过Lock#tryLock()，超时机制能够避免死锁的产生
         */
//        Thread3 thread3 = new Thread3(deadLock);
//        Thread4 thread4 = new Thread4(deadLock);
//        thread3.start();
//        thread4.start();
    }


}

class Thread1 extends Thread {
    private DeadLock dl;

    public Thread1(DeadLock dl) {
        this.dl = dl;
    }

    @Override
    public void run() {
        try {
            dl.leftRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends Thread {
    private DeadLock dl;

    public Thread2(DeadLock dl) {
        this.dl = dl;
    }

    @Override
    public void run() {
        try {
            dl.rightLeft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Thread3 extends Thread {
    private DeadLock dl;

    public Thread3(DeadLock dl) {
        this.dl = dl;
    }

    @Override
    public void run() {
        try {
            dl.lock1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread4 extends Thread {
    private DeadLock dl;

    public Thread4(DeadLock dl) {
        this.dl = dl;
    }

    @Override
    public void run() {
        try {
            dl.lock2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
