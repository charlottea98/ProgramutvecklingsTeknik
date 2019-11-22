package Lab4.Lab4FactoryMethod;

public class Woman extends Human{
    private String name;
    private String gender;

    protected Woman() {
        this.name = "Anna";
        this.gender = "Kvinna";
    }

    public String toString() {
        return " Jag är " + gender + " och heter " + name;
    }
}
