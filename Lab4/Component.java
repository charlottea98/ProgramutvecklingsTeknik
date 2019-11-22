package Lab4;
//  Abstract

abstract class Component {

    String name;
    int weight;

    Component(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    Component(){

    }

    public abstract void Add(Component c);
    public abstract void Remove(Component c);
    public abstract void Display(int depth);
    public abstract int getWeight();
    public abstract int getSize();
    public abstract String toString();
}
