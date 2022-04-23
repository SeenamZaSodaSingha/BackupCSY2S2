class SharedNum3 { // synchronized method
    private int val = 0;
    // SharedNum3() { val = 0; }
    synchronized void increment() {
    val++;
    }
    int getVal() { return val; }
}
