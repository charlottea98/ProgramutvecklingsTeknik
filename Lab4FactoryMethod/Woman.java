package Lab4FactoryMethod;

public class Woman extends Human{
    String name;
    String gender;

    Woman(String name) {
        this.name = name;
        this.gender = "Kvinna";
    }

    public String toString() {
        return " Jag är " + gender + " och heter " + name;
    }
}
