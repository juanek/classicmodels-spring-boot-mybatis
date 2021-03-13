package ar.com.juanek.service;

import ar.com.juanek.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.doesNotHave;

@SpringBootTest
public class SingleEntityTest {

    @Autowired
    private ClassicService service;

    //Prepare a list of offices sorted by country, state, city.
    @Test
    void listOfOffices() {
        List<Office> officeList = service.findOfficeOrdered();

        assertThat(officeList)
                .isNotEmpty()
                .first()
                .satisfies(office -> assertThat(office.getOfficeCode()).isNotEmpty());

    }

    //How many employees are there in the company?
    @Test
    void numberOfEmployees() {
        int number = service.numberOfEmployess();

        assertThat(number)
                .isGreaterThan(0);
    }

    //What is the total of payments received?
    @Test
    void paymentsReceived() {

        double total = service.paymentsReceived();
        assertThat(total)
                .isEqualTo(8853839.23);

    }

    //List the product lines that contain 'Cars'.
    @Test
    void productLinesWithCars() {

        List<ProductLine> productLineList = service.productLinesWithCars();
        assertThat(productLineList)
                .isNotEmpty()
                .first()
                .satisfies(productLine -> assertThat(productLine.getProductLine()).contains("Cars"));

    }

    //Report total payments for October 28, 2004.
    @Test
    void reportTotalPayments() {
        double total = service.reportTotalPayments();
        assertThat(total)
                .isEqualTo(47411.33);

    }

    //Report those payments greater than $100,000.
    @Test
    void findPaymentsGreaterThan() {
        List<Payments> paymentsList = service.findPaymentsGreaterThan();

        assertThat(paymentsList)
                .hasSize(5)
                .first()
                .satisfies(payments -> assertThat(payments.getAmount()).isGreaterThan(100000));
    }

    //List the products in each product line
    @Test
    void listProductForProductLine() {
        List<Product> productList = service.listProductForProductLine();

        assertThat(productList)
                .hasSize(110);


    }

    //How many products in each product line?
    @Test
    void countProductForProductLine() {
        List<Map<String, Integer>> mapList = service.countProductForProductLine();

        assertThat(mapList)
                .hasSize(7);
    }

    //What is the minimum payment received?
    @Test
    void minPaymentReceived() {
        double minPaymentReceived = service.minPaymentReceived();

        assertThat(minPaymentReceived)
                .isEqualTo(615.45);
    }

    //List all payments greater than twice the average payment
    @Test
    void paymentsGreaterThanAverage() {
        List<Payments> paymentsList = service.paymentsGreaterThanAverage();

        assertThat(paymentsList)
                .hasSize(13)
                .allSatisfy(payment -> assertThat(payment.getAmount()).isGreaterThan(32431));

    }

    //What is the average percentage markup of the MSRP on buyPrice?
    @Test
    void averagePercentageMarkup() {
        double average = service.averagePercentageMarkup();

        assertThat(average)
                .isPositive()
                .isGreaterThan(45);
    }

    //How many distinct products does ClassicModels sell?
    @Test
    void distinctProducts() {
        int distinct = service.distinctProducts();

        assertThat(distinct)
                .isEqualTo(110);
    }

    //Report the name and city of customers who don't have sales representatives?
    @Test
    void customersWithoutSalesRepresentative() {
        List<Customer> customerList = service.customersWithoutSalesRepresentative();

        assertThat(customerList)
                .allSatisfy(customer -> assertThat(customer.getSalesRepEmployeeNumber()).isNull());

    }

    //What are the names of executives with VP or Manager in their title?
    @Test
    void namesOfExecutives() {
        List<String> names = service.namesOfExecutives();
        assertThat(names)
                .isNotEmpty();
    }

    //Which orders have a value greater than $5,000?
    @Test
    void ordersGreaterThan() {
        List<Map<String, Double>> ordersGreaterThan = service.ordersGreaterThan();

        assertThat(ordersGreaterThan)
                .isNotEmpty()
                .hasSize(303);
    }

}
