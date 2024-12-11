package DistributoreBevande;

import java.util.ArrayList;

public class Categoria {
	
	String nome;
	ArrayList <Prodotto> prodotti;
	
	public void stampaProdotti() {
		System.out.print("");
	}
	
	public Categoria(String nome) {
		
		this.nome = nome;
	}

}
