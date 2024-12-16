package DistributoreBevande;

public class Prodotto {
	
	int quantita;
	double prezzo;
	String nome;
	
	//per l'utente
	public Prodotto(String nome) {
		this.nome = nome;
		this.prezzo = (double) (Math.random() * 3.0 + 1);
		this.quantita = (int) (Math.random() * 21);
	}
	
	//per l'operatore
	public Prodotto(String nome, int quantita, double prezzo) {
		
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}
	
	@Override
	public String toString() {
				
		return String.format("%s €%.2f %d", nome, prezzo, quantita); //s per string, f per double, d per int
	}

}
