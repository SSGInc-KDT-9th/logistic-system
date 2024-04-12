package main.com.product.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductCreate {
    private Long categoryId;
    private Long supplierId;
    private String supplierName;
    private String productName;


    @Builder
    public ProductCreate(Long categoryId, Long supplierId, String supplierName, String productName) {
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.productName = productName;
    }
}
