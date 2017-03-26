package demo;

/**
 * Created by xxhuang on 2016/4/25.
 * 内部类 && 静态内部类
 */

public class InnerClass {
    class Inner  {
        public void prints() {
            System.out.print("rtss");
        }
    }
    static class Inner2 {
        public void prints() {
            System.out.print("rtss");
        }
    }

    public Inner getInstance() {
        return new Inner();

    }

    public void main(String[] args) {
        Inner s = new InnerClass().new Inner();
        Inner2 s2 = new Inner2();
        InnerClass.Inner inner = new InnerClass().getInstance();//compile error
        s.prints();

    }
}
