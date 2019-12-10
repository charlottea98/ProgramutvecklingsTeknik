import static org.junit.Assert.*;

import org.junit.Test;

public class VecTreeTest {

    @Test
    public void testMethods() {
        VecTree tom = new VecTree();
        assertEquals(0, tom.size());
        assertEquals(-1, tom.minindex());
        assertEquals(-1, tom.maxindex());
        assertNull(tom.get(5));
        assertTrue(tom.sortedValues().isEmpty());
        assertEquals(0, tom.toArray().length);
    }
    @Test
    public void addTest() {
        VecTree spec = new VecTree();
        spec.add(3, "Hej");
        assertEquals(1, spec.size());

        spec.add(5, "Lotta");
        assertEquals(2, spec.size());

        spec.add(5, "Hotta");
        assertEquals(2, spec.size());

        spec.add(1, "Salute");
        assertEquals(3, spec.size());

        spec.add(8, "Kaffe");
        assertEquals(4, spec.size());

        assertEquals(1, spec.minindex());
        assertEquals(8, spec.maxindex());
    }

    @Test
    public void ospecTest() {
        VecTree ospec = new VecTree();

        ospec.add(5);
        assertEquals(1, ospec.size());
        assertEquals(5, ospec.get(0));

        ospec.add(6);
        assertEquals(2, ospec.size());
        assertEquals(6, ospec.get(1));

        ospec.add(7);
        assertEquals(3, ospec.size());
        assertEquals(7, ospec.get(2));

        ospec.add(8);
        assertEquals(4, ospec.size());
        assertEquals(8, ospec.get(3));

        assertNull(get(9));
    }

    @Test
    public void removeTest() {
        VecTree rem = new VecTree();

        rem.add("Rosa");
        rem.add("Black");

        assertEquals("Rosa", rem.get(0));
        rem.removeAt(0);
        assertNull(rem.get(0));

        assertEquals("Black", rem.get(1));
        rem.removeElem("Black");
        assertNull(rem.get(1));
    }
}
