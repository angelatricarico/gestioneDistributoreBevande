package DistributoreBevande;

import java.util.Scanner;

public class Distributore {
	private final int pin = 1010;
	String nome;
	double credito;
	int bicchieri;
	int bacchette;
	int cubettiZucchero;
	Categoria[] categorie;
	private final String[][] prodottiDefault = {
			{ "Caffè stretto", "Caffè lungo", "Cappuccino", "Ginseng", "Thè caldo", "Cioccolata calda",
					"Latte macchiato" },
			{ "Acqua Naturale", "Acqua Frizzante", "Thè limone", "Thè pesca", "Aranciata", "Cola", "Energy drink" } };
	private final String[] nomeCategorie = { "Calda 🔥", "Fredda ❄️" };

	private double incasso;

	public void stampaCategorie() {
		for (int i = 0; i < categorie.length; i++) {
			System.out.println((i + 1) + ": " + categorie[i].nome);
		}
		System.out.println("9: Esci 🚪");
	}

	// Controllo generale dell'erogazione
	public boolean controlloQuantita(Categoria sceltaCategoria, Prodotto sceltaProdotto, Scanner scanner) {

		// differenziare categoria calda e categoria fredda

		if (sceltaCategoria.controlloAggiuntivo == true) {
			// controllo CALDA

			// Controllo Qunatita Prodotto -> Controllo Bicchiere -> Chiedere zucchero ->
			// Controllo bacchette (opzionale) -> Erogazione
			// controllo di quantita
			if (sceltaProdotto.quantita == 0) {
				System.out.println("Prodotto non disponibile ❌");
				return false;
			}

			// controllo moneta
			if (!controlloMoneta(scanner, sceltaProdotto)) {
				return false;
			}

			// controllo bicchieri
			if (this.bicchieri == 0) {
				System.out.println("Bicchiere non disponibile ❌");
				System.out.println("Erogazione denaro inserito ✔️");
				return false;
			}

			int zucchero = controlloZucchero(scanner);

			// controllo bacchette
			if (this.bacchette == 0) {
				System.out.println("Bacchetta esaurita ❌");
			} else {
				this.bacchette--;
			}

			System.out.println("Prodotto erogato ✔️");
			sceltaProdotto.nAcquisti++;
			incasso += sceltaProdotto.getPrezzo();

			// Aggiornamento
			this.bicchieri--;
			this.cubettiZucchero -= zucchero;
			sceltaProdotto.quantita--;

		} else {
			// controllo FREDDA

			// controllo di quantita
			if (sceltaProdotto.quantita > 0) {

				// controllo moneta
				if (controlloMoneta(scanner, sceltaProdotto)) {
					System.out.println("Prodotto erogato! ✔️");
					sceltaProdotto.quantita--;
					sceltaProdotto.nAcquisti++;
					incasso += sceltaProdotto.getPrezzo();
				} else {
					return false;
				}

			}
		}
		return true;
	}

	public int controlloZucchero(Scanner scanner) {
		int zucchero = 0;

		do {
			System.out.println(String.format("Inserire quantita zucchero (%d disponibile) ", this.cubettiZucchero));
			zucchero = scanner.nextInt();

			if (zucchero > this.cubettiZucchero) {
				System.out.println("Zucchero insufficiente ❌");
			} else if (zucchero > 5) {
				System.out.println("Inserire una quantita tra 0 - 5 🧂");
			}

		} while (zucchero > 5 || zucchero > this.cubettiZucchero);

		return zucchero;
	}

	public boolean controlloMoneta(Scanner scanner, Prodotto prodotto) {
		// credito del distributore mentre l'utente inserisce moneta
		double credito = 0;
		double inputCredito = 0;
		double prezzo = prodotto.prezzo;
		// loop principale per l'inserimento della moneta
		while (credito < prodotto.prezzo) {
			System.out.println("Premere 99 per cancellare l'operazione 🔄");
			System.out.printf("Inserisci moneta: € %.2f\n", prezzo - credito);
			System.out.print("-> ");
			inputCredito = scanner.nextDouble();

			if (inputCredito == 99) {
				System.out.println("Operazione cancellata! ❌");
				System.out.println("Erogazione resto! € 💵 " + credito);
				return false;
			} else {
				credito += inputCredito;
			}
		}
		if (credito > prodotto.prezzo) {
			System.out.printf("Erogazione Resto € %.2f 💵 \r ", credito - prodotto.prezzo);
		}
		return true;
	}

