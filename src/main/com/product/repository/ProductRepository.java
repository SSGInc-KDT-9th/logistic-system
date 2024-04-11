package main.com.product.repository;

import main.com.product.domain.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    List<Product> findByName(String name);
    List<Product> findBySupplyName(String supplyName);
    Long save(Product product);
    Long update(Product product);
    void delete(Product product);
    List<Long> delete(List<Product> products);

    void deleteAll();
}
