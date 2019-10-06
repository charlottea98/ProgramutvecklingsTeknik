package Lab0;

public class Randomperson {
    // Klassdefinition
    String name;    // Deklaration av instansvariabler
    int age;
    static String[] names = {"Lotta", "Mood", "Emil", "Sven", "Hampus", "Emmanuel", "Anna", "Elin", "Gabriella", "Kiwi",
            "Daniel", "Saga", "Judith", "Lisa", "Ronja"};
    // Non-static fields can not be referenced from a static context. Since main is static and we want to use names
    // in main, then names should be static

    public static void main(String[] args) {

        int randomnumber = (int)(Math.random()*(names.length-1)) + 1;
        System.out.println(randomnumber);

        Randomperson[] objects = new Randomperson[randomnumber];

        int counter = 0;
        for (int i = 0; i < randomnumber; i++) {
            objects[counter++] = new Randomperson();
        }

        for (Randomperson p : objects) {
            System.out.println(p);
        }

        System.out.println("\n ---Random Person med input---");
        Randomperson p2 = new Randomperson("Olli", 130);
        System.out.println(p2);


        // Behöver inte skriva .toString eftersom java kommer automatiskt skriva ut objekt som
        // toString ifall metoden finns. Annars blir det hashkod värden av objekten.
    }


    Randomperson() {
        // Konstruktor

        name = names[(int)(Math.random()*(names.length-1))];
        age = (int)(Math.random()*100);
    }


    private Randomperson(String nameIn, int ageIn){
        // Konstruktor
        name = nameIn;
        age = ageIn;
    }


    public String toString(){
        return ("Namn: " + getName() + ", Ålder: " + getAge());
    }


    String getName(){
        // Instansmetod
        return name;
    }

    int getAge(){
        // Instansmetod
        return age;
    }

}
