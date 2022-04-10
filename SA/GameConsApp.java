class GameConsole {
    protected String name;
    private String brand;
    public String color;

    public void setBrand(String sb) {
        brand = sb;
    }

    public String getBrand() {
        return brand;
    }
}

class Ps2 extends GameConsole {
    public Ps2(String pn) {
        name = pn;
    }

    public String getName() {
        return name;
    }
}

class GameConsApp {
    public static void main(String args[]) {
        Ps2 p = new Ps2("PlayStation 2");
        p.setBrand("Sony");
        p.color = "black";
        System.out.println("Game Console : " + p.getName());
        System.out.println("Brand : " + p.getBrand());
        System.out.println("color : " + p.color);
    }
}