	// costruttore della classe
	public Distributore(String nome) {
		this.nome = nome;
		bicchieri = (int) (Math.random() * 21);
		bacchette = (int) (Math.random() * 21);
		cubettiZucchero = (int) (Math.random() * 21);
		this.categorie = new Categoria[2];

		for (int i = 0; i < nomeCategorie.length; i++) {
			Categoria categoria1 = new Categoria(nomeCategorie[i]);
			categorie[i] = categoria1;
			for (int j = 0; j < prodottiDefault[i].length; j++) {
				Prodotto prodotto1 = new Prodotto(prodottiDefault[i][j]);
				categoria1.prodotti.add(prodotto1);
			}
		}
		categorie[0].controlloAggiuntivo = true;
	}

	// metodo OPERATORE
	public boolean modalitaOperatore(Scanner scanner, int pin) {
		if (this.pin == pin) {
			boolean operatore = true;
			while (operatore) {
				System.out.println("\n--- Menu Operatore ---");
				System.out.println("1. Modifica prezzo prodotto");
				System.out.println("2. Aggiungi nuovo prodotto");
				System.out.println("3. Rimuovi prodotto");
				System.out.println("4. stampa registro");
				System.out.println("0. Esci dalla modalità operatore");

				System.out.print("Seleziona un'opzione: ");
				int scelta = scanner.nextInt();
				int sceltaP;
				switch (scelta) {
				case 0:
					System.out.println("Uscita dalla modalità Operatore.");
					operatore = false;
					return true;

				case 1: // Modifica prezzo prodotto
					System.out.println("Scegli Categoria: 1)Calda \n 2)Fredda ");
					sceltaP = scanner.nextInt();
					// Arraylist bevanda calda e fredda
					categorie[sceltaP - 1].stampaProdotti();
					System.out.print("Inserisci prodotto da modificare: ");
					int modificaIndice = scanner.nextInt() - 1;
					// se l utente inserisce numero negativo oppure un numero magg uguale all
					// arraylist di prodotti
					if (modificaIndice < 0 || modificaIndice >= categorie[sceltaP - 1].prodotti.size()) {
						System.out.println("Errore: indice non valido.");
					} else {
						System.out.print("Inserisci il nuovo prezzo per "+ categorie[sceltaP - 1].prodotti.get(modificaIndice).getNome() + ": ");
						double nuovoPrezzo = scanner.nextDouble();
						// controllo
						if (nuovoPrezzo >= 0) {
							categorie[sceltaP - 1].prodotti.get(modificaIndice).setPrezzo(nuovoPrezzo);
							System.out.println("Prezzo aggiornato.");
						} else
							System.out.println("Inserire prezzo valido.");
					}
					break;

				case 2: // Aggiungi nuovo prodotto
					System.out.println("Scegli Categoria: 1)Calda \n 2)Fredda ");
					sceltaP = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Inserisci il nome del nuovo prodotto: ");
					String nome = scanner.nextLine();
					System.out.print("Inserisci il prezzo del prodotto: ");
					double prezzo = scanner.nextDouble();
					System.out.print("Inserisci la quantità del prodotto: ");
					int quantita = scanner.nextInt();
					categorie[sceltaP - 1].prodotti.add(new Prodotto(nome, quantita, prezzo));
					// forse fare controllo prodotto
					System.out.println("Prodotto aggiunto.");
					break;

				case 3: // Rimuovi prodotto
					System.out.println("Scegli Categoria: 1)Calda \n 2)Fredda ");
					sceltaP = scanner.nextInt();
					categorie[sceltaP - 1].stampaProdotti();

					System.out.print("Inserisci prodotto da rimuovere: ");
					int rimuoviIndice = scanner.nextInt() - 1;

					if (rimuoviIndice < 0 || rimuoviIndice >= categorie[sceltaP - 1].prodotti.size()) {
						System.out.println("Errore: indice non valido.");
					} else {
						categorie[sceltaP - 1].prodotti.remove(rimuoviIndice);
						System.out.println("Prodotto rimosso.");
					}
					break;

				case 4: // stampa registro
					// controllo su tutte e due le categorie calda e fredda
					for (int i = 0; i < categorie.length; i++) {
						System.out.println("Gli acquisti della categoria " + categorie[i].nome);
						for (int j = 0; j < categorie[i].prodotti.size(); j++) {
							if (categorie[i].prodotti.get(j).nAcquisti != 0) {
								System.out.println(categorie[i].prodotti.get(j).nome + "-"
										+ categorie[i].prodotti.get(j).nAcquisti);
							}
						}
					}
					System.out.println("TOTALE INCASSO:" + this.incasso);
					break;

				default:
					System.out.println("Opzione non valida.");
				}
			}
		}
		return false;

	}
}
