package pizzaria;

public class Klant {
	String naam;
	int geld;
	
	Klant(String naam, int money) {
		this.naam = naam;
		this.geld = money;
	}
	
    @Override
    public String toString() {
        return String.format("%s\t%s", "Naam: " + naam, "Geld: " + geld);
    }
}
