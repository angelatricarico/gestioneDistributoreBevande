package DistributoreBevande;

public class Distributore {
	
	String nome;
	double credito;
	int bicchieri;
	int bacchette;
	int cubettiZucchero;
	Categoria[] categorie = new Categoria[2];
	
	
	public void stampaCategoria() {
		System.out.print("");
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
	
	public Distributore(String nome) {
		this.nome = nome;
		bicchieri = (int) (Math.random() * 21);
		bacchette = (int) (Math.random() * 21);
		cubettiZucchero = (int) (Math.random() * 21);
		Fredda fredda = new Fredda();
		Calda calda = new Calda();
		//categorie = {fredda, calda}; 
	}
}
