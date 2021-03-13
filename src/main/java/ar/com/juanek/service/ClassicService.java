package ar.com.juanek.service;

import ar.com.juanek.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author juanekipes@gmail.com
 */
public interface ClassicService {

    List<Office> findOfficeOrdered();

    int numberOfEmployess();

    double paymentsReceived();

    List<ProductLine> productLinesWithCars();

    double reportTotalPayments();

    List<Payments> findPaymentsGreaterThan();

    List<Product> listProductForProductLine();

    List<Map<String, Integer>> countProductForProductLine();

    double minPaymentReceived();

    List<Payments> paymentsGreaterThanAverage();

    double averagePercentageMarkup();

    int distinctProducts();

    List<Customer> customersWithoutSalesRepresentative();

    List<String> namesOfExecutives();

    List<Map<String, Double>> ordersGreaterThan();

    List<Customer> accountRepresentative();

    List<Map<String,Double>> paymentsByDate();

    List<Product> productsWithoutSales();

    List<Map<Long, Double>> paymentsByCustomers();

    int countOrdersByCustomer();

    List<Employee> fromBoston();

    List<Map<String,Double>> paymentsByCustomersGreaterThan();

    double valueOnHoldStatus();

    List<Map<String,Double>> ordersOnHoldForCustomer();

    List<Map<String, LocalDateTime>> productSoldByDate();

    List<Map<String, LocalDateTime>> ordersDateByProductName();

    List<Map<String,Double>> customerOrdersGreaterThan();

    List<String> anyProductsAllOrders();

    List<String> productsLessThanMRSP();

    List<String> priceAtLeastTwice();

    List<Product> orderedMonday();

    int productOnHold();

}
