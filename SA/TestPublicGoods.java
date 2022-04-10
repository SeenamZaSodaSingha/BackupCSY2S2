class Goods {
    private String name;
    private int amount;
    private double cost;

    public void setName(String n) {
        name = n;
    }

    public void setAmount(int a) {
        amount = a;
    }

    public void setCost(double c) {
        cost = c;
    }

    public void printGoods() {
        System.out.println(name + "amount = " + amount + "cost per unit = " + cost);
    }
}

class TestPublicGoods {
    public static void main(String args[]) {
        Goods g1 = new Goods();
        Goods g2 = new Goods();
        g1.setName("PC");
        g1.setAmount(5);
        g1.setCost(32100.50);
        g1.printGoods();

        g2.setName("NoteBook");
        g2.setAmount(4);
        g2.setCost(64200.25);
        g2.printGoods();
    }
}