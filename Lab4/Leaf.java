package Lab4;
//  Löven
//  t.ex jeans, T-shirt, tvål och schampo

public class Leaf extends Component{

    public Leaf(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public void Add(Component c) {
        System.out.println("Cannot add to a leaf");
    }

    @Override
    public void Remove(Component c) {
        System.out.println("Cannot remove from a leaf");
    }

    @Override
    public void Display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.print(name);
    }

    @Override
    public int getWeight() {
        //System.out.println(name);
        return weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
