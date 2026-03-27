package AntoninoPalazzolo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    @Column(name = "prestito_id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "catalogo_id", nullable = false)
    private Catalogo catalogo;
    @Column(name = "data_inizio", nullable = false)
    private LocalDate startDate;
    @Column(name = "data_restituzione_prevista", nullable = false)
    private LocalDate finishDate;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate veryDate;

    protected Prestito() {
    }

    public Prestito(Utente utente, Catalogo catalogo, LocalDate startDate) {
        this.utente = utente;
        this.catalogo = catalogo;
        this.startDate = startDate;
        this.finishDate = startDate.plusDays(30);
    }
    // data_restituzione_prevista non viene passata come parametro
    // perché viene calcolata automaticamente a 30 giorni dalla dataInizio.
    // data_restituzione_effettiva non viene passata perché al momento
    // della creazione del prestito il libro non è ancora stato restituito.
    // verrà impostata in seguito tramite il suo setter.
    //se arrivo in tempo a creare tutti i metodi :)


    public UUID getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getVeryDate() {
        return veryDate;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", catalogo=" + catalogo +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", veryDate=" + veryDate +
                '}';
    }
}
