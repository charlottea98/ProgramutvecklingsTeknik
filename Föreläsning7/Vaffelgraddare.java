package Föreläsning7;

public class Vaffelgraddare extends Thread{

    private Upplaggsfat fat;

    Vaffelgraddare(Upplaggsfat fat) {
	this.fat = fat;
    }

    public void run(){
	for(int vaffla=1; vaffla <= Vaffelkalas.ANTAL_VAFFLOR; vaffla++){
	    System.out.println("Gräddar våffla "+vaffla);
	    Vaffelkalas.slumpvanta(Vaffelkalas.GRADDNINGSTID);
	    fat.lagg(vaffla);
	    System.out.println("Gräddat våffla "+vaffla);
	}
    }
}
