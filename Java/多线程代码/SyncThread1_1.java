/**
 * 同步线程
 */
class SyncThread1_1 implements Runnable {
    private static int count;

    public SyncThread1_1() {
        count = 0;
    }

    public  void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        SyncThread1_1 syncThread11 = new SyncThread1_1();
        //SyncThread syncThread2 = new SyncThread();

        Thread t1 = new Thread(syncThread11);
        Thread t2 = new Thread(syncThread11);
        t1.start();
        t2.start();
        //System.out.println(syncThread2.getCount());

    }
}