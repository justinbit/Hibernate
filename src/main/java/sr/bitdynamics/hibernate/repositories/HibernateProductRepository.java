package sr.bitdynamics.hibernate.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import sr.bitdynamics.hibernate.entities.Product;
import sr.bitdynamics.hibernate.interfaces.ProductRepository;

import java.util.List;
import java.util.Objects;

public class HibernateProductRepository implements ProductRepository {

    private final EntityManagerFactory emf;

    public HibernateProductRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void saveProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Product getProductById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HibernateProductRepository that = (HibernateProductRepository) o;
        return Objects.equals(emf, that.emf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emf);
    }

    @Override
    public String toString() {
        return "HibernateProductRepository{" +
                "emf=" + emf +
                '}';
    }
}
