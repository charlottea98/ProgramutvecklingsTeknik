package Övning3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Klunshittare {
    static int hitta(String ett_drag, HashMap<String, Integer> alla_drag) {

        Integer svar = alla_drag.get(ett_drag);

        if (svar==null) {
            return -1;
        }
        return svar;

    }

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> dragen = new HashMap<String, Integer>();
        dragen.put("Sten", 0);
        dragen.put("Sax", 1);
        dragen.put("Påse", 2);
        System.out.println("Sten, sax eller påse?");

        String svar = inn.nextLine();
        while (!svar.equals("")) {
            System.out.println(hitta(svar, dragen));
            System.out.println("Sten, sax eller påse?");
            svar = inn.nextLine();
        }
    }
}
