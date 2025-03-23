package it.epicode.catalogoBibliotecario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1. Aggiungi Elemento");
                System.out.println("2. Visualizza Catalogo");
                System.out.println("3. Cerca Elemento");
                System.out.println("4. Rimuovi Elemento");
                System.out.println("5. Cerca Elemento per Anno Pubblicazione");
                System.out.println("6. Cerca Elemento per autore");
                System.out.println("7. Aggiorna Elemento");
                System.out.println("8. Aggiorna Elemento");
                System.out.println("9. Stampa Statistiche");
                System.out.print("Scegli un'opzione: ");
                int scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1:
                        archivio.aggiungiElemento();
                        break;
                    case 2:
                        archivio.visualizzaCatalogo();
                        break;
                    case 3:

                            archivio.cercaElementoPerISBN(scanner);

                        break;
                    case 4:

                        archivio.rimuoviElementoPerISBN(String.valueOf(scanner));
                        break;
                    case 5:

                        System.out.print("Inserisci l'anno di pubblicazione: ");
                        int annoPubblicazione = Integer.parseInt(scanner.nextLine());
                        archivio.cercaElementoPerAnnoPubblicazione(annoPubblicazione);

                        break;
                    case 6:
                        System.out.print("Inserisci l'autore: ");
                        String autore = scanner.nextLine();
                        archivio.cercaElementoPerAutore(autore);
                        break;
                    case 7:
                        archivio.aggiornaElemento(scanner);
                        break;
                    case 8:
                        archivio.stampaStatistiche();
                        break;

                    case 9:
                        System.out.println("Uscita dal programma.");
                        return;
                    default:
                        System.out.println("Opzione non valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: Devi inserire un numero valido.");
            } catch (Exception e) {
                System.out.println("Errore imprevisto: " + e.getMessage());
            }
        }
    }
}
