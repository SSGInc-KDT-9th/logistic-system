package main.com.product.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductEdit {
    private final String productName;
    private final Long categoryId;
    private final Long supplierId;
    private final String supplierName ;
    @Builder
    public ProductEdit(String productName, Long categoryId, Long supplierId, int supplyPrice, int sellingPrice, int stock, String supplierName) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }
}
