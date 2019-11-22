package Lab4;
//  Interface

abstract class Component {

    String name;
    int weight;

    Component(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    Component(){

    }

    public abstract void Display(int depth);
    public abstract int getWeight();
    public abstract String toString();
}
