package DistributoreBevande;

public class Calda extends Categoria {
	static final private String[] prodottiDefault = { "Caffè stretto", "Caffè lungo", "Cappuccino", "Ginseng",
			"Thè caldo", "Cioccolata calda", "Latte macchiato" };

	Calda() {
		super("Calda", prodottiDefault);

	}

	@Override
	public void stampaProva() {
		System.out.println("Prova Calda");
	}
}
