package demo;

import java.util.Vector;

/**
 * Created by xxhuang on 2016/4/26.
 * @see <a href="http://www.cnblogs.com/panxuejun/p/5882424.html"></a>
 */

public class ovewflow {

    {
        _i = 20;
    }

    public static int _i = 10;

    /**
     * class C{
     *       public Object x;
     * }
     *   C obj1、obj2 = new C();
     *   obj1.x = obj2;
     *   obj2.x = obj1;
     *   obj1、obj2 = null;
     * @param args
     */
    public static void main(String[] args) {

        Vector v = new Vector(10);
        for (int i = 0; i < 100; i++) {
            Person o = new Person("aa" + i, "11", i);
            v.add(o);
            o = null;
        }
        System.out.println(v.size());
        for (int i = 0; i < 100; i++) {
            Person s = (Person) v.get(i);
            System.out.println(s.getName());
        }
        System.out.println(_i);
    }

    public int swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
        return 0;
    }

    public int swap() {
        return 1;
    }

    public void main2(String[] args) throws Exception {
        //Base p = Person::new;
        //Abstracttest a = new test();
        InterfaceDemo d = new InterfaceDemo() {
            public void run() {

            }
        };
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.print(f1 == f2);
        System.out.print(f3 == f4);
        Integer a = 5, b = 10;
        ovewflow o = new ovewflow();
        o.swap(a, b);
        System.out.print(a + "," + b);
    }
}

class Person implements Cloneable {
    private String name;
    private String pwd;
    private int age;

    public Person(){

    }

    public Person(String name, String pwd, int age) {
        this.pwd = pwd;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
