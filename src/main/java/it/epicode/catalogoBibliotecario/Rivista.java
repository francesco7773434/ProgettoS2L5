package it.epicode.catalogoBibliotecario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Rivista extends Biblioteca {
    private Periodicità periodicità;



    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicita() {
        return periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    @Override
    public void stampaDettagli() {
        System.out.println("Rivista: " + titolo);
        System.out.println("Periodicità: " + periodicità);
        System.out.println("Anno Pubblicazione: " + annoPubblicazione);
        System.out.println("Numero Pagine: " + numeroPagine);
    }
}
