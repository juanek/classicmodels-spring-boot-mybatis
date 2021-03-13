package ar.com.juanek.mapper;

import ar.com.juanek.model.Product;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;

    @Test
    void findProduct() {
        String code = "S700_4002";
        Product product = productMapper.findByProductCode(code);

        assertThat(product)
                .isNotNull()
                .hasFieldOrPropertyWithValue("productCode", code);
    }

    @Test
    void anyProductsAllOrders() {
        List<String> stringList = productMapper.anyProductsAllOrders();

        assertThat(stringList).isEmpty();
    }

    @Test
    void productWithProductLines() {
        String code = "S700_4002";
        Product product = productMapper.findProductByCode(code);
        assertThat(product)
                .isNotNull()
                .hasFieldOrPropertyWithValue("productCode", code);

        assertThat(product.getProductLine())
                .isNotNull();

        assertThat(product.getProductLine().getProductLine()).isEqualTo("Planes");
    }

    @Test
    void findProductsByProductLine(){
        String code = "Planes";
        List<Product>  products = productMapper.findProductsByProductLine(code);

        assertThat(products).isNotEmpty();
    }

}
