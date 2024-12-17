package DistributoreBevande;

import java.util.ArrayList;
import java.util.Scanner;

public class GestoreDistributore {
    private ArrayList<Prodotto> prodotti;
    private ArrayList<Prodotto>Pvenduti;
    private double credito;
    private boolean operatore;
    private double cassa;
    private int vendite;
 int zucchero;
 int palette;
 int bicchieri;
 

    // Costruttore per inizializzare il credito e la lista dei prodotti
    public GestoreDistributore() {
        credito = 10;
        operatore = false;
        Pvenduti = new ArrayList<>();
        prodotti = new ArrayList<>();
        prodotti.add(new Prodotto("coca-cola", "fredda", 3, 10));
        prodotti.add(new Prodotto("fanta", "fredda", 3, 10));
        prodotti.add(new Prodotto("acqua", "fredda", 1, 10));
        prodotti.add(new Prodotto("the pesca", "fredda", 2, 10));
        prodotti.add(new Prodotto("the limone", "fredda", 2, 10));
        prodotti.add(new Prodotto("energy-drink", "fredda", 4, 10));
        //inizializziamo anche i prodotti caldi

        prodotti.add(new Prodotto("acqua", "fredda", 1, 10));
        prodotti.add(new Prodotto("the pesca", "fredda", 2, 10));
        prodotti.add(new Prodotto("the limone", "fredda", 2, 10));
        prodotti.add(new Prodotto("energy-drink", "fredda", 4, 10));
    }

    public void mostraProdotti() {
        System.out.println("\n--- Lista Prodotti ---");
        for (int i = 0; i < prodotti.size(); i++) {
            System.out.println(i + ". " + prodotti.get(i));
        }
    }

    public void ritiraResto() {
        System.out.println("Ecco il tuo resto: €" + credito);
        credito = 0;
    }

    public void inserisciDenaro(Scanner scanner) {
    	System.out.println("inserisci importo");
    	int denaro = scanner.nextInt();
    	credito += denaro;
    	System.out.println("hai inserito €");
    	System.out.println("nuovo credito aggiornato"+credito);
    }
      /*  System.out.println("Hai inserito €5.");
        credito += 5;
        System.out.println("Credito aggiornato: €" + credito); 
    }     */
    	

    public void acquistaProdotto(Scanner scanner) {
        System.out.println("\n--- Acquisto prodotto ---");
        System.out.print("Inserisci il numero del prodotto da acquistare (0-" + (prodotti.size() - 1) + "): ");
        int id = scanner.nextInt();

        if (id < 0 || id >= prodotti.size()) {
            System.out.println("Errore: id non valido.");
        } else {
            Prodotto prodotto = prodotti.get(id);
            if (credito < prodotto.getprezzo()) {
                System.out.println("Credito insufficiente. Inserire più denaro.");
            } else if (prodotto.quantita() <= 0) {
                System.out.println("Prodotto esaurito. Scegli un altro prodotto.");
            } else {
                // Acquisto riuscito
                credito -= prodotto.getprezzo();
                prodotto.riduciquantita();
                System.out.println("Hai acquistato: " + prodotto.getnome());
                System.out.println("Credito residuo: €" + credito);
                vendite++;
                cassa+= prodotto.getprezzo();
                Pvenduti.add(new Prodotto(prodotto.getnome(), prodotto.getcat(), 3, 1));
                
            }
        }
    }

    public void modalitaOperatore(Scanner scanner) {
        operatore = true;
        while (operatore) {
            System.out.println("\n--- Menu Operatore ---");
            System.out.println("1. Modifica prezzo prodotto");
            System.out.println("2. Aggiungi nuovo prodotto");
            System.out.println("3. Rimuovi prodotto");
            System.out.println("4. stampa registro");
            System.out.println("0. Esci dalla modalità operatore");

            System.out.print("Seleziona un'opzione: ");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 0:
                    System.out.println("Uscita dalla modalità Operatore.");
                    operatore = false;
                    break;

                case 1: // Modifica prezzo prodotto
                    System.out.print("Inserisci l'indice del prodotto da modificare (0-" + (prodotti.size() - 1) + "): ");
                    int indice = scanner.nextInt();

                    if (indice < 0 || indice >= prodotti.size()) {
                        System.out.println("Errore: indice non valido.");
                    } else {
                        System.out.print("Inserisci il nuovo prezzo per " + prodotti.get(indice).getnome() + ": ");
                        int nuovoPrezzo = scanner.nextInt();
                        prodotti.get(indice).setprezzo(nuovoPrezzo);
                        System.out.println("Prezzo aggiornato.");
                    }
                    break;

                case 2: // Aggiungi nuovo prodotto
                    System.out.print("Inserisci il nome del nuovo prodotto: ");
                    String nome = scanner.next();
                    System.out.print("Inserisci la categoria del prodotto: ");
                    String categoria = scanner.next();
                    System.out.print("Inserisci il prezzo del prodotto: ");
                    int prezzo = scanner.nextInt();
                    System.out.print("Inserisci la quantità del prodotto: ");
                    int quantita = scanner.nextInt();

                    prodotti.add(new Prodotto(nome, categoria, prezzo, quantita));
                    System.out.println("Prodotto aggiunto.");
                    break;

                case 3: // Rimuovi prodotto
                    System.out.print("Inserisci l'indice del prodotto da rimuovere (0-" + (prodotti.size() - 1) + "): ");
                    int rimuoviIndice = scanner.nextInt();

                    if (rimuoviIndice < 0 || rimuoviIndice >= prodotti.size()) {
                        System.out.println("Errore: indice non valido.");
                    } else {
                        prodotti.remove(rimuoviIndice);
                        System.out.println("Prodotto rimosso.");
                    }
                    break;
                case 4: //stampa registro
                	System.out.println("numero prodotti venduti:"+vendite);
                	System.out.println("denaro in cassa: €"+cassa);
                	 
                	        System.out.println("\n--- Lista Prodotti Venduti ---");
                	        for (int i = 0; i < Pvenduti.size(); i++) {
                	            System.out.println(i + ". " + Pvenduti.get(i));
                	        }
                	break;

                default:
                    System.out.println("Opzione non valida.");
            }
        }
    }

    public double getCredito() {
        return credito;
    }
}

