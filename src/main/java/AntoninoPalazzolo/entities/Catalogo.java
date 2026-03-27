package AntoninoPalazzolo.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "catalog_type")
@Table(name = "catalogo")
// dò il nome alla colonna che generà automaticamente la strategia single_table
public abstract class Catalogo {
    @Id
    @GeneratedValue
    @Column(name = "catalogo_id")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private String titolo;
    @Column(name = "anno_pubblicazione", nullable = false)
    private int annoPubblicazione;
    @Column(name = "numero_pagine", nullable = false)
    private int numeroPagine;

    protected Catalogo() {
    }

    public Catalogo(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public UUID getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}


