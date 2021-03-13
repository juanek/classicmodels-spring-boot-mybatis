package ar.com.juanek.service;

import ar.com.juanek.model.Customer;
import ar.com.juanek.model.Employee;
import ar.com.juanek.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OneToManyRelationshipTest {

    @Autowired
    private ClassicService service;

    //Report the account representative for each customer.
    @Test
    void accountRepresentative() {
        List<Customer> customerList = service.accountRepresentative();

        assertThat(customerList)
                .isNotEmpty()
                .hasSize(100);
    }

    //Report total payments for Atelier graphique


    //Report the total payments by date
    @Test
    void paymentsByDate() {
        List<Map<String, Double>> mapList = service.paymentsByDate();

        assertThat(mapList)
                .isNotEmpty()
                .hasSize(232);
    }

    //eport the products that have not been sold.
    @Test
    void productsWithoutSales() {
        List<Product> productList = service.productsWithoutSales();
        assertThat(productList)
                .isNotEmpty()
                .hasSize(1)
                .first().satisfies(product -> assertThat(product.getProductCode()).isEqualTo("S18_3233"));
    }

    //List the amount paid by each customer
    @Test
    void paymentsByCustomers(){
        List<Map<Long, Double>> mapList = service.paymentsByCustomers();
        assertThat(mapList).hasSize(98);
    }

    //How many orders have been placed by Herkku Gifts?
    @Test
    void countOrdersByCustomer(){
        int count = service.countOrdersByCustomer();

        assertThat(count).isEqualTo(3);
    }

    //Who are the employees in Boston?
    @Test
    void fromBoston(){
        List<Employee> employeeList = service.fromBoston();

        assertThat(employeeList)
                .hasSize(23)
                .allSatisfy(employee -> assertThat(employee.getEmployeeNumber()).isGreaterThan(0));
    }

    //Report those payments greater than $100,000. Sort the report so the customer who made the highest payment appears first.
    @Test
    void paymentsByCustomersGreaterThan(){
        List<Map<String,Double>> mapList = service.paymentsByCustomersGreaterThan();

        assertThat(mapList)
                .isNotEmpty()
                .hasSize(25);

    }

    //List the value of 'On Hold' orders.
    @Test
    void valueOnHoldStatus(){
        double value = service.valueOnHoldStatus();
        assertThat(value)
                .isPositive()
                .isEqualTo(169575.61);
    }

    //
    @Test
    void ordersOnHoldForCustomer(){
        List<Map<String,Double>> mapList = service.ordersOnHoldForCustomer();

        assertThat(mapList).hasSize(4);
    }
}
