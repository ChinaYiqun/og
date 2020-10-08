
/**
 * 同步线程
 */
class SyncThread3 implements Runnable {
    private static int count;

    public SyncThread3() {
        count = 0;
    }

    public synchronized static void method() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void run() {
        method();
    }

    public static void main(String[] args) {
        SyncThread3 s1 = new SyncThread3();
        SyncThread3 s2 = new SyncThread3();
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        t1.start();
        t2.start();
    }
}