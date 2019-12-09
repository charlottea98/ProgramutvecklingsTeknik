package Lab6;

import java.util.*;

public class VecTree implements SparseVec {

    TreeMap<Integer, Comparable> treeMap;

    VecTree(){
        this.treeMap = new TreeMap<>();

    }

    @Override
    public void add(Comparable elem) {
        int counter = 0;
        while(true){
            if(!this.treeMap.containsKey(counter)){
                this.treeMap.put(counter, elem);
                return;
            }
            counter ++;
        }
    }

    @Override
    public void add(int pos, Comparable elem) {
        if (pos<0){
            this.treeMap.put(0, elem);
        }
        else {
            this.treeMap.put(pos, elem);
        }
    }

    @Override
    public int indexOf(Comparable elem) {
        int number = -1;
        for (Object object:this.treeMap.keySet().toArray()) {
            if (this.treeMap.get(object).equals(elem)){
                number = (int)object;
                return number;
            }
        }
        return number;
    }

    @Override
    public void removeAt(int pos) {
        this.treeMap.remove(pos);

    }

    @Override
    public void removeElem(Comparable elem) {
        int index = this.indexOf(elem);
        this.removeAt(index);
    }

    @Override
    public int size() {
        return this.treeMap.size();
    }

    @Override
    public int minIndex() {
        if (this.treeMap.isEmpty()){
            return -1;
        }
        else {
            return this.treeMap.firstKey();
        }
    }

    @Override
    public int maxIndex() {
        try {
            return this.treeMap.lastKey();
        }
        catch (NoSuchElementException e){
            return -1;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(int i: this.treeMap.keySet()){
            string.append(i +" : "+ this.treeMap.get(i).toString() + "\n");
        }
        return string.toString();
    }

    @Override
    public Comparable get(int pos) {
        return this.treeMap.get(pos);
    }

    @Override
    public Object[] toArray() {
        Object[] arrayList = new Object[this.maxIndex()+1];
        for (int i = 0; i < this.maxIndex()+1; i++) {
            arrayList[i] = this.treeMap.get(i);
        }
        return arrayList;
    }


    @Override
    public List sortedValues() {
        List<Comparable> list= new ArrayList<>(this.treeMap.values());

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
        VecTree vecTree = new VecTree();

        vecTree.add(2, 2);

        vecTree.add(5, 5);

        vecTree.add(1, 1);

        vecTree.add(7, 7);

        vecTree.add(4, 4);

        System.out.println(vecTree.toString());
        System.out.println();

        for (Object object:vecTree.toArray()) {
            System.out.println(object);
        }
        System.out.println();

        System.out.println(vecTree.sortedValues());

        System.out.println(vecTree.size());
        System.out.println(vecTree.treeMap.keySet().size());
    }

}
