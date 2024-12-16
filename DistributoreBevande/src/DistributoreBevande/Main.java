package DistributoreBevande;

import java.util.Scanner;

//branchAngela

public class Main {

	public static void main(String[] args) {
		
		Distributore distributore = new Distributore("AllYouCanDrink");
		System.out.println(distributore.nome);
		
		Scanner scanner = new Scanner(System.in);
		
		int inputUtente;
		
		inputUtente = 1;
		while (inputUtente == 1) {
			distributore.stampaCategorie();
			int sceltaUtente = scanner.nextInt();
			
			
			if (sceltaUtente == 9) {
				System.out.println("Arrivederci");
				inputUtente = -1;
			} else if (sceltaUtente > distributore.categorie.length){
				System.out.println("Input non valido. Per favore, riprovare.");
			} else {
				System.out.println("Ecco i seguenti prodotti della categoria " + distributore.categorie[sceltaUtente-1].nome);
				distributore.categorie[sceltaUtente-1].stampaProdotti();
			}
			
		}
		scanner.close();	
	}

}
