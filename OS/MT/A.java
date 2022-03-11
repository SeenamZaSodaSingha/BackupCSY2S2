public class A implements Runnable{
    public static void main(String[] args) {
        Tray tray = new Tray();
        Thread t = new Thread(tray.cakeCooked());
        t.start();
    }
}
