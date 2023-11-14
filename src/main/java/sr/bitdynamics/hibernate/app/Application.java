package sr.bitdynamics.hibernate.app;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import sr.bitdynamics.hibernate.entities.Product;
import sr.bitdynamics.hibernate.interfaces.ProductRepository;
import sr.bitdynamics.hibernate.persistence.CustomPersistenceUnitInfo;
import sr.bitdynamics.hibernate.repositories.HibernateProductRepository;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap<>());

        ProductRepository productRepository = new HibernateProductRepository(emf);

        // Example of saving a product
        Product product = new Product("Bread");
        productRepository.saveProduct(product);
//        productRepository.getProductById(1L);
//        System.out.println("stm: " + productRepository.getProductById(1L).toString());

        // Other operations using the productRepository
}
}
