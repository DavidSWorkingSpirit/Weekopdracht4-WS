package pizzaria;

import java.util.Random;

public class Magazijn {
	static Random randy = new Random();
	
	static int aantalHam;
	static int aantalKaas;
	static int aantalPaprika;
	static int aantalSalami;
	static int aantalUi;
	
	public String magazijnVullen() {
		aantalHam = randy.nextInt(10) + 1;
		aantalKaas = randy.nextInt(10) + 1;
		aantalPaprika = randy.nextInt(10) + 1;
		aantalSalami = randy.nextInt(10) + 1;
		aantalUi = randy.nextInt(10) + 1;
		
		return "Het magazijn is gevuld!";
	}
	
	public String magazijnCheck() {
		System.out.println("Ham: " + Magazijn.aantalHam);
		System.out.println("Kaas: " + Magazijn.aantalKaas);
		System.out.println("Paprika: " + Magazijn.aantalPaprika);
		System.out.println("Salami: " + Magazijn.aantalSalami);
		System.out.println("Ui: " + Magazijn.aantalUi);
		
		if (aantalHam != 0 && aantalKaas != 0 && aantalPaprika != 0 && aantalSalami != 0 && aantalUi != 0) {
			return "Er zijn nog voldoende ingrediënten beschikbaar.";
		}
		else {
			return "Het magazijn moet worden aangevuld.";
		}
	}
}
