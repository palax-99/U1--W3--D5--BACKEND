package AntoninoPalazzolo;

import AntoninoPalazzolo.DAO.CatalogoDAO;
import AntoninoPalazzolo.entities.Libro;
import AntoninoPalazzolo.entities.Periodicita;
import AntoninoPalazzolo.entities.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1w3d5");

    //collegamento al database fatto :)
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        CatalogoDAO cl = new CatalogoDAO(em);
        // Creo un'istanza di CatalogoDAO passandogli l'EntityManager
        // che userà per eseguire le operazioni sul database.
        // L'EntityManager viene creato qui nel main/Application e condiviso tra tutti i DAO.

        Libro libro1 = new Libro("1", "Clean Code", 2008, 431, "Robert Martin", "Informatica");
        Libro libro2 = new Libro("2", "Design Patterns", 1994, 395, "Gang of Four", "Informatica");
        Libro libro3 = new Libro("3", "Il Nome della Rosa", 1980, 502, "Umberto Eco", "Romanzo");

        Rivista rivista1 = new Rivista("4", "National Geographic", 2023, 120, Periodicita.MENSILE);
        Rivista rivista2 = new Rivista("5", "The Economist", 2023, 80, Periodicita.SETTIMANALE);

        //cl.saveTheElement(libro1); // commento per evitare di salvare altri dati nel database
        //cl.saveTheElement(libro2);
        //cl.saveTheElement(libro3);
        //cl.saveTheElement(rivista1); //testato il metodo saveTheElement
        //cl.saveTheElement(rivista2);

        //cl.findByIsbn("1"); // testato il metodo cerca per isbn
        //cl.findElementsByIsbnAndDelete("1"); //testato il metodo remove
        cl.findByAnno(1994);
        cl.findByAutore("Umberto Eco");
        em.close();
        emf.close();
    }
}
