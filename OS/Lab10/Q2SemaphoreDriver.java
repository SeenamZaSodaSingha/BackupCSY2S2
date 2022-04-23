package OS.Lab10;

public class Q2SemaphoreDriver {
    public static void main(String[] args) {
        int nThread = 100000; // hundred thousands
        SharedNum2 sn = new SharedNum2();
        int v = 2;
        // SharedNum2 sn = new SharedNum3(); int v = 3;
        // SharedNum2 sn = new SharedNum4(); int v = 4;
        Thread[] thr = new Thread[nThread];
        for (int i = 0; i < nThread; i++) {
            thr[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    sn.increment();
                }
            });
            thr[i].start(); /* A */
        }
        for (int i = 0; i < nThread; i++) {
            try {
                thr[i].join();
            } catch (InterruptedException ie) {
            }
        }
        if (sn.getVal() < nThread) {
            System.out.printf("v1 val = %d Not %d\n", sn.getVal(), 100000);
        } else {
            System.out.printf("v1 good job! %d \n");
        }
    }
}