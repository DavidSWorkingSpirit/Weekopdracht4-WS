package pizzaria;

public class Pizzabakker extends Medewerker {
	
	Pizzabakker(String naam) {
		this.naam = naam;
	}
	
	Pizza pizzaBakken(Pizza pizza) {
		Pizza gebakkenPizza;
		
//		In de if kijken of alle ingredi�nten van Pizza pizza beschikbaar zijn, else Exception (LATER TOEVOEGEN).		
		if(true) {
			gebakkenPizza = pizza;
		}
		else {
			System.out.println("E�n of meerdere ingredi�nten zijn op! Bestel de ingredi�nten.");
		}
		
		return gebakkenPizza;
	}
}
