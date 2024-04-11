package main.com.product.repository;

import main.com.product.domain.Product;
import main.com.product.domain.SearchDTO;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    List<Product> findByName(String name);
    List<Product> findProduct(SearchDTO searchDTO);
    Long save(Product product);

    List<Long> save(List<Product> products);
    Long update(Product product);
    void delete(Product product);
    List<Long> delete(List<Product> products);

    void deleteAll();
}
