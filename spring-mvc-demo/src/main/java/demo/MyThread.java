package demo;

/**
 * Created by xxhuang on 2016/4/25.
 */
public class MyThread implements Runnable
{
    private String name;
    private Object prev;
    private Object self;

    private MyThread(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThread pa = new MyThread("A", c, a);
        MyThread pb = new MyThread("B", a, b);
        MyThread pc = new MyThread("C", b, c);

        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        //Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}
