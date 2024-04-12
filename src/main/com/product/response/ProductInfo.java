package main.com.product.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductInfo {
    private Long id;
    private String productName;
    private Long categoryId;
    private String categoryName;
    private Long supplierId;
    private String supplierName;
    private final Integer inventory;
    private final Integer storePrice;
    private final Integer sellingPrice;

    @Builder
    public ProductInfo(String productName, Long categoryId, String categoryName, Long supplierId, String supplierName, Integer inventory, Integer storePrice, Integer sellingPrice) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.inventory = inventory;
        this.storePrice = storePrice;
        this.sellingPrice = sellingPrice;
    }
}
