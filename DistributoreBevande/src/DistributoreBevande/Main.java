package DistributoreBevande;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Variabili
		Distributore distributore = new Distributore("AllYouCanDrink");
		Scanner scanner = new Scanner(System.in);
		int inputUtente;
		inputUtente = -1;

		// LOOP MENU
		while (true) {
			// Stampo CATEGORIE
			distributore.stampaCategoria();
			inputUtente = scanner.nextInt();

			// Exit MENU
			if (inputUtente == 9) {
				System.out.println("Arrivederci");
				break;
			}
			
			if (inputUtente > 0 && inputUtente <= distributore.getCategoriaLen()) {
				distributore.getCategoria(inputUtente - 1).stampaProdotti();
				Categoria categoria = distributore.getCategoria(inputUtente - 1);
				categoria.stampaProva();
				
			} else if (inputUtente != 9) {
				System.out.println("Inserire codice valido! ");
			}

		} // END LOOP MENU

		scanner.close();
	}

}
