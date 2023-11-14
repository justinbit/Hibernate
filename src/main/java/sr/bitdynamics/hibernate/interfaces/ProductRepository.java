package sr.bitdynamics.hibernate.interfaces;

import sr.bitdynamics.hibernate.entities.Product;

import java.util.List;

public interface ProductRepository {
    void saveProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();
}
