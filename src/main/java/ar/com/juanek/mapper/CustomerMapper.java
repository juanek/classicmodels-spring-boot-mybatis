package ar.com.juanek.mapper;

import ar.com.juanek.model.Customer;
import ar.com.juanek.model.Payments;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {

    @Select("SELECT * " +
            "FROM customers " +
            "WHERE customerNumber = #{number}")
    Customer findCustomerByNumber(long number);

    @Select("SELECT customerName,city " +
            "FROM customers " +
            "WHERE salesRepEmployeeNumber IS NULL")
    List<Customer> customersWithoutSalesRepresentative();

    @Select("SELECT customerName, CONCAT(e.firstName,' ',e.lastName)" +
            " FROM customers AS c INNER JOIN employees AS e" +
            " ON c.salesRepEmployeeNumber = e.employeeNumber;")
    List<Customer> accountRepresentative();


    // select c.customerName,paymentDate,amount from payments inner join customers as c using(customerNumber) where c.customerName = 'Atelier
    // graphique';
    @Select("SELECT * " +
            "FROM payments " +
            "INNER JOIN customers AS c " +
            "USING(customerNumber) " +
            "WHERE c.customerName = #{name}")
    @Results({
            @Result(id = true, column = "checkNumber", property = "checkNumber"),
            @Result(column = "paymentDate", property = "paymentDate"),
            @Result(column = "amount", property = "amount"),
            @Result(column = "customerNumber", property = "customer",
                    one = @One(select = "ar.com.juanek.mapper.CustomerMapper.findCustomerByNumber"))
    })
    List<Payments> paymentsByCustomerName(String name);

    //select count(*) from customers as c inner join orders as o using(customerNumber) where c.customerName = 'Herkku Gifts';
    @Select("SELECT count(*) " +
            "FROM customers AS c " +
            "INNER JOIN orders AS o " +
            "USING(customerNumber) " +
            "WHERE c.customerName = 'Herkku Gifts'")
    int countOrdersByCustomer();

    @Select("SELECT c.customerName,sum(d.quantityOrdered*d.priceEach) as value " +
            "FROM customers AS c " +
            "INNER JOIN orders AS o ON c.customerNumber = o.customerNumber " +
            "INNER JOIN orderdetails AS d ON o.orderNumber = d.orderNumber " +
            "GROUP BY c.customerNumber " +
            "HAVING value > 25000")
    @Results({
            @Result(column = "customerName", property = "customerName", javaType = String.class),
            @Result(column = "value", property = "value", javaType = Double.class)
    })
    List<Map<String, Double>> customerOrdersGreaterThan();

}
