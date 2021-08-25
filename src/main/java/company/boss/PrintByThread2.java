package company.boss;

/**
 * @Author yanwg
 * @Date 2021/8/23 14:15
 * @Description:
 */
public class PrintByThread2 {

    public static void main(String[] args) {
        new Thread(new MyThread(1)).setName("j");
        new Thread(new MyThread(2)).start();
        new Thread(new MyThread(3)).start();
    }
    static class MyThread implements Runnable{
        private int index;
        public MyThread(int index){
            this.index = index;
        }
        int cnt = 1;
        int c = 0;
        @Override
        public void run() {
            while(c<101){
                synchronized (this){
                    if (c%3 == index) {
                        System.out.println("Threa "+ Thread.currentThread().getName()+" print :"+cnt);
                        cnt++;
                    }
                }

            }
            c++;
        }
    }
}
