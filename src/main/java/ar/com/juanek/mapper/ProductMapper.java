package ar.com.juanek.mapper;

import ar.com.juanek.model.Product;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM products WHERE productCode = #{code}")
    @Results({
            @Result(column = "productLine", property = "productsLine",
                    one = @One(select = "ar.com.juanek.mapper.ProductLineMapper.findProductLineByCode"))
    })
    Product findProductByCode(@Param("code") String code);

    @Select("SELECT * FROM products WHERE productLine = #{code}")
    List<Product> findProductsByProductLine(@Param("code")String code);

    @Select("SELECT * FROM products WHERE productCode = #{code}")
    Product findByProductCode(@Param("code") String code);

    @Select("SELECT * FROM products ORDER BY productLine")
    List<Product> listProductForProductLine();

    @Select("select productLine,count(productCode) from products group by productLine")
    List<Map<String, Integer>> countProductForProductLine();

    @Select("SELECT AVG((MSRP-buyPrice)/MSRP)*100 FROM products")
    double averagePercentageMarkup();

    @Select("SELECT COUNT(distinct productName) FROM products")
    int distinctProducts();

    @Select("SELECT * from products where not exists " +
            "( SELECT * FROM orderdetails WHERE products.productCode = orderdetails.productCode)")
    List<Product> productsWithoutSales();

    @Select("SELECT p.productName,o.orderDate " +
            "FROM products as p " +
            "INNER JOIN orderdetails AS d ON p.productCode = d.productCode " +
            "INNER JOIN orders AS o ON d.orderNumber = o.orderNumber " +
            "ORDER BY o.orderDate")
    @Results({
            @Result(column = "productName", property = "productName", javaType = String.class),
            @Result(column = "orderDate", property = "orderDate", javaType = LocalDateTime.class)
    })
    List<Map<String, LocalDateTime>> productSoldByDate();

    //SELECT productName  FROM products  WHERE NOT EXISTS  (SELECT * FROM orders  WHERE NOT EXISTS ( SELECT *  FROM orderdetails WHERE orderdetails.orderNumber = orders.orderNumber AND orderdetails.productCode = products.productCode ) );
    @Select("SELECT productName  " +
            "FROM products  " +
            "WHERE NOT EXISTS  " +
            "(SELECT * FROM orders  WHERE NOT EXISTS " +
            "( SELECT *  " +
            "FROM orderdetails " +
            "WHERE orderdetails.orderNumber = orders.orderNumber AND orderdetails.productCode = products.productCode ) )")
    List<String> anyProductsAllOrders();

    //SELECT productName, MSRP FROM products as p INNER JOIN  orderdetails as d ON p.productCode = d.productCode INNER JOIN orders as o ON d.orderNumber = o.orderNumber WHERE priceEach < (0.8*MSRP) AND status='shipped';
    @Select("SELECT p.productName " +
            "FROM products as p " +
            "JOIN  orderdetails as d " +
            "ON p.productCode = d.productCode " +
            "JOIN orders as o " +
            "ON d.orderNumber = o.orderNumber " +
            "WHERE d.priceEach < (0.8*p.MSRP) AND o.status='Shipped'")
    List<String> productsLessThanMRSP();

    @Select("SELECT DISTINCT productName " +
            "FROM products AS p " +
            "JOIN orderdetails AS d ON d.productCode = p.productCode  WHERE d.priceEach >= 2*p.buyPrice;")
    List<String> priceAtLeastTwice();

    @Select("SELECT * " +
            "FROM products " +
            "JOIN orderdetails ON orderdetails.productCode = products.productCode " +
            "JOIN orders ON orders.orderNumber = orderdetails.orderNumber " +
            "WHERE DAYOFWEEK(orders.orderDate) = 1")
    List<Product> orderedMonday();

    @Select("select count(*) from products join orderdetails on orderdetails.productCode = products.productCode join orders on orders.orderNumber = orderdetails.orderNumber where orders.status = 'On Hold';")
    int productOnHold();
}
