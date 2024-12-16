package DistributoreBevande;

public class Distributore {
	
	String nome;
	double credito;
	int bicchieri;
	int bacchette;
	int cubettiZucchero;
	Categoria[] categorie = {new Calda(), new Fredda()};
	
	public void stampaCategorie() {
		for (int i = 0; i < categorie.length; i++) {
			System.out.println("Premi " + (i+1) + " per " + categorie[i].nome);
		}
		System.out.println("Premi 9 per uscire.");
	}

	
	public boolean controlloRisorse() {
		if (bicchieri == 0) {
			return false;
		}
		if (cubettiZucchero == 0) {
			return false;
		}
		return true;
	} 
		
	//costruttore della classe
	public Distributore(String nome) {
		this.nome = nome;
		bicchieri = (int) (Math.random() * 21);
		bacchette = (int) (Math.random() * 21);
		cubettiZucchero = (int) (Math.random() * 21);
	}
}
