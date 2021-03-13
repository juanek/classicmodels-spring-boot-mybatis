package ar.com.juanek.mapper;

import ar.com.juanek.model.Payments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PaymentsMapperTest {

    @Autowired
    PaymentsMapper paymentsMapper;

    @Test
    void totalPayments(){
        assertThat(paymentsMapper).isNotNull();
        double total = paymentsMapper.paymentsReceived();
        assertThat(total).isEqualTo(8853839.23);

    }

    @Test
    void allPayments(){
        assertThat(paymentsMapper).isNotNull();
        List<Payments> paymentsList = paymentsMapper.findAll();

        assertThat(paymentsList)
                .isNotEmpty()
                .first()
                .satisfies(payments -> {
                    System.out.println(payments.getCheckNumber()+" "+payments.getAmount());
                    assertThat(payments.getCheckNumber()).isNotEmpty();
                });
    }
}
