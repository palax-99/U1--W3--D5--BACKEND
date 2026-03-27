package AntoninoPalazzolo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "utente_id")
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "cognome", nullable = false)
    private String surname;
    @Column(name = "data_di_nascita", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "numero_tessera", nullable = false, unique = true)
    private String numberOfTessera;

    protected Utente() {
    }

    public Utente(String name, String surname, LocalDate dateOfBirth, String numberOfTessera) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.numberOfTessera = numberOfTessera;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNumberOfTessera() {
        return numberOfTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfTessera='" + numberOfTessera + '\'' +
                '}';
    }
}
