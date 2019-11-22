package Lab4;

import java.util.Iterator;
import java.util.ArrayList;

public class ImplementIteratable extends Composite implements Iterable<Component> {

    ArrayList<Component> stack;

    ImplementIteratable(String name, int weight){
        super(name, weight);
        this.stack = new ArrayList<Component>();
    }

    private void createStack(Component elem){
        stack.add(elem);
        if(elem instanceof Composite){
            for(int i = 0; i < ((Composite) elem).children.size(); i ++){
                createStack(((Composite) elem).children.get(i));
            }
        }
    }

    private void createStackWidth(int index){
        Component elem = stack.get(index);
        if(stack.get(index) instanceof Composite){
            for(int i = 0; i < ((Composite) elem).children.size(); i ++){
                stack.add(((Composite) elem).children.get(i));
            }
            index ++;
            createStackWidth(index);
        }
        else{
            stack.add(elem);
        }
    }

    public Iterator<Component> iterator() {
        Iterator<Component> iter = new Iterator<>() {

            private int index = 0;
            private int size = getSize();


            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Component next() {
                if(this.hasNext()){
                    index ++;
                    return stack.get(index-1);
                }
                return null;
            }
        };
        return iter;
    }

    public static void main(String[] args){
        /*Composites*/
        ImplementIteratable resvaska = new ImplementIteratable("resväska", 12);
        Composite necessar = new Composite("necessär", 3);
        Composite plastpase = new Composite("plastpåse", 1);

        /* Till plastpåsen */
        Leaf gras = new Leaf( "Medecin", 5);
        Leaf mdma = new Leaf( "MnM's", 1);
        Leaf speed = new Leaf( "koffeinPiller", 2);

        /* Till Necessären */
        Leaf tandborste = new Leaf( "tandborste", 1);
        Leaf gummi = new Leaf( "tandkräm", 2);

        /*Rakt  i väskan*/
        Leaf byxor = new Leaf(  "jeans", 3);
        Composite tShirt = new Composite(  "t-shirt", 2);

        /* i t-shirt*/
        Leaf kniv = new Leaf( "storKniven", 13);

        /* Lägger allt i ordning */
        resvaska.Add(necessar);
        resvaska.Add(plastpase);
        resvaska.Add(tShirt);
        resvaska.Add(byxor);

        plastpase.Add(gras);
        plastpase.Add(mdma);
        plastpase.Add(speed);

        necessar.Add(tandborste);
        necessar.Add(gummi);

        tShirt.Add(kniv);

        resvaska.createStack(resvaska);

        /* Bredden först
        resvaska.stack.Add(resvaska);
        resvaska.createStackWidth(0);
        */


        Iterator iter = resvaska.iterator();

        while(iter.hasNext()){
            System.out.println((iter.next()));
        }

        System.out.println("-------------------------------------------");

        for (Component comp: resvaska) {
            System.out.println("component: " + comp.name);
        }

    }
}

