package main.com.product.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductSearch {
    private Long id;
    private String productName;
    private String supplierName;
    private String categoryName;

    @Builder
    public ProductSearch(Long id, String productName, String supplierName, String categoryName) {
        this.id = id;
        this.productName = productName;
        this.supplierName = supplierName;
        this.categoryName = categoryName;
    }
}
