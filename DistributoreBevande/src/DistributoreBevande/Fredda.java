package DistributoreBevande;

public class Fredda extends Categoria {
	
	String [] prodottiDefault = {"Acqua Naturale", "Acqua Frizzante", "Thè limone", "Thè pesca", "Aranciata", "Cola", 
	"Energy drink"};
	
	public Fredda () {
		super("Fredda");
		
		for (int i = 0; i<prodottiDefault.length; i++) {
			this.prodotti.add(new Prodotto(prodottiDefault[i]));
		}
	}

}
