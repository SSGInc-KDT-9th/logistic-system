package main.com.product.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private Long id;
    private Long categoryId;
    private Long supplierId;
    private String supplierName;
    private String productName;

    @Builder
    public Product(Long categoryId, Long supplierId, String supplierName, String productName) {
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.productName = productName;
    }

    public ProductEdit.ProductEditBuilder toEditor(){
        return ProductEdit.builder()
                .categoryId(categoryId)
                .supplierId(supplierId)
                .supplierName(supplierName)
                .productName(productName);
    }

    public void edit(ProductEdit editor){
        categoryId = editor.getCategoryId();
        supplierId = editor.getSupplierId();
        productName = editor.getProductName();
    }
}
