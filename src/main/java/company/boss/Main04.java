package company.boss;

/**
 * @Author yanwg
 * @Date 2021/9/9 16:35
 * @Description:
 */
public class Main04 {

}

class MyT extends Thread{

    int index;
    Object obj;
    public MyT(int index, Object obj){
        this.index = index;
        this.obj = obj;
    }
    @Override
    public void run(){
        synchronized (obj){

        }
    }
}
