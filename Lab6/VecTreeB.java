package Lab6;
import java.util.*;

public class VecTreeB<E extends Comparable<E>> extends TreeMap<Integer, E> implements SparseVec<E> {

    @Override
    public void add(E elem) {
        // hitta forsta lediga plats
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
    public void add(int pos, E elem) {
        if (pos<0){
            this.put(0, elem);
        }
        else {
            this.put(pos, elem);
        }
    }

    @Override
    public int indexOf(E elem) {
        int number = -1;
        for (Object object:this.keySet()) {
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
    public void removeElem(E elem) {
        int index = this.indexOf(elem);
        this.removeAt(index);
    }

    @Override
    public int size() {
        int counter = 0;
        for (Object object:this.keySet()) {
            counter += 1;
        }
        return counter;
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
            String text = i + " : " + this.get(i).toString() + "\n";
            string.append(text);
        }
        return string.toString();
    }

    @Override
    public E get(int pos) {
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
    public List<E> sortedValues() {
        List<E> list= new ArrayList<>(this.values()); //inga null

        Collections.sort(list);
        /*
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

         */
        return list;
    }
}

