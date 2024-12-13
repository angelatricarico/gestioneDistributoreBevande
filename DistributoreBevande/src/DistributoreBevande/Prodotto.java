package DistributoreBevande;

public class Prodotto {
	protected int quantita;
	protected double prezzo;
	protected String nome;

	Prodotto(String nome) {
		this.nome = nome;
		this.quantita = (int) Math.random() * 30;
		this.prezzo = Math.random() * 8 + 2;
	}
}
