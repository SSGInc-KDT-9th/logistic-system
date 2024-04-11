package test;

import main.com.product.domain.Product;
import main.com.product.domain.SearchDTO;
import main.com.product.repository.MySqlProductRepository;
import main.com.product.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MySqlProductRepositoryTest {
    private ProductRepository productRepository = new MySqlProductRepository();

    @AfterEach
    void clean(){
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("DB 삽입 조회 테스트")
    void test1() throws Exception {
        //given
        Product product = Product.builder()
                .productName("TEST")
                .supplyPrice(100)
                .sellingPrice(120)
                .stock(10)
                .build();
        //when
        Long saveId = productRepository.save(product);
        Product expectProduct = productRepository.findById(saveId);
        //then
        //Assertions.assertEquals(product.getId(),expectProduct.getId());
        Assertions.assertEquals(product.getProductName(),expectProduct.getProductName());
        Assertions.assertEquals(product.getSellingPrice(),expectProduct.getSellingPrice());
        Assertions.assertEquals(product.getSupplyPrice(),expectProduct.getSupplyPrice());
    }
    @Test
    @DisplayName("상품 이름으로 조회 테스트")
    void test2() throws Exception {
        //given
        List<Product> products = IntStream.range(1,31)
                .mapToObj(i-> Product.builder()
                        .productName("이름 " + i)
                        .supplyPrice(i)
                        .sellingPrice(i*10)
                        .build())
                .collect(Collectors.toList());

        //when
        List<Long> saveIds = productRepository.save(products);
        List<Product> expects = productRepository.findByName("이름");
        //then
        Assertions.assertEquals(expects.size(),30);
        Assertions.assertEquals(saveIds.get(0),expects.get(0).getId());
    }

    @Test
    @DisplayName("상품 공급 기업명 조회 테스트")
    void test3() throws Exception {
        //given
        List<Product> products = IntStream.range(1,31)
                .mapToObj(i-> Product.builder()
                        .productName("이름 " + i)
                        .supplierId(1L)
                        .supplyPrice(i)
                        .sellingPrice(i*10)
                        .build())
                .collect(Collectors.toList());
        SearchDTO search = SearchDTO.builder()
                .supplyName("빙그레").build();
        //when
        List<Long> saveIds = productRepository.save(products);
        List<Product> expects = productRepository.findProduct(search);
        //then
        Assertions.assertEquals(expects.size(),30);
        Assertions.assertEquals(expects.get(0).getProductName(), products.get(0).getProductName());
    }

    @Test
    @DisplayName("상품 저장 테스트")
    void test4() throws Exception {
        //given
        Product product = Product.builder()
                .productName("투게더")
                .categoryId(2L)
                .supplierId(1L)
                .supplyPrice(3000)
                .sellingPrice(5000)
                .stock(100)
                .build();
        Long saveId = productRepository.save(product);
        //when
        Product expectProduct = productRepository.findById(saveId);
        //then
        Assertions.assertEquals(expectProduct.getId(),product.getId());
        Assertions.assertEquals(expectProduct.getProductName(),product.getProductName());
        Assertions.assertEquals(expectProduct.getCategoryId(),product.getCategoryId());
        Assertions.assertEquals(expectProduct.getSupplierId(),product.getSupplierId());
    }

    @Test
    @DisplayName("상품 여러개 동시 저장 테스트")
    void test5() throws Exception {
        //given
        List<Product> products = IntStream.range(0,30)
                .mapToObj(i-> Product.builder()
                        .productName("이름 " + i)
                        .supplierId(1L)
                        .supplyPrice(i)
                        .sellingPrice(i*10)
                        .build())
                .collect(Collectors.toList());
        List<Long> saveIds = productRepository.save(products);
        //expect
        for(int i=0; i<products.size(); i++){
            Long id = saveIds.get(i);
            Product product = products.get(i);
            Product expectProduct = productRepository.findById(id);
            Assertions.assertEquals(expectProduct.getId(),product.getId());
            Assertions.assertEquals(expectProduct.getProductName(),product.getProductName());
            Assertions.assertEquals(expectProduct.getCategoryId(),product.getCategoryId());
            Assertions.assertEquals(expectProduct.getSupplierId(),product.getSupplierId());
        }
    }
}