package Lab4;
//  Behållare
//  t.ex. resväska, necessär eller påse

import java.util.ArrayList;

public class Composite extends Component {
    public ArrayList<Component> children = new ArrayList<>();

    Composite(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public void Add(Component c) {
        children.add(c);
    }

    @Override
    public void Remove(Component c) {
        children.remove(c);
    }

    @Override
    public void Display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.print(this.name);
        System.out.println();

        for (Component component:children) {
            component.Display(depth + 2);
            System.out.println();
        }
    }

    @Override
    public int getWeight() {
        int currentWeight = this.weight;
        for (Component component:children) {
            //System.out.println(component.name);
            currentWeight += component.getWeight();
        }
        return currentWeight;
    }

    @Override
    public int getSize() {
        int currSize = 1;
        for(int i = 0; i < this.children.size(); i ++){
            currSize += this.children.get(i).getSize();
        }
        return currSize;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);

        for (Component component:children) {
            stringBuilder.append("\n");
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Composite resvaska = new Composite("Resväska", 10);

        resvaska.Add(new Leaf("Jeans", 2));
        resvaska.Add(new Leaf("T-Shirt", 1));
        resvaska.Add(new Leaf("Skor", 3));

        Composite neccessar = new Composite("Neccesär", 5);

        Leaf borste = new Leaf("Borste", 3);
        Leaf deoderant = new Leaf("Deoderant", 4);
        neccessar.Add(borste);
        neccessar.Add(deoderant);

        Composite pase = new Composite("Påse", 5);
        Leaf tandborste = new Leaf("Tandborste", 2);
        Leaf tandkram = new Leaf("Tandkräm", 1);
        pase.Add(tandborste);
        pase.Add(tandkram);
        resvaska.Add(pase);


        System.out.println("Weight: " + resvaska.getWeight());
        System.out.println(resvaska);

        System.out.println();

        resvaska.Remove(pase);
        System.out.println("Weight: " + resvaska.getWeight());
        System.out.println(resvaska);
    }
}
