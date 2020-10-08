class SyncThread1_2 implements Runnable{
    private int count;

    public SyncThread1_2() {
        count = 0;
    }

    public void countAdd() {
        synchronized(this) {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
    public void printCount() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + " count:" + count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("A")) {
            countAdd();
        } else if (threadName.equals("B")) {
            printCount();
        }
    }

    public static void main(String[] args) {
        SyncThread1_2 syncThread = new SyncThread1_2();
        //SyncThread syncThread2 = new SyncThread();

        Thread t1 = new Thread(syncThread,"A");
        Thread t2 = new Thread(syncThread,"B");
        t1.start();
        t2.start();
        //System.out.println(syncThread2.getCount());
    }
}