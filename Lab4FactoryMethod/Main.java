package Lab4FactoryMethod;

public class Main {
    public static void main(String[] args) {
        Human billie = Human.create("Billie", "xxxxxx-560x");
        Human anna = Human.create("Anna", "xxxxxx-642x");
        Human magnus = Human.create("Magnus","xxxxxx-011x");
        System.out.println(billie);
        System.out.println(anna);
        System.out.println(magnus);
        Human h = new Human(){};
        System.out.println(h);
        NonBinary Kevin = new NonBinary("Kevin");
        Woman Kevin2 = new Woman("Kevin");
        Man Kevin3 = new Man("Kevin");
        System.out.println(Kevin);
        System.out.println(Kevin2);
        System.out.println(Kevin3);

    }
}
