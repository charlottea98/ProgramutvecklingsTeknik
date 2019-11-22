package Lab4.Lab4FactoryMethod;

public class NonBinary extends Human {
    private String name;
    private String gender;

    protected NonBinary() {
        this.name = "Billie";
        this.gender = "icke-binär";
    }
    public String toString() {
        return " Jag är " + gender + " och heter " + name;
    }
}