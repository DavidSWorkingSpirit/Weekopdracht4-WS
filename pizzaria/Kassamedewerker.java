package pizzaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pizzaria.Berekening;

public class Kassamedewerker extends Medewerker {
	static Scanner scan = new Scanner(System.in);
	
	int omzet;
	Berekening optellen = (y, r) -> y + r;
	
	Magazijn mg1 = new Magazijn();
	
	List<Klant> klanten = new ArrayList<>();
	List<Pizza>	bestellingen = new ArrayList<>();
	
	Kassamedewerker(String naam) {
		this.naam = naam;
		System.out.println(this.naam + " heeft de pizzaria geopend.");
		System.out.println(mg1.magazijnVullen());
	}
	
	int omzetBerekenen(Berekening aq, int a, int b) {
		this.omzet = aq.bereken(a, b);
		return omzet;
	}
	
	void klantOntvangen(Kassamedewerker km) {
		System.out.println("Er is een nieuwe klant. Wat is de naam?");
		System.out.println("Naam:");
		String invoerNaam = scan.next();
		int geldKlant = Magazijn.randy.nextInt(15) + 5;
		
		Klant tijdelijk = new Klant(invoerNaam, geldKlant);
		tijdelijk.geholpenDoor = km.naam;
		klanten.add(tijdelijk);
	}
	
	public Pizza bestellingOpnemen() {
		Pizza pizzaBestelling = null;
		
		System.out.println("Hoeveel ingrediënten op de pizza?");
		String aantalIngredienten = scan.next();
		System.out.println("Voer de ingrediënten in:");
		
		switch(aantalIngredienten) {
			case "1": {
				Ingredient i1 = new Ingredient();
				i1.naam = scan.next().toLowerCase();
				pizzaBestelling = new Pizza(i1);
				pizzaBestelling.prijs = 15;
				pizzaBestelling.bereidingstijd = 1;
				bestellingen.add(pizzaBestelling);
				break;
			}
			case "2": {
				Ingredient i1 = new Ingredient();
				Ingredient i2 = new Ingredient();
				i1.naam = scan.next().toLowerCase();
				i2.naam = scan.next().toLowerCase();
				pizzaBestelling = new Pizza(i1, i2);
				pizzaBestelling.prijs = 15;
				pizzaBestelling.bereidingstijd = 1;
				bestellingen.add(pizzaBestelling);
				break;
			}
			case "3": {
				Ingredient i1 = new Ingredient();
				Ingredient i2 = new Ingredient();
				Ingredient i3 = new Ingredient();
				i1.naam = scan.next().toLowerCase();
				i2.naam = scan.next().toLowerCase();
				i3.naam = scan.next().toLowerCase();
				pizzaBestelling = new Pizza(i1, i2, i3);
				pizzaBestelling.prijs = 16;
				pizzaBestelling.bereidingstijd = 2;
				bestellingen.add(pizzaBestelling);
				break;
			}
			case "4": {
				Ingredient i1 = new Ingredient();
				Ingredient i2 = new Ingredient();
				Ingredient i3 = new Ingredient();
				Ingredient i4 = new Ingredient();
				i1.naam = scan.next().toLowerCase();
				i2.naam = scan.next().toLowerCase();
				i3.naam = scan.next().toLowerCase();
				i4.naam = scan.next().toLowerCase();
				pizzaBestelling = new Pizza(i1, i2, i3, i4);
				pizzaBestelling.prijs = 18;
				pizzaBestelling.bereidingstijd = 2;
				bestellingen.add(pizzaBestelling);
				break;
			}
			case "5": {
				Ingredient i1 = new Ingredient();
				Ingredient i2 = new Ingredient();
				Ingredient i3 = new Ingredient();
				Ingredient i4 = new Ingredient();
				Ingredient i5 = new Ingredient();
				i1.naam = scan.next().toLowerCase();
				i2.naam = scan.next().toLowerCase();
				i3.naam = scan.next().toLowerCase();
				i4.naam = scan.next().toLowerCase();
				i5.naam = scan.next().toLowerCase();
				pizzaBestelling = new Pizza(i1, i2, i3, i4, i5);
				pizzaBestelling.prijs = 20;
				pizzaBestelling.bereidingstijd = 3;
				bestellingen.add(pizzaBestelling);
				break;
			}
			default: {
				System.out.println("Deze invoer is onjuist. Voer een getal in van 1 t/m 5.");
				return bestellingOpnemen();
			}
		}
		System.out.println("Er is een bestelling. Roep de pizzabakker.");
		return pizzaBestelling;
	}
	
	String bestelIngredient(String s) {
		Ingredient tijdelijk = new Ingredient();
		return tijdelijk.bestellen(s);
	}
	
	String magazijnCheck() {
		return mg1.magazijnCheck();
	}
	
	// Als mogelijk returntype toevoegen.
	void bestellingenCheck() {
		for (Klant elem : klanten) {
			System.out.println(elem.toString());
		}
	}
	
	String afrekenen() throws NietGenoegGeldException {
		if(klanten.get(klanten.size() - 1).geld - bestellingen.get(bestellingen.size() - 1).prijs >= 0) {
			klanten.get(klanten.size() - 1).geld -= bestellingen.get(bestellingen.size() - 1).prijs;
			omzetBerekenen(optellen, omzet, bestellingen.get(bestellingen.size() - 1).prijs);
			return "Er is betaald.";
		}
		else {
			throw new NietGenoegGeldException();
		}
	}
	
	void bekijkBestellingen() {
		System.out.println("Wil je een specifieke (s) klant of alle (a) klanten bekijken?");
		String invoerKlant = scan.next();
		
		switch(invoerKlant) {
			case "a": {
				//methode(?) of manier om alle klanten en bijbehorende bestelling uit te printen.
				break;
			}
			case "s": {
				System.out.println("Wat is het klantnummer?");
				try {
					int klantNummer = scan.nextInt() - 1;
					System.out.print(klanten.get(klantNummer).toString() + " ");
					System.out.println(bestellingen.get(klantNummer).toString());
				}
				catch (IndexOutOfBoundsException i){
					System.out.println("Dit klantnummer bestaat niet.");
				}
				break;
			}
			default: {
				System.out.println("Foutieve invoer, probeer het opnieuw.");
			}
		}
	}
	
	int omzetBekijken() {
		return omzet;
	}
	
	@SuppressWarnings("serial")
	class NietGenoegGeldException extends Exception {
		
	}
}
