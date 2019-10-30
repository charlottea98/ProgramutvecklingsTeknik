package Övning3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Person19 implements Comparable<Person19> {
    private long pnr;
    private String namn;

    private Person19 (long p, String n) {
        pnr = p;
        namn = n;
    }

    public String toString() {
        return namn + " " + pnr;
    }

    public int compareTo(Person19 other) {
        if (pnr==other.pnr){
            return namn.compareTo(other.namn);
        }
        if (pnr < other.pnr){
            return -1;
        }
        else if (pnr > other.pnr) {
            return 1;
        }
        else {
            return 0;
        }
    }


    public static void main(String[] args) {
        ArrayList<Person19> osorterade = new ArrayList<>();

        TreeMap<Person19, Person19> sorterade = new TreeMap<>();
        for (int i = 0; i < 20; i++) {
            Person19 ny = new Person19((long) (Math.random()*9e11+1e11), (char)('A'+i)+"");
            sorterade.put(ny, ny);
            osorterade.add(ny);
        }

        for (Person19 p:sorterade.values()) {
            System.out.println(p);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }

        //osorterade.sort(Person19::compareTo);

        Collections.sort(osorterade);
        for (Person19 p:osorterade) {
            System.out.println(p);
        }
    }
}
