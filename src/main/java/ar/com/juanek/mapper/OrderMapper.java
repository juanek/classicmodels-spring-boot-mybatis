package ar.com.juanek.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    @Select("SELECT orderNumber,SUM(priceEach*quantityOrdered) AS price " +
            "FROM orderdetails " +
            "GROUP BY orderNumber " +
            "HAVING SUM(priceEach*quantityOrdered) > 5000 ")
    List<Map<String, Double>> ordersGreaterThan();

    @Select("SELECT sum(d.quantityOrdered*d.priceEach) AS value " +
            "FROM orders AS o INNER JOIN orderdetails AS d " +
            "USING (orderNumber) " +
            "WHERE o.status = 'On Hold'")
    double valueOnHoldStatus();


    @Select("SELECT c.customerName,count(*) " +
            "FROM customers as c " +
            "INNER JOIN orders AS o " +
            "USING (customerNumber) " +
            "WHERE o.status = 'On Hold' " +
            "GROUP BY c.customerNumber")
    List<Map<String,Double>> ordersOnHoldForCustomer();

    //SELECT p.productName,o.orderDate FROM products as p INNER JOIN orderdetails as d USING (productCode) INNER JOIN orders as o USING(orderNumber) WHERE p.productName = '1940 Ford Pickup Truck' ORDER BY o.orderDate DESC;
    @Select("SELECT p.productName,o.orderDate " +
            "FROM products as p " +
            "INNER JOIN orderdetails AS d ON p.productCode = d.productCode " +
            "INNER JOIN orders AS o ON d.orderNumber = o.orderNumber " +
            "WHERE p.productName = '1940 Ford Pickup Truck' " +
            "ORDER BY o.orderDate DESC")
    @Results({
            @Result(column = "productName",property = "productName",javaType = String.class),
            @Result(column = "orderDate",property = "orderDate",javaType = LocalDateTime.class)
    })
    List<Map<String, LocalDateTime>> ordersDateByProductName();
}
