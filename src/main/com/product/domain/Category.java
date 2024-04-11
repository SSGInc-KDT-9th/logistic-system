package main.com.product.domain;

import lombok.Getter;

@Getter
public class Category {
    private Long categoryId;
    private String categoryName;
    private Long parentCategoryId;

    public Category(Long categoryId, String categoryName, Long parentCategoryId) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentCategoryId = parentCategoryId;
    }
}
