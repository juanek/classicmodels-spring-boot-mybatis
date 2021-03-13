package ar.com.juanek.mapper;

import ar.com.juanek.model.ProductLine;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductLineMapper {

    @Select("SELECT * FROM productlines WHERE productLine = #{code}")
    @Results({
            @Result(id = true, column = "productLine", property = "productLine"),
            @Result(column = "textDescription", property = "textDescription"),
            @Result(column = "htmlDescription", property = "htmlDescription"),
            @Result(column = "image", property = "image"),
            @Result(column = "productLine", property = "products"
                    , many = @Many(select = "ar.com.juanek.mapper.ProductMapper.findProductsByProductLine"))
    }
    )
    ProductLine findProductLineByCode(@Param("code") String code);

    @Select("SELECT * FROM productlines")
    List<ProductLine> findAll();

    @Select("SELECT * FROM productlines WHERE productLine LIKE '%Cars%'")
    List<ProductLine> findProductLineCars();

}
