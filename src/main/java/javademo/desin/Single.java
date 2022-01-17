package javademo.desin;

/**
 * @Author yanwg
 * @Date 2021/9/7 13:51
 * @Description:
 */
public class Single {
    private volatile Single instance;
    private Single(){}

    public Single getInstance(){
        synchronized (this){
            if (instance == null) {
                synchronized (this){
                    instance = new Single();
                }
            }
        }

        return instance;
    }
}
