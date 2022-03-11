public class B implements Runnable{
    public static void main(String[] args) {
        Tray tray = new Tray();
        Thread t = new Thread(tray.buy());
        t.start();
    }
}
