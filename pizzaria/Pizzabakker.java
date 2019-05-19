package pizzaria;

public class Pizzabakker extends Medewerker {
	
	Pizzabakker(String naam) {
		this.naam = naam;
	}
	
	Pizza pizzaBakken(Pizza pizza) {
		Pizza gebakkenPizza = null;
		try {
			gebakkenPizza = ingredientCheck(pizza);
			return gebakkenPizza;
		} catch (IngredientOpException e) {
			System.out.println("Eén of meerdere ingrediënten zijn op!");
//			e.printStackTrace();
		}
		return gebakkenPizza;
	}
	
	Pizza ingredientCheck(Pizza pizza) throws IngredientOpException {
		Pizza tijdelijkePizza = pizza;
		
		for (Bestelbaar elem : tijdelijkePizza.ingredienten) {
			Ingredient tijdelijkIngredient = (Ingredient)elem;
			String tijdelijkeNaam = tijdelijkIngredient.naam;
			
			switch(tijdelijkeNaam) {
				case "kaas":{
					if(Magazijn.aantalKaas >= 1) {
						Magazijn.aantalKaas--;
						break;
					}
					else {
						throw new IngredientOpException();
					}
				}
				case "ui":{
					if(Magazijn.aantalUi >= 1) {
						Magazijn.aantalUi--;
						break;
					}
					else {
						throw new IngredientOpException();
					}
				}
				case "paprika":{
					if(Magazijn.aantalPaprika >= 1) {
						Magazijn.aantalPaprika--;
						break;
					}
					else {
						throw new IngredientOpException();
					}
				}
				case "salami":{
					if(Magazijn.aantalSalami >= 1) {
						Magazijn.aantalSalami--;
						break;
					}
					else {
						throw new IngredientOpException();
					}
				}
				case "ham":{
					if(Magazijn.aantalHam >= 1) {
						Magazijn.aantalHam--;
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
