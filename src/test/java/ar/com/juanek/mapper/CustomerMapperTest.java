package ar.com.juanek.mapper;

import ar.com.juanek.model.Customer;
import ar.com.juanek.model.Payments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerMapperTest {
    @Autowired
    CustomerMapper customerMapper;

    @Test
    void findCustomerByNumber() {
        long numberCustomer = 103;

        Customer customer = customerMapper.findCustomerByNumber(numberCustomer);

        assertThat(customer)
                .isNotNull()
                .extracting("customerNumber")
                .isEqualTo(numberCustomer);
    }

    //Report total payments for Atelier graphique.
    @Test
    void reportTotalPayments() {
        String customerName = "Atelier graphique";
        List<Payments> paymentsList = customerMapper.paymentsByCustomerName(customerName);

        assertThat(paymentsList)
                .isNotEmpty()
                .anySatisfy(payments -> {
                    assertThat(payments.getCustomer()).isNotNull();
                    assertThat(payments.getCustomer().getCustomerName()).isEqualTo(customerName);
                });
    }
}
