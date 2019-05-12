package pizzaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kassamedewerker extends Medewerker {
	static Scanner scan = new Scanner(System.in);
	int omzet;
	
	List<Klant> klanten = new ArrayList<>();
	
	Kassamedewerker(String naam) {
		this.naam = naam;
	}
	
	int omzetBerekenen() {
		
		return omzet;
	}
	
	void klantOntvangen() {
		System.out.println("Er is een nieuwe klant. Wat is de naam? (Plus hoeveel geld heeft de klant?)");
		System.out.println("Naam:");
		String invoerNaam = scan.next();
		// VOOR GELD MOGELIJK EEN RANDOM
		System.out.println("Geld:");
		int invoerGeld = scan.nextInt();
		
		klanten.add(new Klant(invoerNaam, invoerGeld));
		
	}
	
	public Pizza bestellingOpnemen() {
		Pizza pizzaBestelling = null;
		
		System.out.println("Hoeveel ingrediënten op de pizza?");
		String aantalIngredienten = scan.next();
		
		switch(aantalIngredienten) {
			case "1": {
				Ingredient i1 = new Ingredient();
				i1.naam = scan.next();
				pizzaBestelling = new Pizza(i1);
				break;
			}
			case "2": {
				Ingredient i1 = new Ingredient();
				Ingredient i2 = new Ingredient();
				i1.naam = scan.next();
				i2.naam = scan.next();
				pizzaBestelling = new Pizza(i1, i2);
				break;
			}
			case "3": {
				Ingredient i1 = new Ingredient();
				Ingredient i2 = new Ingredient();
				Ingredient i3 = new Ingredient();
				i1.naam = scan.next();
				i2.naam = scan.next();
				i3.naam = scan.next();
				pizzaBestelling = new Pizza(i1, i2, i3);
				break;
			}
			case "4": {
				Ingredient i1 = new Ingredient();
				Ingredient i2 = new Ingredient();
				Ingredient i3 = new Ingredient();
				Ingredient i4 = new Ingredient();
				i1.naam = scan.next();
				i2.naam = scan.next();
				i3.naam = scan.next();
				i4.naam = scan.next();
				pizzaBestelling = new Pizza(i1, i2, i3, i4);
				break;
			}
			case "5": {
				Ingredient i1 = new Ingredient();
				Ingredient i2 = new Ingredient();
				Ingredient i3 = new Ingredient();
				Ingredient i4 = new Ingredient();
				Ingredient i5 = new Ingredient();
				i1.naam = scan.next();
				i2.naam = scan.next();
				i3.naam = scan.next();
				i4.naam = scan.next();
				i5.naam = scan.next();
				pizzaBestelling = new Pizza(i1, i2, i3, i4, i5);
				break;
			}
			default: {
				System.out.println("Deze invoer is onjuist. Voer een getal in van 1 t/m 5.");
			}
		}
		return pizzaBestelling;
	}
	
//	void magazijnCheck() {
//	
//	}
	
	// Als mogelijk returntype toevoegen.
	void bestellingenCheck() {
		for (Klant elem : klanten) {
			System.out.println(elem.toString());
		}
	}
}
