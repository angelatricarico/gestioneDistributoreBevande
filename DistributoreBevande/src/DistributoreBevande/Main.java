package DistributoreBevande;

import java.util.Scanner;

//branchAngela

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
				
				int sceltaProdotto = -1;
				while (true) {
					System.out.println("Ecco i seguenti prodotti della categoria " + distributore.categorie[sceltaCategoria-1].nome + ":");
					distributore.categorie[sceltaCategoria-1].stampaProdotti();
					System.out.println("Quale prodotto vuoi scegliere?");
					sceltaProdotto = scanner.nextInt();
					
					if (sceltaProdotto == 0) {
						break;
					} else if ( sceltaProdotto > distributore.categorie[sceltaCategoria-1].prodotti.size()) {
						System.out.println("Input non valido. Per favore, riprovare.");
					} else {
						distributore.controlloQuantita(sceltaCategoria-1, sceltaProdotto-1);
						//aggiornare quantità
						distributore.controlloMoneta(scanner, distributore.categorie[sceltaCategoria-1].prodotti.get(sceltaProdotto-1));
					}
				}
			}
			
		}
		scanner.close();	
	}

}
