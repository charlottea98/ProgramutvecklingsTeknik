package Lab4.Lab4FactoryMethod;

import Lab4.Lab4FactoryMethod.Human;
import Lab4.Lab4FactoryMethod.Man;
import Lab4.Lab4FactoryMethod.NonBinary;
import Lab4.Lab4FactoryMethod.Woman;

public class Main {
    public static void main(String[] args) {
        Human billie = Human.create("xxxxxx-560x");
        Human anna = Human.create("xxxxxx-642x");
        Human magnus = Human.create("xxxxxx-011x");
        System.out.println(billie);
        System.out.println(anna);
        System.out.println(magnus);
        /*
        Human h = new Human(){};
        System.out.println(h);

        NonBinary Kevin = new NonBinary();
        Woman Kevin2 = new Woman();
        Man Kevin3 = new Man();
        System.out.println(Kevin);
        System.out.println(Kevin2);
        System.out.println(Kevin3);

         */







    }
}
