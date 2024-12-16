package DistributoreBevande;

import java.util.Scanner;

public class Distributore {
	
	String nome;
	double credito;
	int bicchieri;
	int bacchette;
	int cubettiZucchero;
	Categoria[] categorie;
	private final String[] [] prodottiDefault = {{"Caffè stretto", "Caffè lungo", "Cappuccino", "Ginseng", "Thè caldo", "Cioccolata calda", 
	"Latte macchiato"}, {"Acqua Naturale", "Acqua Frizzante", "Thè limone", "Thè pesca", "Aranciata", "Cola", 
	"Energy drink"}};
	private final String [] nomeCategorie = {"Calda", "Fredda"};
	
	public void stampaCategorie() {
		for (int i = 0; i < categorie.length; i++) {
			System.out.println("Premi " + (i+1) + " per scegliere " + categorie[i].nome + ".");
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
	
	public void controlloQuantita(int sceltaCategoria, int sceltaProdotto) {
		
		if (categorie[sceltaCategoria].prodotti.get(sceltaProdotto).quantita == 0) {
			System.out.println("Ci dispiace, il prodotto è esaurito. Scegline un altro per favore.");
	/*	} else {
			System.out.print("Disponibile"); */
		}
		
	}
	
	public void controlloMoneta(Scanner scanner, Prodotto prodotto) {
		
		double credito = 0; //credito del distributore mentre l'utente inserisce moneta
		
		while (credito < prodotto.prezzo) {
			System.out.print("Inserisci moneta: " + prodotto.prezzo);
			credito += scanner.nextInt(); //lo scanner riceve l'input dell'utente e lo aumenta
		}
		System.out.println("Prodotto erogato");
		
	}
	
	
	//costruttore della classe
	public Distributore(String nome) {
		this.nome = nome;
		bicchieri = (int) (Math.random() * 21);
		bacchette = (int) (Math.random() * 21);
		cubettiZucchero = (int) (Math.random() * 21);
		this.categorie = new Categoria [2];
		
		for (int i = 0; i< nomeCategorie.length; i++) {
			Categoria categoria1 = new Categoria(nomeCategorie[i]);
			categorie[i] = categoria1;
			for (int j = 0; j<prodottiDefault[i].length; j++) {
				Prodotto prodotto1 = new Prodotto(prodottiDefault[i][j]);
				categoria1.prodotti.add(prodotto1);
			}
		}
	}
}
