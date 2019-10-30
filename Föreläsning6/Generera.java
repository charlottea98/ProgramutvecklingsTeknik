package Föreläsning6;

import java.util.*;

class Generera {
    public static void main(String[] a) {
        HashSet<Integer> hset = new HashSet<Integer>();
        int goal = 50;
        int range = 100;
        if (a.length > 0)
            goal = Integer.parseInt(a[0]);
        if (a.length > 1)
            range = Integer.parseInt(a[1]);
        int tries = 0;
        while (hset.size() < goal) {
            int next = (int) (Math.random() * range + 1);
            hset.add(next);
            tries++;
        }
        System.out.println();
        System.out.println( tries + " numbers were tried");
        System.out.println("The " + goal + " different numbers are ");
        for (int i:hset)
            System.out.print(i + " ");
        System.out.println();
    }
}