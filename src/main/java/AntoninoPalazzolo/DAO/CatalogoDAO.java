package AntoninoPalazzolo.DAO;

import AntoninoPalazzolo.entities.Catalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

}
