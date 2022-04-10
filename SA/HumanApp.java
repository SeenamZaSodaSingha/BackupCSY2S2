abstract class Human {
    abstract protected void wear();

    protected void walk() {
        System.out.println("Human walks fast");
    }
}

class Man extends Human {
    protected void wear() {
        System.out.println("Man wears trousers.");
    }
}

class Woman extends Human {
    protected void wear() {
        System.out.println("Woman wears a skirt.");
    }
}

class Baby extends Human {
    protected void wear() {
        System.out.println("Baby wears a diaper. ");
    }

    protected void walk() {
        System.out.println("Baby can't walk.");
    }
}

class HumanApp {
    public static void main(String args[]) {
        Man m = new Man();
        Woman w = new Woman();
        Baby b = new Baby();
        m.wear();
        m.walk();
        w.wear();
        w.walk();
        b.wear();
        b.walk();
    }
}