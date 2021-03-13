package ar.com.juanek.mapper;

import ar.com.juanek.model.Office;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author juanekipes@gmail.com
 */
@Mapper
public interface OfficeMapper {

    @Select("Select * From offices Order By country,state, city")
    List<Office> findOfficesOrdered();

    //implemented in OfficeMapper.xml
    //@Select("select * from offices where officeCode = #{officeCode}")
    Office selectByOfficeCode(String officeCode);


}
