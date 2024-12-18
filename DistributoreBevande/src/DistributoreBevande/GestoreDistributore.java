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
 int zucchero = 50;
 int palette = 25;
 int bicchieri = 25;
 

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
        prodotti.add(new Prodotto("caffé", "caldo", 1, 10));
        prodotti.add(new Prodotto("the", "caldo", 2, 10));
        prodotti.add(new Prodotto("macchiato", "caldo", 2, 10));
        prodotti.add(new Prodotto("cioccolata", "caldo", 4, 10));
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
            return;
        }

        Prodotto prodotto = prodotti.get(id);

        // Controlla il credito
        if (credito < prodotto.getprezzo()) {
            System.out.println("Credito insufficiente. Inserire più denaro.");
            return;
        }

        // Controlla se il prodotto è disponibile
        if (prodotto.quantita() <= 0) {
            System.out.println("Prodotto esaurito. Scegli un altro prodotto.");
            return;
        }

        // Controllo per prodotti caldi
        if (prodotto.getcat().equalsIgnoreCase("caldo")) {
            // Controlla bicchieri
            if (bicchieri < 1) {
                System.out.println("Impossibile acquistare bevande calde, bicchieri non disponibili.");
                return;
            }

            // Chiedi zucchero
            System.out.print("Selezionare quantità di zucchero (da 0 a 5): ");
            int zuccherato = scanner.nextInt();

            if (zuccherato > zucchero) {
                System.out.println("Non c'è abbastanza zucchero. Procedere senza zucchero? (1: Sì, 2: No): ");
                int risposta = scanner.nextInt();
                if (risposta != 1) return;
                zuccherato = 0;
            }

            zucchero -= zuccherato; // Consuma zucchero

            // Controlla palette
            if (zuccherato > 0 && palette < 1) {
                System.out.print("Non ci sono abbastanza palette. Procedere senza palette? (1: Sì, 2: No): ");
                int risposta = scanner.nextInt();
                if (risposta != 1) return;
            } else if (zuccherato > 0) {
                palette--; // Consuma una paletta
            }

            bicchieri--; // Consuma un bicchiere
        }

        // Acquisto riuscito
        credito -= prodotto.getprezzo();
        prodotto.riduciquantita();
        System.out.println("Hai acquistato: " + prodotto.getnome());
        System.out.println("Credito residuo: €" + credito);

        // Aggiorna statistiche di vendita
        vendite++;
        cassa += prodotto.getprezzo();
        Pvenduti.add(new Prodotto(prodotto.getnome(), prodotto.getcat(), prodotto.getprezzo(), 1));
    }
                
            
        

    public void modalitaOperatore(Scanner scanner) {
        operatore = true;
        while (operatore) {
            System.out.println("\n--- Menu Operatore ---");
            System.out.println("1. Modifica prezzo prodotto");
            System.out.println("2. Aggiungi nuovo prodotto");
            System.out.println("3. Rimuovi prodotto");
            System.out.println("4. stampa registro transazioni");
            System.out.println("5. stampa registro risorse caffetteria");
            System.out.println("6. ricarica risorse caffetteria");
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
                case 5: // Stato bicchieri e palette
                    System.out.println("\n--- Stato Risorse ---");
                    System.out.println("Bicchierini disponibili: " + bicchieri);
                    System.out.println("Zucchero disponibile: " + zucchero + " dosi");
                    System.out.println("Bacchettine disponibili: " + palette);
                    break;
                    
                case 6: // Ricarica risorse
                    System.out.print("Quantità di bicchierini da aggiungere: ");
                    bicchieri += scanner.nextInt();
                    System.out.print("Quantità di zucchero (dosi) da aggiungere: ");
                    zucchero += scanner.nextInt();
                    System.out.print("Quantità di bacchettine da aggiungere: ");
                    palette += scanner.nextInt();
                    System.out.println("Risorse ricaricate con successo.");
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
