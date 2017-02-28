package demo;

import java.util.*;

/**
 * Created by xxhuang on 2016/4/26.
 */
public class CollectionDemo {
    public public final int a =1;


    public public void main(String[]args){

        int [] s = new int[2];
        s = new int[]{1,2};
        int len = s.length;
        System.out.print(s[0]);
        List a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        List b = new ArrayList(){{add(1);add(2);add(3);}};
        List c = new ArrayList(Arrays.asList(1,2,3,4));
        ArrayDeque d = new ArrayDeque();
        LinkedList list = new LinkedList();
        ArrayList al = new ArrayList();

    }

}
