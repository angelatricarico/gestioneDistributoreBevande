package DistributoreBevande;

import java.util.ArrayList;

public class Categoria {
	
	// Attributes
	String nome;
	private ArrayList <Prodotto> prodotti = new ArrayList<>();
	
	// Constructors
	public Categoria(String nome, String[] prodottiDefault) {
		this.nome = nome;
		for (int i = 0; i<prodottiDefault.length; i++) {
			this.prodotti.add(new Prodotto(prodottiDefault[i]));
		}
	}
	
	//Methods
	
	// Stampa prodotti della categoria
	public void stampaProdotti() {
		System.out.println("I prodotti della bevanda " + this.nome);
		System.out.println("*******************************");
		for (int i = 0; i < prodotti.size(); i++) {
			Prodotto prodotto = prodotti.get(i);
			System.out.println(String.format("%d) %s - %f", i + 1, prodotto.nome, prodotto.prezzo));
		}
	}
	
	protected void stampaProva() {
		System.out.println("Prova Categoria");
	}
	
	protected 
}
