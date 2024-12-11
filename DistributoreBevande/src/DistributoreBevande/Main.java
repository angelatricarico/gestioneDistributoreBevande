package DistributoreBevande;

import java.util.Scanner;

public class Main {
	/*
	 * Progetto: distributore di bevande completo
Partendo dai diagrammi di flusso realizzati in precedenza, programmare il software per la gestione del distributore di bevande.
Nel progetto dovranno essere utilizzati tutti i concetti visti fino a questo momento, inoltre il codice dovrà essere integrato/migliorato
con i concetti della OOP che impareremo nei prossimi giorni.
New feature: gestione operatore. L'operatore può, inserendo un codice riservato, accedere ad un menu di selezione 
con cui poter fare le seguenti operazioni:
-aggiungere un nuovo prodotto
-rimuovere un prodotto
-cambiare la quantità disponibile di un prodotto
-cambiare il prezzo di un prodotto
Inoltre, l'operatore potrà vedere:
-totale incassato dal distributore
-elenco dei prodotti acquistati con relative quantità (es: caffè 10, ginseng 18, coca 4)
CONSEGNA: entro il 20 dicembre.
	 */

	public static void main(String[] args) {
		
		Distributore distributore = new Distributore("AllYouCanDrink =)");
		//Distributore distributore1 = new Distributore("BeviQuantoVuoi");
		
		System.out.println(distributore.nome);
		//System.out.println(distributore1.nome);
		
		Scanner scanner = new Scanner(System.in);
		
		int inputUtente;
		
		inputUtente = 1;
		while (inputUtente == 1) {
			System.out.println("Seleziona:\n l) Bevande Calde\n 2) Bevande Fredde\n 3) Esci ");
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
	}

}
