package company.boss;

/**
 * @Author yanwg
 * @Date 2021/9/9 16:01
 * @Description:
 */
public class Main03 {
    public static void main(String[] args) {
        LockT lock1 = new LockT();
        LockT lock2 = new LockT();

        Thread ta = new Thread(new JobA(lock1));
        Thread tb = new Thread(new JobB(lock1,lock2));
        Thread tc = new Thread(new JobC(lock2));
        ta.start();
        tb.start();
        tc.start();
    }
}
class JobA implements Runnable{
    private LockT lock;
    public JobA(LockT lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            try{
                System.out.println("A working...start..");
                System.out.println("A working...end..");
                if (lock.getState()>0) {
                    lock.notify();
                }else{
                    lock.setState(1);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
class JobB implements Runnable{
    private LockT lock1;
    private LockT lock2;
    public JobB(LockT lock1, LockT lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    @Override
    public void run() {
        synchronized (lock1){
            try{
                if (lock1.getState() == 0) {
                    lock1.setState(1);
                    lock1.wait();
                }
                System.out.println("B working...start..");
                System.out.println("B working...end..");
                synchronized (lock2){
                    if (lock2.getState()>0) {
                        lock2.notify();
                    }else{
                        lock2.setState(1);
                    }
                }
            }catch (Exception e){}
        }
    }
}
class JobC implements Runnable{
    private LockT lock;
    public JobC(LockT lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            try{
                if (lock.getState() == 0) {
                    lock.setState(1);
                    lock.wait();
                }
                System.out.println("C working...start..");
                System.out.println("C working...end..");

            }catch (Exception e){}
        }
    }
}
class LockT{
    private int state = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
