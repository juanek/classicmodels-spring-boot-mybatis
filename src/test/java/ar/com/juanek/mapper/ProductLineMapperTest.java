package ar.com.juanek.mapper;

import ar.com.juanek.mapper.ProductLineMapper;
import ar.com.juanek.model.ProductLine;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductLineMapperTest {

    @Autowired
    ProductLineMapper productLineMapper;

    @Test
    void findAll() {
        List<ProductLine> productLineList = productLineMapper.findAll();

        assertThat(productLineList)
                .isNotEmpty()
                .first()
                .satisfies(productLine -> assertThat(productLine.getProductLine()).isNotEmpty());
    }

    @Test
    void findProductLineCars(){
        List<ProductLine> productLineList = productLineMapper.findProductLineCars();

        assertThat(productLineList)
                .isNotEmpty()
                .first()
                .satisfies(productLine -> assertThat(productLine.getProductLine()).contains("Cars"));
    }

    @Test
    void findProductLineById(){
        String code = "Motorcycles";
        ProductLine productLine = productLineMapper.findProductLineByCode(code);

        assertThat(productLine)
                .isNotNull()
                .extracting("productLine").isEqualTo(code);
    }

    @Test
    void productsLineWithProducts(){
        String code = "Planes";
        ProductLine productLine = productLineMapper.findProductLineByCode(code);

        assertThat(productLine)
                .isNotNull()
                .extracting("productLine").isEqualTo(code);

        assertThat(productLine.getProducts()).isNotEmpty();
    }
}
