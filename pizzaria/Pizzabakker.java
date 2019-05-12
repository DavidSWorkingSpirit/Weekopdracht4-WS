package pizzaria;

public class Pizzabakker extends Medewerker {
	
	Pizzabakker(String naam) {
		this.naam = naam;
	}
	
	Pizza pizzaBakken(Pizza pizza) {
		Pizza gebakkenPizza;
		
//		In de if kijken of alle ingrediënten van Pizza pizza beschikbaar zijn, else Exception (LATER TOEVOEGEN).		
		if(true) {
			gebakkenPizza = pizza;
		}
		else {
			System.out.println("Eén of meerdere ingrediënten zijn op! Bestel de ingrediënten.");
		}
		
		return gebakkenPizza;
	}
}
