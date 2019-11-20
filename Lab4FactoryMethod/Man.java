package Lab4FactoryMethod;

public class Man extends Human{
    String name;
    String gender;

    Man() {
        this.name = "Magnus";
        this.gender = "man";
    }

    public String toString() {
        return " Jag är " + gender + " och heter "+ name;
    }
}
