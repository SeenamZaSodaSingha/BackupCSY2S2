public class SharedNum5 {
    private int val = 0;
    Object lock;

    SharedNum5() {
        val = 0;
    }

    synchronized int getVal() {
        try { wait(); } catch (InterruptedException ie) { }
    return val;
} // getVal

    synchronized void setVal(int x) {
        val = x;
        notifyAll();
    } // setVal
}
