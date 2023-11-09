package sr.bitdynamics.hibernate.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.jpa.HibernatePersistenceProvider;
import sr.bitdynamics.hibernate.entities.Product;
import sr.bitdynamics.hibernate.persistence.CustomPersistenceUnitInfo;

import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap<>());


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();



        try {

            Long id = 3L;
            String name = "Pie";
            Product p = new Product(id, name);

            em.getTransaction().begin();
            em.persist(p);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
