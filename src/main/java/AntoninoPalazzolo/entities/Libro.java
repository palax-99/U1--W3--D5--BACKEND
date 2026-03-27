package AntoninoPalazzolo.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("libro")
// Valore che Hibernate inserirà nella colonna "catalog_type"
// per identificare che questa riga appartiene a un Libro
// (e non a una Rivista)
public class Libro extends Catalogo {
    private String autore;
    private String genere;

    protected Libro() {
    }

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
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
                "} " + super.toString();
    }
}
