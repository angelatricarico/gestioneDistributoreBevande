package DistributoreBevande;

public class Fredda extends Categoria {
	static final private String[] prodottiDefault = { "Acqua Naturale", "Acqua Frizzante", "Thè limone", "Thè pesca",
			"Aranciata", "Cola", "Energy drink" };

	Fredda() {
		super("Fredda", prodottiDefault);
	}
	
	@Override
	protected void stampaProva() {
		super.stampaProva();
		System.out.println("Prova Fredda");
	}
}
