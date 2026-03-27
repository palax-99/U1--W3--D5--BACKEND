package AntoninoPalazzolo.DAO;

import AntoninoPalazzolo.entities.Catalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

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
    }

}
