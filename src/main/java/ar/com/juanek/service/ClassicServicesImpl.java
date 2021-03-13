package ar.com.juanek.service;

import ar.com.juanek.mapper.*;
import ar.com.juanek.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author juanekipes@gmail.com
 */
@Service
public class ClassicServicesImpl implements ClassicService {

    @Autowired
    OfficeMapper officeMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    PaymentsMapper paymentsMapper;

    @Autowired
    ProductLineMapper productLineMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Office> findOfficeOrdered() {
        return officeMapper.findOfficesOrdered();
    }

    @Override
    public int numberOfEmployess() {
        return employeeMapper.countEmployee();
    }

    @Override
    public double paymentsReceived() {
        return paymentsMapper.paymentsReceived();
    }

    @Override
    public List<ProductLine> productLinesWithCars() {
        return productLineMapper.findProductLineCars();
    }

    @Override
    public double reportTotalPayments() {
        return paymentsMapper.reportTotalPayments();
    }

    @Override
    public List<Payments> findPaymentsGreaterThan() {
        return paymentsMapper.findPaymentsGreaterThan();
    }

    @Override
    public List<Product> listProductForProductLine() {
        return productMapper.listProductForProductLine();
    }

    @Override
    public List<Map<String, Integer>> countProductForProductLine() {
        return productMapper.countProductForProductLine();
    }

    @Override
    public double minPaymentReceived() {
        return paymentsMapper.minPaymentsReceived();
    }

    @Override
    public List<Payments> paymentsGreaterThanAverage() {
        return paymentsMapper.paymentsGreaterThanAverage();
    }

    @Override
    public double averagePercentageMarkup() {
        return productMapper.averagePercentageMarkup();
    }

    @Override
    public int distinctProducts() {
        return productMapper.distinctProducts();
    }

    @Override
    public List<Customer> customersWithoutSalesRepresentative() {
        return customerMapper.customersWithoutSalesRepresentative();
    }

    @Override
    public List<String> namesOfExecutives() {
        return employeeMapper.namesOfExecutives();
    }

    @Override
    public List<Map<String, Double>> ordersGreaterThan() {
        return orderMapper.ordersGreaterThan();
    }

    @Override
    public List<Customer> accountRepresentative() {
        return customerMapper.accountRepresentative();
    }

    @Override
    public List<Map<String, Double>> paymentsByDate() {
        return paymentsMapper.paymentsByDate();
    }

    @Override
    public List<Product> productsWithoutSales() {
        return productMapper.productsWithoutSales();
    }

    @Override
    public List<Map<Long, Double>> paymentsByCustomers() {
        return paymentsMapper.paymentsByCustomers();
    }

    @Override
    public int countOrdersByCustomer() {
        return customerMapper.countOrdersByCustomer();
    }

    @Override
    public List<Employee> fromBoston() {
        return employeeMapper.fromBoston();
    }

    @Override
    public List<Map<String, Double>> paymentsByCustomersGreaterThan() {
        return paymentsMapper.paymentsByCustomersGreaterThan();
    }

    @Override
    public double valueOnHoldStatus() {
        return orderMapper.valueOnHoldStatus();
    }

    @Override
    public List<Map<String, Double>> ordersOnHoldForCustomer() {
        return orderMapper.ordersOnHoldForCustomer();
    }

    @Override
    public List<Map<String, LocalDateTime>> productSoldByDate() {
        return productMapper.productSoldByDate();
    }

    @Override
    public List<Map<String, LocalDateTime>> ordersDateByProductName() {
        return orderMapper.ordersDateByProductName();
    }

    @Override
    public List<Map<String, Double>> customerOrdersGreaterThan() {
        return customerMapper.customerOrdersGreaterThan();
    }

    @Override
    public List<String> anyProductsAllOrders() {
        return productMapper.anyProductsAllOrders();
    }

    @Override
    public List<String> productsLessThanMRSP() {
        return productMapper.productsLessThanMRSP();
    }

    @Override
    public List<String> priceAtLeastTwice() {
        return productMapper.priceAtLeastTwice();
    }

    @Override
    public List<Product> orderedMonday() {
        return productMapper.orderedMonday();
    }

    @Override
    public int productOnHold() {
        return productMapper.productOnHold();
    }


}
