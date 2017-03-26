package demo.Thread;

public class TestThread {
    private boolean bShouldSub=true;
    public synchronized void sub(){
        if(!bShouldSub){
            try
            {
                this.wait();  
            } catch (InterruptedException e) 
            {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }
        }
               
        for(int j=0;j<10;j++)  
        {  
            System.out.println("sub" + j);  
        }  
        bShouldSub = true;  
        this.notify(); 
        
    }
    public synchronized void main(){
        if(bShouldSub)  
        {
            try {  
                this.wait();  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }
        }
        for(int j=0;j<100;j++)  
        {  
            System.out.println("main"+j);  
        }  
        bShouldSub = false;               
        this.notify();
    }

    public static void main(String[] args) {
        final TestThread thread = new TestThread();
        new Thread(new Runnable(){
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