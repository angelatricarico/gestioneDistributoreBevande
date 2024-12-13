package DistributoreBevande;

import java.util.ArrayList;

public class Categoria {
	
	String nome;
	ArrayList <Prodotto> prodotti = new ArrayList <Prodotto> ();
	
	public Categoria(String nome) {
		
		this.nome = nome;
	}
	
	public void stampaProdotti() {
		
		for (int i = 0; i<prodotti.size(); i++) {
			System.out.println(prodotti.get(i).nome);
		}
	}

}
