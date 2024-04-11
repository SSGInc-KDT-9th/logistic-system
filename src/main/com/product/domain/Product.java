package main.com.product.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Product {
    private Long id;
    private String productName;
    private Long categoryId;
    private Long supplierId;
    private int supplyPrice;
    private int sellingPrice;
    private int stock;

    @Builder
    public Product(String productName, Long categoryId, Long supplierId, int supplyPrice, int sellingPrice, int stock) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.supplyPrice = supplyPrice;
        this.sellingPrice = sellingPrice;
        this.stock = stock;
    }
}