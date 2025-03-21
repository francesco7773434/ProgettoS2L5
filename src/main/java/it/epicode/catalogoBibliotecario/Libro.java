package it.epicode.catalogoBibliotecario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Libro extends Biblioteca {
    private String autore;
    private String genere;

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    @Override
    public void stampaDettagli() {
        System.out.println("Libro: " + titolo);
        System.out.println("Autore: " + autore);
        System.out.println("Genere: " + genere);
        System.out.println("Anno Pubblicazione: " + annoPubblicazione);
        System.out.println("Numero Pagine: " + numeroPagine);
    }
}
