package OS.Lab10;
import java.util.concurrent.Semaphore;
class SharedNum2 { // semaphore
    private int val = 0;
    private Semaphore mutex;
    SharedNum2() {
        mutex = new Semaphore(1);
        val = 0;
    }

    void increment() {
        try {
        mutex.acquire();
        val++;
        mutex.release();
        } catch (InterruptedException ie) { }
    }

    int getVal() { return val; }
}
