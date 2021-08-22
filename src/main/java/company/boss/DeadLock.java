package company.boss;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2021/8/22 23:18
 */
public class DeadLock {
    public static void main(String[] args) {

        new Thread(A::method, "Thread A").start();

        new Thread(B::method, "Thread B").start();
    }
}

class A {

    public synchronized static void method() {
        System.out.println("method from A");
        try {
            Thread.sleep(3000);//为了让另外一个线程有机会拿到锁
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B {

    public synchronized static void method() {
        System.out.println("method from B");
        try {
            Thread.sleep(3000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class DeadLockCase{
    private static final Object left = new Object();
    private static final Object right = new Object();

    public void leftRight(){
        synchronized (left){
            synchronized (right){
                //doSomethings
            }
        }
    }
    public void rightLeft(){
        synchronized (right){
            synchronized (left){
                //doSomethings
            }
        }
    }
}