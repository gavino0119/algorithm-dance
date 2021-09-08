package company.boss;

/**
 * @author ywg
 * @version 1.0
 * @description 线程B依赖A，C依赖B  设计
 * @date 2021/9/8 23:20
 */
public class ThreadABCDependent {
    public static void main(String[] args) {

        LockFlag lockFlag1 = new LockFlag();
        LockFlag lockFlag2 = new LockFlag();

        new Ajob(lockFlag1).start();
        new Bjob(lockFlag1, lockFlag2).start();
        new Cjob(lockFlag2).start();
    }

}

class LockFlag {
    private int flag = 0;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
class Ajob extends Thread {
    private LockFlag lockFlag;

    public Ajob(LockFlag lockFlag) {
        this.lockFlag = lockFlag;
    }

    @Override
    public void run() {
        synchronized (lockFlag) {
            try {
                System.out.println("threadA starting ");
                if (lockFlag.getFlag() > 0) {
                    lockFlag.notify();
                } else {
                    lockFlag.setFlag(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Bjob  extends  Thread{

    private LockFlag lockFlag1;
    private LockFlag lockFlag2;

    public Bjob(LockFlag lockFlag1, LockFlag lockFlag2) {
        this.lockFlag1 = lockFlag1;
        this.lockFlag2 = lockFlag2;
    }

    @Override
    public void run() {
        synchronized (lockFlag1) {

            try {
                if (lockFlag1.getFlag() == 0) {
                    lockFlag1.setFlag(1);
                    lockFlag1.wait();
                }
                System.out.println("ThreadB starting");

                synchronized (lockFlag2) {
                    if (lockFlag2.getFlag() > 0) {
                        lockFlag2.notify();
                    } else {
                        lockFlag2.setFlag(1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class Cjob extends Thread {
    private LockFlag lockFlag2;

    public Cjob(LockFlag lockFlag2) {
        this.lockFlag2 = lockFlag2;
    }

    @Override
    public void run() {
        synchronized (lockFlag2) {
            try {
                if (lockFlag2.getFlag() == 0) {
                    lockFlag2.setFlag(1);
                    lockFlag2.wait();
                }
                System.out.println("ThreadC starting");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
