package Lab4FactoryMethod;

class Woman extends Human{
    String name;
    String gender;

    protected Woman(String name) {
        this.name = name;
        this.gender = "Kvinna";
    }

    public String toString() {
        return " Jag är " + gender + " och heter " + name;
    }
}
