package it.epicode.catalogoBibliotecario;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Archivio {

   private Map<String, Biblioteca> catalogo = new HashMap<>();


   public void aggiungiElemento() throws ElementoDuplicatoException{
       Scanner scanner = new Scanner(System.in);

       try {
           System.out.println("Inserisci l'ISBN dell'elemento:");
           String isbn = scanner.nextLine();

           if (catalogo.containsKey(isbn)) {
               throw new ElementoDuplicatoException("Elemento con ISBN " + isbn + " già presente nel catalogo.");

           }
           System.out.print("Inserisci Titolo: ");
           String titolo = scanner.nextLine();

           System.out.print("Inserisci Anno di Pubblicazione: ");
           int annoPubblicazione = Integer.parseInt(scanner.nextLine());

           System.out.print("Inserisci Numero di Pagine: ");
           int numeroPagine = Integer.parseInt(scanner.nextLine());

           System.out.print("Vuoi aggiungere un libro (L) o una rivista (R)? ");
           String tipo = scanner.nextLine();

           if (tipo.equalsIgnoreCase("L")) {
               System.out.print("Inserisci Autore: ");
               String autore = scanner.nextLine();
               System.out.print("Inserisci Genere: ");
               String genere = scanner.nextLine();
               Libro libro = new Libro(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere);
               catalogo.put(isbn, libro);
               System.out.println("Libro aggiunto con successo.");
           } else if (tipo.equalsIgnoreCase("R")) {
               System.out.print("Inserisci Periodicità (SETTIMANALE, MENSILE, SEMESTRALE): ");

               try {
                   Periodicità periodicità = Periodicità.valueOf(scanner.nextLine().toUpperCase());
                   Rivista rivista = new Rivista(isbn, titolo, annoPubblicazione, numeroPagine, periodicità);
                   catalogo.put(isbn, rivista);
                   System.out.println("Rivista aggiunta con successo.");
               } catch (IllegalArgumentException e) {
                   System.out.println("Periodicità non valida. Riprova.");
               }
           }

       }  catch (ElementoDuplicatoException e) {
           System.out.println("Errore: " + e.getMessage());
       } catch (NumberFormatException e) {
           System.out.println("Errore: Devi inserire un numero valido per l'anno di pubblicazione e il numero di pagine.");
       } catch (Exception e) {
           System.out.println("Errore inaspettato: " + e.getMessage());
       }


   }
       public void visualizzaCatalogo() {
           if (catalogo.isEmpty()) {
               System.out.println("Il catalogo è vuoto.");
           } else {
               for (Biblioteca elem : catalogo.values()) {
                   elem.stampaDettagli();
                   System.out.println();
               }
           }
       }

       public void cercaElementoPerISBN(Scanner scanner) throws ElementoNonTrovatoException {
           System.out.println("Inserisci l'ISBN dell'elemento da cercare:");
           String isbn = null;
           try {
               isbn = scanner.nextLine();
           } catch (Exception e) {
               throw new ElementoNonTrovatoException("Elemento con ISBN " + isbn + " non trovato nel catalogo.");
           }

           String finalIsbn = isbn;
           Biblioteca elementoTrovato = catalogo.entrySet().stream()
                   .filter(entry -> entry.getKey().equals(finalIsbn))
                   .map(Map.Entry::getValue)
                   .findFirst()
                   .orElse(null);

           if (elementoTrovato != null) {
               System.out.println("Elemento trovato:" + elementoTrovato);
               elementoTrovato.stampaDettagli();
           } else {
               throw new ElementoNonTrovatoException("Elemento con ISBN " + isbn + " non trovato nel catalogo.");

           }
       }

       public void rimuoviElementoPerISBN(String isbn) throws ElementoNonTrovatoException {
           System.out.println("Inserisci l isbn dell elemento da eliminare");

           try {
               isbn = new Scanner(System.in).nextLine();
           } catch (Exception e) {
               throw new ElementoNonTrovatoException("Elemento con ISBN " + isbn + " non trovato nel catalogo.");
           }
           if (catalogo.containsKey(isbn)) {
               catalogo.remove(isbn);
               System.out.println("Elemento rimosso con successo.");
           } else {
               throw new ElementoNonTrovatoException("Elemento con ISBN " + isbn + " non trovato nel catalogo.");
           }
       }

       public void cercaElementoPerAnnoPubblicazione(int annoPubblicazione) {
           catalogo.values().stream()
                   .filter(elem -> elem.getAnnoPubblicazione() == annoPubblicazione)
                   .forEach(elem -> elem.stampaDettagli());
           System.out.println("Elemento trovato:");
       }

       public void cercaElementoPerAutore(String autore) {
           catalogo.values().stream()
                   .filter(elem -> elem instanceof Libro && ((Libro) elem).getAutore().equals(autore))
                   .forEach(elem -> elem.stampaDettagli());
           System.out.println("Elemento trovato:");
       }


     public void aggiornaElemento(Scanner scanner) throws ElementoNonTrovatoException {

         System.out.println("Inserisci L ISBN dell elemento da aggiornare");

         String isbn = scanner.nextLine();

         Biblioteca elemento = catalogo.get(isbn);

         if (elemento != null) {
             System.out.println("Inserisci il nuovo titolo:");
             String nuovoTitolo = scanner.nextLine();
             System.out.println("Inserisci il nuovo anno di pubblicazione:");
             int nuovoAnnoPubblicazione = Integer.parseInt(scanner.nextLine());
             System.out.println("Inserisci il nuovo numero di pagine:");
             int nuovoNumeroPagine = Integer.parseInt(scanner.nextLine());

             elemento.setTitolo(nuovoTitolo);
             elemento.setAnnoPubblicazione(nuovoAnnoPubblicazione);
             elemento.setNumeroPagine(nuovoNumeroPagine);

             System.out.println("Elemento aggiornato con successo.");
         } else {
             throw new ElementoNonTrovatoException("Elemento con ISBN " + isbn + " non trovato nel catalogo.");
         }

         if(elemento instanceof Libro) {
             System.out.println("Inserisci il nuovo autore:");
             String nuovoAutore = scanner.nextLine();
             System.out.println("Inserisci il nuovo genere:");
             String nuovoGenere = scanner.nextLine();

             Libro libro = (Libro) elemento;
             libro.setAutore(nuovoAutore);
             libro.setGenere(nuovoGenere);

             System.out.println("Elemento aggiornato con successo.");
         }   else if (elemento instanceof Rivista) {
             Rivista rivista = (Rivista) elemento;
             System.out.print("Inserisci nuova Periodicità (SETTIMANALE, MENSILE, SEMESTRALE): ");
             String periodicitaString = scanner.nextLine();
             try {
                 Periodicità nuovaPeriodicità = Periodicità.valueOf(periodicitaString.toUpperCase());
                 rivista.setPeriodicità(nuovaPeriodicità);
             } catch (IllegalArgumentException e) {
                 System.out.println("Periodicità non valida. Riprova.");
             }
         }
         System.out.println("Elemento aggiornato con successo:");
         elemento.stampaDettagli();

     }

    // stampa numero totale dei libri presenti e il totale delle riviste e l elemento con ill maggior numero di pagine e la media delle pagine di tutti gli elementi
    public void stampaStatistiche() {
        long numeroLibri = catalogo.values().stream()
                .filter(elem -> elem instanceof Libro)
                .count();
        System.out.println("Numero totale dei libri presenti: " + numeroLibri);
        long numeroRiviste = catalogo.values().stream()
                .filter(elem -> elem instanceof Rivista)
                .count();
        System.out.println("Numero totale delle riviste presenti: " + numeroRiviste);

        Biblioteca elementoConPagineMax = catalogo.values().stream()
                .max((elem1, elem2) -> Integer.compare(elem1.getNumeroPagine(), elem2.getNumeroPagine()))
                .orElse(null);
        if (elementoConPagineMax != null) {
            System.out.println("Elemento con il maggior numero di pagine:");
            elementoConPagineMax.stampaDettagli();
        }
        double mediaPagine = catalogo.values().stream()
                .mapToInt(Biblioteca::getNumeroPagine)
                .average()
                .orElse(0.0);
            System.out.println("Media delle pagine degli elementi: " + mediaPagine);




    }





}
