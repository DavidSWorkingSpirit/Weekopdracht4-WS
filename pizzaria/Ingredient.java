package pizzaria;

public class Ingredient implements Bestelbaar {
	public String naam;
	
	public String bestellen(String s) {
		switch (s) {
			case "ham": {
				Magazijn.aantalHam = Magazijn.aantalHam + Magazijn.randy.nextInt(5) + 1;
				return "De " + s + " is aangevuld in het magazijn.";
			}
			case "kaas": {
				Magazijn.aantalKaas = Magazijn.aantalKaas + Magazijn.randy.nextInt(5) + 1;
				return "De " + s + " is aangevuld in het magazijn.";
			}
			case "paprika": {
				Magazijn.aantalPaprika = Magazijn.aantalPaprika + Magazijn.randy.nextInt(5) + 1;
				return "De " + s + " is aangevuld in het magazijn.";
			}
			case "salami": {
				Magazijn.aantalSalami = Magazijn.aantalSalami + Magazijn.randy.nextInt(5) + 1;
				return "De " + s + " is aangevuld in het magazijn.";
			}
			case "ui": {
				Magazijn.aantalUi = Magazijn.aantalUi + Magazijn.randy.nextInt(5) + 1;
				return "De " + s + " is aangevuld in het magazijn.";
			}
			default: {
				return "Dit ingrediënt komt niet voor in het magazijn.";
			}
		}
	}
}
