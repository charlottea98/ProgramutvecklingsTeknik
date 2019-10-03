package Lab0;

class Person {
    // Klassdefinition
    private String name;    // Deklaration av instansvariabler
    private int age;


    public static void main(String[] args) {

        Person p1 = new Person("Lotta", 20);
        Person p2 = new Person("Mood", 22);
        System.out.println(p1);


        // Behöver inte skriva .toString eftersom java kommer automatiskt skriva ut objekt som
        // toString ifall metoden finns. Annars blir det hashkod värden av objekten.
    }


    private Person(String nameIn, int ageIn){
        // Konstruktor
        name = nameIn;
        age = ageIn;
    }

    public String toString(){
        return ("Namn: " + getName() + " \nÅlder: " + getAge());
    }

    private String getName(){
        return name;
    }

    private int getAge(){
        // Instansmetod
        return age;
    }

}

