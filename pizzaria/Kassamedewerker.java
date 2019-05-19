package pizzaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kassamedewerker extends Medewerker {
	static Scanner scan = new Scanner(System.in);
	int omzet;
	Magazijn mg1 = new Magazijn();
	
	List<Klant> klanten = new ArrayList<>();
	List<Pizza>	bestellingen = new ArrayList<>();
	
	Kassamedewerker(String naam) {
		this.naam = naam;
		System.out.println(this.naam + " heeft de pizzaria geopend.");
		System.out.println(mg1.magazijnVullen());
	}
	
	int omzetBerekenen() {
		
		return omzet;
	}
	
	void klantOntvangen() {
		System.out.println("Er is een nieuwe klant. Wat is de naam? (Plus hoeveel geld heeft de klant?)");
		System.out.println("Naam:");
		String invoerNaam = scan.next();
		int geldKlant = Magazijn.randy.nextInt(15) + 5;
		
		klanten.add(new Klant(invoerNaam, geldKlant));
		
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
				pizzaBestelling.prijs = 5;
				bestellingen.add(pizzaBestelling);
				break;
			}
			case "2": {
				Ingredient i1 = new Ingredient();
				Ingredient i2 = new Ingredient();
				i1.naam = scan.next().toLowerCase();
				i2.naam = scan.next().toLowerCase();
				pizzaBestelling = new Pizza(i1, i2);
				pizzaBestelling.prijs = 7;
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
				pizzaBestelling.prijs = 9;
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
				pizzaBestelling.prijs = 11;
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
				pizzaBestelling.prijs = 13;
				bestellingen.add(pizzaBestelling);
				break;
			}
			default: {
				System.out.println("Deze invoer is onjuist. Voer een getal in van 1 t/m 5.");
			}
		}
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
			return "Er is betaald.";
		}
		else {
			throw new NietGenoegGeldException();
		}
	}
	
	@SuppressWarnings("serial")
	class NietGenoegGeldException extends Exception {
		
	}
}
