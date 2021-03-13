package ar.com.juanek.mapper;

import ar.com.juanek.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author juanekipes@gmail.com
 */
@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employees WHERE employeeNumber=#{employeeNumber}")
    Employee findEmployee(int employeeNumber);
    @Select("SELECT count(*) FROM employees")
    int countEmployee();

    @Select("SELECT CONCAT(firstname,' ',lastname) FROM employees WHERE jobTitle LIKE '%VP%' OR jobTitle LIKE '%Manager%'")
    List<String> namesOfExecutives();

    @Select("SELECT * FROM employees AS e INNER JOIN offices AS o WHERE o.city = 'Boston'")
    List<Employee> fromBoston();

}
