package Thread;

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
}