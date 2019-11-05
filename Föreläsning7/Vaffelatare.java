package Föreläsning7;

public class Vaffelatare extends Thread {

    private String namn;
    private int antalV = 0;
    private Upplaggsfat fat;

    public Vaffelatare(String namn, Upplaggsfat fat) {
	this.namn = namn;
	this.fat = fat;
    }
	
    public void run() {
	while (!fat.vafflorSlut()) {
	    int vaffla = fat.tag();
	    if (vaffla == 0)
		break;
	    System.out.println(namn + " tar våffla "+vaffla);
	    Vaffelkalas.slumpvanta(Vaffelkalas.AT_TID);
	    System.out.println(namn + " har ätit upp våffla "+vaffla);
	    antalV++;
	}
	System.out.println(namn + " ätit klart");
    }

    public String toString () {
	return namn + " fick " + antalV + " våfflor";
    }
}