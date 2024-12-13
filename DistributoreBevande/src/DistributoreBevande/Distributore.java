package DistributoreBevande;

public class Distributore {
	
	// Attributes
	String nome;
	double credito;
	int bicchieri;
	int bacchette;
	int cubettiZucchero;
	private Categoria[] categorie = {new Fredda(), new Calda()};
	
	// Constructors
	public Distributore(String nome) {
		this.nome = nome;
		bicchieri = (int) (Math.random() * 21);
		bacchette = (int) (Math.random() * 21);
		cubettiZucchero = (int) (Math.random() * 21);

	}
	
	// Methods
	// Stampa le categorie
	public void stampaCategoria() {
		for (int i = 0; i < categorie.length; i++) {
			System.out.println(String.format("%d: Bevanda %s", i + 1, categorie[i].nome));
		}
		System.out.println("9: Uscire");
	}
	
	public void controlloRisorse() {
	} 
	
	// Get categoria specifica
	public Categoria getCategoria(int index) {
		return categorie[index];
	}
	
	// Get categoria length
	public int getCategoriaLen() {
		return categorie.length;
	}
}

