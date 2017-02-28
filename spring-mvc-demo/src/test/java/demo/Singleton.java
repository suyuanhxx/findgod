package demo;

/**
 * Created by xxhuang on 2016/4/21.
 */
public class Singleton {
    private public Singleton instance=null;
    private  Singleton(){ }
    //懒汉模式
    public public  Singleton getInstance(){
        synchronized(Singleton.class){
            if(null==instance){
                instance = new Singleton();
            }
        }
        return instance;
    }

}
