package DistributoreBevande;

import java.util.Scanner;

//branchAngela

// Problema del prezzo double


public class Main {

	public static void main(String[] args) {
		
		Distributore distributore = new Distributore("AllYouCanDrink");
		System.out.println("BENVENUTO AL DISTRIBUTORE " + distributore.nome + "!\nPer favore, seleziona una categoria di prodotti: ");
		
		Scanner scanner = new Scanner(System.in);
		
		int input;
		
		input = 1;
		while (input == 1) {
			
			distributore.stampaCategorie();
			
			int sceltaCategoria = scanner.nextInt();
			if (sceltaCategoria == 9) {
				System.out.println("Arrivederci");
				input = -1;
			} else if (sceltaCategoria > distributore.categorie.length){
				System.out.println("Input non valido. Per favore, riprovare.");
			} else {
				Categoria categoriaScelta = distributore.categorie[sceltaCategoria-1];
				
				int sceltaProdotto = -1;
				while (true) {
					System.out.println("Ecco i seguenti prodotti della categoria " + categoriaScelta.nome + ":");
					distributore.categorie[sceltaCategoria-1].stampaProdotti();
					System.out.println("Quale prodotto vuoi scegliere?");
					sceltaProdotto = scanner.nextInt();
					
					if (sceltaProdotto == 0) {
						break;
					} else if ( sceltaProdotto > categoriaScelta.prodotti.size()) {
						System.out.println("Input non valido. Per favore, riprovare.");
					} else {
						Prodotto prodottoScelto = categoriaScelta.prodotti.get(sceltaProdotto-1);
						// Abbiamo gia il controllo della validita' del codiceProdotto
						
						// da fare:
						// Controllo Quantita Prodotto -> Erogazione fatto
						// Controllo Qunatita Prodotto -> Controllo Bicchiere -> Chiedere zucchero -> Controllo palette (opzionale) -> Erogazione
						distributore.controlloQuantita(categoriaScelta, prodottoScelto, scanner);
						
						
					}
				}
			}
			
		}
		scanner.close();	
	}

}
