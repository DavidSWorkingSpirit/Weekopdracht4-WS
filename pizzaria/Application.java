package pizzaria;

import java.util.Random;
import java.util.Scanner;
import pizzaria.Kassamedewerker.NietGenoegGeldException;

public class Application {
	
	static Scanner sc = new Scanner(System.in);
	static Random ranbo = new Random();
	
	public static void main(String[] args) {
		boolean geopend = true;
		String[] kassamedewerkers = {"Dana", "Hans", "Mitchel", "Jeffrey", "Priscilla", "Pietje", "Nwankulu"};
		String[] pizzabakkers = {"Luigi", "Alfredo", "Mario", "Michelangelo", "Leonardo", "Donatello", "Raphael", "Sjon"};
		Kassamedewerker km1 = new Kassamedewerker(kassamedewerkers[ranbo.nextInt(7)]);
		Pizzabakker pb1 = new Pizzabakker(pizzabakkers[ranbo.nextInt(8)]);
		
		System.out.println("Ham: " + Magazijn.aantalHam);
		System.out.println("Kaas: " + Magazijn.aantalKaas);
		System.out.println("Paprika: " + Magazijn.aantalPaprika);
		System.out.println("Salami: " + Magazijn.aantalSalami);
		System.out.println("Ui: " + Magazijn.aantalUi);
		
		while (geopend == true) {
			String invoer = sc.next();
			
			switch(invoer) {
				case "1": {
					km1.klantOntvangen(km1);
					Pizza bestelling = km1.bestellingOpnemen();
					
					Pizza gebakken;
					try {
						gebakken = pb1.pizzaBakken(bestelling, pb1);
					} catch (InterruptedException e) {
						System.out.println("Tijdens het bakken is er iets misgegaan. Evacueer het gebouw!");
						gebakken = null;
//						e.printStackTrace();
					}
					
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
						break;
					}
					catch (NietGenoegGeldException e){
						System.out.println(km1.klanten.get(km1.klanten.size() - 1).naam + " heeft niet genoeg geld. Wijs de klant de deur.");
						km1.klanten.remove(km1.klanten.size() - 1);
						km1.bestellingen.remove(km1.bestellingen.size() - 1);
						break;
					}
				}
				case "o": {
					System.out.println("De omzet van de pizzaria is " + km1.omzetBekijken() + " euro.");
					break;
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
				case "c": {
					km1.bekijkBestellingen();
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
