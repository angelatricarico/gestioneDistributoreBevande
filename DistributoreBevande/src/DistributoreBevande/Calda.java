package DistributoreBevande;

public class Calda extends Categoria {
	
	String [] prodottiDefault = {"Caffè stretto", "Caffè lungo", "Cappuccino", "Ginseng", "Thè caldo", "Cioccolata calda", 
	"Latte macchiato"};
	
	public Calda () {
		super("Calda");
		
		for(int i = 0; i<prodottiDefault.length; i++) {
			this.prodotti.add(new Prodotto(prodottiDefault[i]));
		}
	}

}
