package AntoninoPalazzolo.DAO;

import AntoninoPalazzolo.entities.Catalogo;
import AntoninoPalazzolo.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void saveTheElement(Catalogo newCatalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newCatalogo);

        transaction.commit();

        System.out.println("L'elemento " + newCatalogo.getTitolo() + " è stato salvato correttamente!");
    }

    public Catalogo findByIsbn(String isbn) {
        TypedQuery<Catalogo> query = em.createQuery(
                "SELECT c FROM Catalogo c WHERE c.isbn = :isbn",
                Catalogo.class
        );
        query.setParameter("isbn", isbn);
        Catalogo found = query.getSingleResult();
        System.out.println("Elemento trovato: " + found);
        return found;
        // Creo una query JPQL che cerca un elemento del catalogo
        // il cui ISBN corrisponde a quello passato come parametro.
        // Uso getSingleResult() perché ISBN è unique — esiste sempre un solo risultato.
        //non apro la transaction perchè è un metodo di lettura
    }


    public void findElementsByIsbnAndDelete(String isbn) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Catalogo a WHERE a.isbn = :isbn");
        query.setParameter("isbn", isbn);

        query.executeUpdate();

        transaction.commit();

        System.out.println("L'elemento è stato cancellato!");
        // Prima trovo l'elemento tramite ISBN usando il metodo findByIsbn.
        // Non uso em.find() perché ISBN non è la PK — è un campo univoco.
        // Poi apro la transazione, rimuovo l'elemento e faccio il commit.
    }

    public List<Catalogo> findByAnno(int annoPubblicazione) {
        TypedQuery<Catalogo> query = em.createQuery(
                "SELECT c FROM Catalogo c WHERE c.annoPubblicazione = :annoPubblicazione",
                Catalogo.class
        );
        query.setParameter("annoPubblicazione", annoPubblicazione);
        List<Catalogo> found = query.getResultList();
        // Cerco tutti gli elementi del catalogo pubblicati in un certo anno.
        // Uso getResultList() invece di getSingleResult() perché possono
        // esserci più elementi pubblicati nello stesso anno.

        System.out.println("Elemento trovato: " + found);
        return found;
    }

    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = em.createQuery(
                "SELECT c FROM Libro c WHERE c.autore = :autore",
                Libro.class
        );
        query.setParameter("autore", autore);
        List<Libro> found = query.getResultList();
        // Cerco tutti i libri di un determinato autore.
        // Uso Libro invece di Catalogo nella query JPQL perché
        // il campo autore esiste solo nella classe Libro e non in Catalogo.
        // Uso getResultList() perché un autore può avere più libri.
        System.out.println("Elemento trovato: " + found);
        return found;
    }

    public List<Catalogo> findByTitoloOrParteDiEssa(String titolo) {
        TypedQuery<Catalogo> query = em.createQuery(
                "SELECT c FROM Catalogo c WHERE c.titolo LIKE :titolo", Catalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        List<Catalogo> found = query.getResultList();
        // Cerco tutti gli elementi del catalogo il cui titolo contiene
        // la stringa passata come parametro, anche parzialmente.
        // Il simbolo % prima e dopo il parametro indica "qualsiasi cosa
        // prima e dopo"
        System.out.println("Elemento trovato: " + found);
        return found;
    }


}
