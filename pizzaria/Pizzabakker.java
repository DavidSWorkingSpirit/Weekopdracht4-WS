package pizzaria;

public class Pizzabakker extends Medewerker {
	
	Pizzabakker(String naam) {
		this.naam = naam;
	}
	
	Pizza pizzaBakken(Pizza pizza, Pizzabakker pb) throws InterruptedException {
		Pizza gebakkenPizza = null;
		try {
			gebakkenPizza = ingredientCheck(pizza);
			gebakkenPizza.gebakkenDoor = pb.naam;
			Magazijn.gebruikIngredienten();
			
			for(int sec = 0; sec <= 20; sec++) {
					Thread.sleep(1000);
					if(sec == pizza.bereidingstijd) {
						System.out.println("De pizza is klaar. Tijd om af te rekenen.");
						System.out.println("De pizza is gebakken door pizzabakker " + gebakkenPizza.gebakkenDoor + ".");
						break;
					}
			}
			return gebakkenPizza;
		} catch (IngredientOpException e) {
			System.out.println("Pizzabakker " + pb + " zegt dat één of meerdere ingrediënten op zijn!");
			Magazijn.resetReservering();
//			e.printStackTrace();
		}
		return gebakkenPizza;
	}
	
	Pizza ingredientCheck(Pizza pizza) throws IngredientOpException {
		Pizza tijdelijkePizza = pizza;
		
		for (Bestelbaar elem : tijdelijkePizza.ingredienten) {
			String tijdelijkeNaam = ((Ingredient)elem).naam;
			
			switch(tijdelijkeNaam) {
				case "ham":{
					if(Magazijn.aantalHam >= 1) {
						Magazijn.hamReservering++;
						break;
					}
					else {
						throw new IngredientOpException();
					}
				}
				case "kaas":{
					if(Magazijn.aantalKaas >= 1) {
						Magazijn.kaasReservering++;
						break;
					}
					else {
						throw new IngredientOpException();
					}
				}
				case "paprika":{
					if(Magazijn.aantalPaprika >= 1) {
						Magazijn.paprikaReservering++;
						break;
					}
					else {
						throw new IngredientOpException();
					}
				}
				case "salami":{
					if(Magazijn.aantalSalami >= 1) {
						Magazijn.salamiReservering++;
						break;
					}
					else {
						throw new IngredientOpException();
					}
				}
				case "ui":{
					if(Magazijn.aantalUi >= 1) {
						Magazijn.uiReservering++;
						break;
					}
					else {
						throw new IngredientOpException();
					}
				}
			}
		}
		return tijdelijkePizza;
	}
}

@SuppressWarnings("serial")
class IngredientOpException extends Exception {

}
