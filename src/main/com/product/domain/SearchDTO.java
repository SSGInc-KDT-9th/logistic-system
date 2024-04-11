package main.com.product.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchDTO {
    private Long id ;
    private String productName;
    private String supplyName;

    @Builder
    public SearchDTO(Long id, String productName, String supplyName) {
        this.id = id;
        this.productName = productName;
        this.supplyName = supplyName;
    }
}
