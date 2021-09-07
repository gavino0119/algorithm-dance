package company.boss;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2021/9/7 23:32
 */
public class PrintByThread75 {

    private static int count = 1;
    private static int c = 0;
    private static Object object = new Object();

    static class MyPrintThread extends Thread {
        int index;

        public MyPrintThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                while (count < 76) {
                    synchronized (object) {
                        if (c % 3 == index) {
                            System.out.print(Thread.currentThread().getName() + "打印了: ");
                            for (int i = 0; i < 3; i++) {
                                if (count <= 75) {
                                    System.out.print(count + "");
                                    count++;
                                }
                            }
                            c++;
                            object.notifyAll();
                            System.out.println();
                        } else {
                            object.wait();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyPrintThread(0);
        Thread t2 = new MyPrintThread(1);
        Thread t3 = new MyPrintThread(2);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}
