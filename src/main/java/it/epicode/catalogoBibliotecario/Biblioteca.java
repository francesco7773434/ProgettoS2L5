package it.epicode.catalogoBibliotecario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public abstract class Biblioteca {
    protected String isbn;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;

    public Biblioteca (String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }
    public String toString() {
        return "Biblioteca{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public abstract void stampaDettagli();




}
