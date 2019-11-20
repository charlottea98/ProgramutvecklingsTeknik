package Lab4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LitenFilInlasning {
    public static void main(String[] args) {
	boolean ok = false;
		
	Scanner fil = null;
	while(!ok){
	    try{
			System.out.println("Skriv filnamn");
			Scanner sc = new Scanner(System.in);
			String filnamn = sc.nextLine();
			fil = new Scanner(new File(filnamn));
			ok = true;
	    }catch(IOException e){
		System.out.println("Filen finns ej, nytt filnamn: ");
	    }

	}
	while(fil.hasNext()){
	    System.out.println(fil.nextLine());
	}
	System.out.println("Klar");
    }
}
