package pizzaria;

import java.util.Scanner;

public class Application {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean geopend = true;
		// Kassamedewerker en pizzabakker random een String meegeven als naam uit een array van namen. (Medewerkers onder contract)
		Kassamedewerker km1 = new Kassamedewerker("Dana");
		Pizzabakker pb1 = new Pizzabakker("Luigi");
		
		while (geopend == true) {
			String invoer = sc.nextLine();
			
			switch(invoer) {
				case "1": {
					km1.klantOntvangen();
					Pizza gebakken = pb1.pizzaBakken(km1.bestellingOpnemen());
					
					System.out.println(gebakken.ingredienten);
					break;
				}
				case "q": {
					System.out.println("De pizzaria is gesloten.");
					geopend = false;
					break;
				}
				default: {
					System.out.println("Foutieve invoer. Voer iets anders in.");
				}
			}
		}
	}
}
