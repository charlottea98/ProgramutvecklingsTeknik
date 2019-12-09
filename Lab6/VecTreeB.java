package Lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class VecTreeB extends TreeMap<Integer, Comparable> implements SparseVec {

    VecTreeB(){
        super();
    }

    @Override
    public void add(Comparable elem) {
        int counter = 0;
        while(true){
            if(!this.containsKey(counter)){
                this.put(counter, elem);
                return;
            }
            counter ++;
        }
    }

    @Override
    public void add(int pos, Comparable elem) {
        if (pos<0){
            this.put(0, elem);
        }
        else {
            this.put(pos, elem);
        }
    }

    @Override
    public int indexOf(Comparable elem) {
        int number = -1;
        for (Object object:this.keySet().toArray()) {
            if (this.get(object).equals(elem)){
                number = (int)object;
                return number;
            }
        }
        return number;
    }

    @Override
    public void removeAt(int pos) {
        this.remove(pos);

    }

    @Override
    public void removeElem(Comparable elem) {
        int index = this.indexOf(elem);
        this.removeAt(index);
    }

    @Override
    public int size() {
        int count = 0;
        for (Object object:this.keySet()) {
            count+=1;
        }
        return count;
    }

    @Override
    public int minIndex() {
        if (this.isEmpty()){
            return -1;
        }
        else {
            return this.firstKey();
        }
    }

    @Override
    public int maxIndex() {
        try {
            return this.lastKey();
        }
        catch (NoSuchElementException e){
            return -1;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(int i: this.keySet()){
            string.append(i +" : "+ this.get(i).toString() + "\n");
        }
        return string.toString();
    }

    @Override
    public Comparable get(int pos) {
        return this.get((Integer)pos);
    }

    @Override
    public Object[] toArray() {
        Object[] arrayList = new Object[this.maxIndex()+1];
        for (int i = 0; i < this.maxIndex()+1; i++) {
            arrayList[i] = this.get(i);
        }
        return arrayList;
    }


    @Override
    public List sortedValues() {
        List<Comparable> list= new ArrayList<>(this.values());

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            Comparable elem = list.get(index);
            if (elem.compareTo(list.get(index+1))>=1){
                //System.out.println(elem + "     " + list.get(i+1));
                //System.out.println(list);
                list.set(index, list.get(index+1));
                list.set(index+1, elem);
                i=0;
                index=0;
            }
            else {
                index++;
                i = index;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        VecTreeB vecTreeB = new VecTreeB();
        vecTreeB.add(0, 5);
        vecTreeB.add(1, 65);
        vecTreeB.add(6, 5);
        vecTreeB.add(7);

        System.out.println(vecTreeB.toString());
        System.out.println();

        for (Object object:vecTreeB.toArray()) {
            System.out.println(object);
        }
        System.out.println();
        System.out.println(vecTreeB.sortedValues());
    }
}
