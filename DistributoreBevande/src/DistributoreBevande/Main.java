package DistributoreBevande;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Distributore distributore = new Distributore("All You Can Drink");
		System.out.println(distributore.nome);
		
		Scanner scanner = new Scanner(System.in);
		
		int inputUtente;
		
		inputUtente = 1;
		while (inputUtente == 1) {
			System.out.println("Premi 1 per scegliere fra le bevande calde; 2 per scegliere fra le bevande fredde; 3 per uscire dal menù: ");
			int sceltaUtente = scanner.nextInt();
			
			
			switch (sceltaUtente) {
			case 1: 
				System.out.println("Scegli fra le bevande calde");
				
			break;
			
			case 2:
				System.out.println("Scegli fra le bevande fredde.");
				
			break;
			
			case 3: 
				System.out.println("Sei uscito dal menù.");
				
				inputUtente = -1;
			break;
			}
		}
		scanner.close();	
	}

}
