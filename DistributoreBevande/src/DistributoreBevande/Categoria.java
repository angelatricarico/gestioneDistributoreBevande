package DistributoreBevande;

import java.util.ArrayList;

public class Categoria {
	
	String nome;
	ArrayList <Prodotto> prodotti = new ArrayList <Prodotto> ();
	boolean controlloAggiuntivo;
	
	public Categoria(String nome) {
		this.controlloAggiuntivo = false;
		this.nome = nome;
	}
	
	public void stampaProdotti() {
		
		System.out.println("0) Per scegliere nuovamente la categoria");
		for (int i = 0; i<prodotti.size(); i++) {
			System.out.println((i+1) + ")" + " " + prodotti.get(i).toString());
		}
		
	}
	
	public void aggiungiProdotti(Prodotto prodotto1) {
		
		boolean trovato = false;
		for (int i = 0; i < prodotti.size(); i++) {
			if (prodotto1.nome.equalsIgnoreCase(prodotti.get(i).nome)) {
				System.out.println("Prodotto già esistente.");
				trovato = true;
			} 
		}
		if (trovato == false) {
			prodotti.add(prodotto1);
			System.out.println("Prodotto aggiunto con successo!");
		}
		
	}
	
	public void cancellaProdotto(int indiceDaCancellare) {
		
		//controllare che l'indice inserito corrisponda ad un prodotto
		if (indiceDaCancellare >= 0 && indiceDaCancellare < prodotti.size()) {
			prodotti.remove(indiceDaCancellare);
			System.out.println("Prodotto rimosso con successo!");
		} else {
			System.out.println("Prodotto inesistente");
		}
		
	}
	
	
	//metodo per aggiornare prodotti
	
	
	//metodo per controllare quantita
}
