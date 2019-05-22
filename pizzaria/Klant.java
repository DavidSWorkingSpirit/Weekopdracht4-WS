package pizzaria;

public class Klant {
	String naam;
	String geholpenDoor;
	int geld;
	
	Klant(String naam, int money) {
		this.naam = naam;
		this.geld = money;
	}
	
    @Override
    public String toString() {
        return String.format("Naam: " + naam + " " + "Geld: " + geld + " |");
    }
}
