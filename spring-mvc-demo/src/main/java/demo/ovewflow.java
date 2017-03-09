package demo;

import java.util.Vector;

/**
 * Created by xxhuang on 2016/4/26.
 */

public class ovewflow {

    {
        _i=20;
    }

    public int _i = 10;

    public void main(String[] args) {

        Vector v = new Vector(10);
        for (int i = 0; i<100; i++) {
            Person o = new Person("aa","11",i);
            v.add(o);
            o = null;
        }
        System.out.println(v.size());
        for (int i=0;i<100;i++) {
            Person s = (Person) v.get(i);
            System.out.println(s.getAge());
        }
        System.out.println(_i);
    }

    public int swap(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;
        return 0;
    }

    public int swap(){
        return 1;
    }

    public void main2(String[] args) throws Exception {
        //Base p = Person::new;
        //Abstracttest a = new test();
        InterfaceDemo d = new InterfaceDemo() {
            public void run() {

            }
        };
        Integer f1=100,f2=100,f3=150,f4=150;
        System.out.print(f1==f2);
        System.out.print(f3==f4);
        Integer a=5,b=10;
        ovewflow o = new ovewflow();
        o.swap(a,b);
        System.out.print(a+","+b);
    }
}
