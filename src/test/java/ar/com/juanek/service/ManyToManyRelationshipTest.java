package ar.com.juanek.service;

import ar.com.juanek.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ManyToManyRelationshipTest {

    @Autowired
    private ClassicService service;

    //List products sold by order date.
    @Test
    void productSoldByDate() {
        List<Map<String, LocalDateTime>> mapList = service.productSoldByDate();

        assertThat(mapList)
                .isNotEmpty()
                .first()
                .extracting("orderDate")
                .isInstanceOf(LocalDateTime.class)
                .isEqualTo(LocalDateTime.of(2003, 01, 06, 00, 00));
    }

    //List the order dates in descending order for orders for the 1940 Ford Pickup Truck.
    @Test
    void ordersDateByProductName() {
        List<Map<String, LocalDateTime>> mapList = service.ordersDateByProductName();

        assertThat(mapList)
                .first()
//                .extracting("orderDate")
//                .isInstanceOf(LocalDateTime.class)
                .extracting("productName")
                .isEqualTo("1940 Ford Pickup Truck");

    }

    //List the names of customers and their corresponding order number where a particular order from that customer has a value greater than $25,000?
    @Test
    void customerOrdersGreaterThan() {
        List<Map<String, Double>> mapList = service.customerOrdersGreaterThan();

        assertThat(mapList)
                .isNotEmpty()
                .first()
                .extracting("value")
                .isEqualTo(Double.valueOf(80180.98));

    }

    //Are there any products that appear on all orders?
    @Test
    void anyProductsAllOrders() {
        List<String> stringList = service.anyProductsAllOrders();

        assertThat(stringList).isEmpty();
    }

    //List the names of products sold at less than 80% of the MSRP
    @Test
    void productsLessThan() {
        List<String> stringList = service.productsLessThanMRSP();

        assertThat(stringList)
                .isNotEmpty()
                .anySatisfy(s -> s.equals("1956 Porsche 356A Coupe"));
    }

    //Reports those products that have been sold with a markup of 100% or more
    @Test
    void priceAtLeastTwice() {
        List<String> stringList = service.priceAtLeastTwice();

        assertThat(stringList)
                .isNotEmpty()
                .hasSize(40);
    }

    //List the products ordered on a Monday.
    @Test
    void orderedMonday() {
        List<Product> productList = service.orderedMonday();
        assertThat(productList).isNotEmpty();
    }

    //What is the quantity on hand for products listed on 'On Hold' orders?
    @Test
    void productOnHold() {
        int quantity = service.productOnHold();
        assertThat(quantity)
                .isEqualTo(44);
    }

}
