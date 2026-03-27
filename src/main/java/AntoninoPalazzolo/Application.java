package AntoninoPalazzolo;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u1w3d5");

    //collegamento al database fatto :)
    public static void main(String[] args) {


        System.out.println("Hello World!");
    }
}
