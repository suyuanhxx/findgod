package demo;

/**
 * Created by xxhuang on 2016/4/25.
 */

public class InnerClassDemo {
    private class inner implements Base{
        public void prints(){
            System.out.print("rtss");
        }
    }

    public inner getInstance(){
        return new inner();
    }

    public void finalize(){

    }

    public void main(String[] args) {
        InnerClassDemo s = new InnerClassDemo();
        //InnerClassDemo.inner = s.getInstance();//compile error
        Base dd = s.getInstance();
        dd.prints();
    }
}
