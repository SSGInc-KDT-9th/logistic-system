package main.com.product.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Category {
    private Long categoryId;
    private String categoryName;
    private Long parentCategoryId;

    @Builder
    public Category(Long categoryId, String categoryName, Long parentCategoryId) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentCategoryId = parentCategoryId;
    }
}
