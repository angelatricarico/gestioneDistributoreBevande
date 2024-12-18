package DistributoreBevande;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestoreDistributore distributore = new GestoreDistributore();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {				 // Menu principale
           
            System.out.println("\n--- Distributore Automatico ---");
            System.out.println("1. Visualizza lista prodotti");
            System.out.println("2. Ritira resto");
            System.out.println("3. Inserisci denaro");
            System.out.println("4. Acquista un prodotto");
            System.out.println("5. Esci");
            System.out.println("(Il tuo credito è €" + distributore.getCredito() + ")");

            System.out.print("Seleziona un'opzione: ");				//switch per scegliere
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    distributore.mostraProdotti();
                    break;
                case 2:
                    distributore.ritiraResto();
                    break;
                case 3:
                    distributore.inserisciDenaro(scanner);
                    break;
                case 4:
                    distributore.acquistaProdotto(scanner);
                    break;
                case 1984:
                    distributore.modalitaOperatore(scanner);
                    break;
                case 5:
                    System.out.println("Grazie per aver usato il distributore. A presto!");
                    running = false;
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }
        scanner.close();
    }
}

	

