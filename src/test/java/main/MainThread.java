package main;

import Thread.TestThread;

public class MainThread {

     public static void main(String []args){
        final TestThread thread = new TestThread();
        new java.lang.Thread(new Runnable(){
            public void run(){
                for(int i=0;i<2;i++)
                {
                    thread.sub();
                }
            }
        }).start();
        for(int i=0;i<2;i++)
        {
            thread.main();
        }
     }
}
