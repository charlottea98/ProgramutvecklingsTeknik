package Lab4.Lab4FactoryMethod;

public class Man extends Human{
    private String name;
    private String gender;

    protected Man() {
        this.name = "Magnus";
        this.gender = "man";
    }

    public String toString() {
        return " Jag är " + this.gender + " och heter "+ this.name;
    }
}
