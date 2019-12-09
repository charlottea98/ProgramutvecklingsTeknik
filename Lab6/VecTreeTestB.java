package Lab6;

/*
import static org.junit.Assert.*;
import org.junit.Test;

public class VecTreeTestB {

        @Test
        public void testEmptyVecTree() {
            // testa size(), minIndex(), maxIndex() som ju alla ska ge heltalsvarden
            VecTreeB vecTree = new VecTreeB();
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

            VecTreeB vecTree = new VecTreeB();
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

            VecTreeB vecTree = new VecTreeB();
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
            VecTreeB vecTree = new VecTreeB();
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