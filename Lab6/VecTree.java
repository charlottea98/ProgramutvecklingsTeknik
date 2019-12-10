package Lab6;

import java.util.*;

public class VecTree<E extends Comparable<E>> implements SparseVec<E> {

    TreeMap<Integer, E> treeMap;

    VecTree(){
        this.treeMap = new TreeMap<>();
    }

    @Override
    public void add(E elem) {
        // hitta första lediga plats
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
    public void add(int pos, E elem) {
        if (pos<0){
            this.treeMap.put(0, elem);
        }
        else {
            this.treeMap.put(pos, elem);
        }
    }

    @Override
    public int indexOf(E elem) {
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
    public void removeElem(E elem) {
        int index = this.indexOf(elem);
        this.removeAt(index);   //testa -1
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
            String text = i + " : " + this.treeMap.get(i).toString() + "\n";
            string.append(text);
        }
        return string.toString();
    }

    @Override
    public E get(int pos) {
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
    public List<E> sortedValues() {
        List<E> list= new ArrayList<>(this.treeMap.values()); //inga null

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            E elem = list.get(index);
            if (elem.compareTo(list.get(index+1))>=1){
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

}
