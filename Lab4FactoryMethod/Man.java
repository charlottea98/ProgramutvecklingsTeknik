package Lab4FactoryMethod;

public class Man extends Human{
    String name;
    String gender;

    protected Man(String name) {
        this.name = "Magnus";
        this.gender = "man";
    }

    public String toString() {
        return " Jag är " + gender + " och heter "+ name;
    }
}
