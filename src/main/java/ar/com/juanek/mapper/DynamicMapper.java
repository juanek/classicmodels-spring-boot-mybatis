package ar.com.juanek.mapper;

import ar.com.juanek.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface DynamicMapper {

    @SelectProvider(type =DynamicSQLProvider.class ,method = "selectMany")
    List<Product> selectProducts();

}
