package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
	String soort;
	List<Bestelbaar> ingredienten = new ArrayList<>();
	
	Pizza(Bestelbaar b1){
		ingredienten.add(b1);
	}
	
	Pizza(Bestelbaar b1, Bestelbaar b2){
		ingredienten.add(b1);
		ingredienten.add(b2);
	}
	
	Pizza(Bestelbaar b1, Bestelbaar b2, Bestelbaar b3){
		ingredienten.add(b1);
		ingredienten.add(b2);
		ingredienten.add(b3);
	}
	
	Pizza(Bestelbaar b1, Bestelbaar b2, Bestelbaar b3, Bestelbaar b4){
		ingredienten.add(b1);
		ingredienten.add(b2);
		ingredienten.add(b3);
		ingredienten.add(b4);
	}
	
	Pizza(Bestelbaar b1, Bestelbaar b2, Bestelbaar b3, Bestelbaar b4, Bestelbaar b5){
		ingredienten.add(b1);
		ingredienten.add(b2);
		ingredienten.add(b3);
		ingredienten.add(b4);
		ingredienten.add(b5);
	}
	
	//Misschien methode voor uitprinten ingredi�nten van pizza's.
}