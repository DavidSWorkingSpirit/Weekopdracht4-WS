package pizzaria;

import java.util.Scanner;
import pizzaria.Kassamedewerker.NietGenoegGeldException;

public class Application {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean geopend = true;
		// Kassamedewerker en pizzabakker random een String meegeven als naam uit een array van namen. (Medewerkers onder contract)
		Kassamedewerker km1 = new Kassamedewerker("Dana");
		Pizzabakker pb1 = new Pizzabakker("Luigi");
		
		System.out.println("Ham: " + Magazijn.aantalHam);
		System.out.println("Kaas: " + Magazijn.aantalKaas);
		System.out.println("Paprika: " + Magazijn.aantalPaprika);
		System.out.println("Salami: " + Magazijn.aantalSalami);
		System.out.println("Ui: " + Magazijn.aantalUi);
		
		while (geopend == true) {
			String invoer = sc.next();
			
			switch(invoer) {
				case "1": {
					km1.klantOntvangen();
					Pizza bestelling = km1.bestellingOpnemen();
					System.out.println(bestelling);
					
					Pizza gebakken = pb1.pizzaBakken(bestelling);
					if (gebakken == null) {
						System.out.println("De bestelling is mislukt. Vul het magazijn aan en begin opnieuw.");
						System.out.println(km1.klanten.size());
						System.out.println(km1.bestellingen.size());
						km1.klanten.remove(km1.klanten.size() -1);
						km1.bestellingen.remove(km1.bestellingen.size() -1);
						System.out.println(km1.klanten.size());
						System.out.println(km1.bestellingen.size());
						break;
					}
					break;
				}
				case "a": {
					try {
						System.out.println(km1.afrekenen());
					}
					catch (NietGenoegGeldException e){
						System.out.println("De klant heeft niet genoeg geld. Wijs de klant de deur.");
					}
				}
				case "m": {
					System.out.println(km1.magazijnCheck());
					break;
				}
				case "b": {
					System.out.println("Welk ingrediënt moet worden besteld?");
					String teBestellen = sc.next().toLowerCase();
					System.out.println(km1.bestelIngredient(teBestellen));
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
