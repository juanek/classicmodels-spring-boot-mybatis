package ar.com.juanek.mapper;

import ar.com.juanek.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DynamicSQLProviderTest {

    @Autowired
    DynamicMapper dynamicMapper;

    @Test
    void selectMany(){
          List<Product> products = dynamicMapper.selectProducts();

          assertThat(products).isNotEmpty();
    }
}
