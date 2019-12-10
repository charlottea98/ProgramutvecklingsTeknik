/*
import static org.junit.Assert.*;
import org.junit.Test;

public class VecTreeTest {

        @Test
        public void testEmptyVecTree() {
            // testa size(), minIndex(), maxIndex() som ju alla ska ge heltalsvarden
            VecTree<Integer> vecTree = new VecTree<>();
            assertEquals(0, vecTree.size());
            assertEquals(-1, vecTree.minIndex());
            assertEquals(-1, vecTree.maxIndex());
            // Testa get(k) som ska ge null
            assertNull(vecTree.get(0));
            // Anropa toArray() och sortedValues() pa tom vektor och gor lampliga tester pa resultaten.
            assertEquals(0, vecTree.toArray().length);
            assertEquals(0, vecTree.sortedValues().size());
        }

        @Test
        public void testIndexVecTree() {
            //Lagg till element pa specificerade positioner, nagra pa samma index och testa size()
            // efter varje insattning. Testa vardena pa minIndex() och maxIndex().

            VecTree<Integer> vecTree = new VecTree<>();
            assertEquals(0, vecTree.size());
            assertEquals(-1, vecTree.minIndex());
            assertEquals(-1, vecTree.maxIndex());
            vecTree.add(2, 5);
            assertEquals(1, vecTree.size());
            assertEquals(2, vecTree.minIndex());
            assertEquals(2, vecTree.maxIndex());
            vecTree.add(20, 13);
            assertEquals(2, vecTree.size());
            assertEquals(2, vecTree.minIndex());
            assertEquals(20, vecTree.maxIndex());
            vecTree.add(20, 50);
            assertEquals(2, vecTree.size());
            assertEquals(2, vecTree.minIndex());
            assertEquals(20, vecTree.maxIndex());
            vecTree.add(200, 4);
            assertEquals(3, vecTree.size());
            assertEquals(2, vecTree.minIndex());
            assertEquals(200, vecTree.maxIndex());
        }

        @Test
        public void unspecifiedPositionVecTree() {
            // Lagg till element pa ospecificerad position. Testa size() och get() sa att det stammer med forvantade varden.
            // Kom ihag att testa get() med ett index som inte anvands. Den ska ga ge null.

            VecTree<Integer> vecTree = new VecTree<>();
            vecTree.add(5);
            assertEquals(1 ,vecTree.size());
            assertEquals(5, vecTree.get(0));
            vecTree.add(10);
            assertEquals(2, vecTree.size());
            assertEquals(10, vecTree.get(1));

            vecTree.add(1);
            assertEquals(3, vecTree.size());
            assertEquals(1, vecTree.get(2));

            assertNull(vecTree.get(3));

        }

        @Test
        public void removeTestVecTree() {
            // Testa bada varianterna av remove() och gor tester som visar att de fungerar.
            VecTree<Integer> vecTree = new VecTree<>();
            vecTree.add(5);
            vecTree.add(10);
            vecTree.add(12);

            vecTree.removeAt(2);
            assertNull(vecTree.get(2));

            vecTree.removeElem(10);
            assertEquals(1, vecTree.size());
            assertNull(vecTree.get(1));

        }

}

*/

/*
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class VecTreeB<E extends Comparable<E>> extends TreeMap<Integer, E> implements SparseVec<E> {

    VecTreeB(){
        super();
    }

    @Override
    public void add(E elem) {
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
    public void removeElem(E elem) {
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
        List<E> list= new ArrayList<>(this.values());

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            E elem = list.get(index);
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
        VecTreeB<Integer> vecTreeB = new VecTreeB<>();

        vecTreeB.add(0, 5);
        vecTreeB.add(1, 65);
        vecTreeB.add(6, 4);
        vecTreeB.add(7);
        vecTreeB.add(13);

        System.out.println(Integer.valueOf(5));

        System.out.println(vecTreeB.toString());

        for (Object object:vecTreeB.toArray()) {
            System.out.println(object);
        }
        System.out.println();
        System.out.println(vecTreeB.sortedValues());
    }
}

 */
