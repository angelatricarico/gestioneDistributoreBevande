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

	
	// Controllo generale dell'erogazione
	public void controlloQuantita(Categoria sceltaCategoria, Prodotto sceltaProdotto, Scanner scanner) {
		
		// differenziare categoria calda e categoria fredda
		
		if (sceltaCategoria.controlloAggiuntivo == true) {
			// controllo CALDA
			
			// Controllo Qunatita Prodotto -> Controllo Bicchiere -> Chiedere zucchero -> Controllo bacchette (opzionale) -> Erogazione
			// controllo di quantita
			if (sceltaProdotto.quantita == 0 ) {
				System.out.println("Prodotto non disponibile");
				return;
			}
			
			// controllo moneta
			if (!controlloMoneta(scanner, sceltaProdotto)) {
				return;
			}
			
			// controllo bicchieri
			if (this.bicchieri == 0) {
				System.out.println("Bicchiere non disponibile");
				System.out.println("Erogazione denaro inserito");
				return;
			}
			
			int zucchero = controlloZucchero(scanner);
			
			// controllo bacchette
			if (this.bacchette == 0) {
				System.out.println("Bacchetta esaurita");
			} else {
				this.bacchette--;
			}
			
			System.out.println("Prodotto erogato");
			
			// Aggiornamento
			this.bicchieri--;
			this.cubettiZucchero -= zucchero;
			sceltaProdotto.quantita--;
			
		} else {
			// controllo FREDDA
			
			// controllo di quantita
			if (sceltaProdotto.quantita > 0 ) {
				
				// controllo moneta
				if (controlloMoneta(scanner, sceltaProdotto)) {
					System.out.println("Prodotto erogato!");
					sceltaProdotto.quantita--;
				}
				
			}
		}
	}
	
	public int controlloZucchero(Scanner scanner) {
		int zucchero = 0;
		
		do {
			System.out.println(String.format("Inserire quantita zucchero (%d disponibile)", this.cubettiZucchero));
			zucchero = scanner.nextInt();
			
			if (zucchero > this.cubettiZucchero) {
				System.out.println("Zucchero insufficiente");
			} else if (zucchero > 5) {
				System.out.println("Inserire una quantita tra 0 - 5");
			} 
			
		} while (zucchero > 5 || zucchero > this.cubettiZucchero);
		
		return zucchero;
	}
	
	public boolean controlloMoneta(Scanner scanner, Prodotto prodotto) {
		//credito del distributore mentre l'utente inserisce moneta
		double credito = 0; 
		double inputCredito = 0;
		double prezzo = prodotto.prezzo;
		//loop principale per l'inserimento della moneta
		while (credito < prodotto.prezzo) {
			System.out.println("Premere 99 per cancellare l'operazione");
			System.out.printf("Inserisci moneta: %.2f", prezzo - credito);
			inputCredito = scanner.nextDouble();
			
			if (inputCredito == 99) {
				System.out.println("Operazione cancellata");
				System.out.println("Erogazione resto! " + credito);
				return false;
			} else {
				credito += inputCredito;  
			}
		}
		return true;
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
		categorie[0].controlloAggiuntivo = true;
	}
}
