package ar.com.juanek.mapper;

import ar.com.juanek.model.Payments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaymentsMapper {

    @Select("SELECT * FROM payments")
    List<Payments> findAll();

    @Select("SELECT sum(amount) FROM payments")
    double paymentsReceived();

    @Select("SELECT SUM(amount) " +
            "FROM payments " +
            "WHERE paymentDate= '2004-10-28'")
    double reportTotalPayments();

    @Select("SELECT * " +
            "FROM payments " +
            "WHERE amount >= 100000")
    List<Payments> findPaymentsGreaterThan();

    @Select("SELECT MIN(amount) " +
            "FROM payments")
    double minPaymentsReceived();

    @Select("SELECT * " +
            "FROM payments " +
            "WHERE amount  >= ((SELECT AVG(amount) FROM payments) * 2)")
    List<Payments> paymentsGreaterThanAverage();


    //select paymentDate,sum(amount) from payments group by paymentDate;
    @Select("SELECT paymentDate,sum(amount) " +
            "FROM payments " +
            "GROUP BY paymentDate")
    List<Map<String, Double>> paymentsByDate();

    //SELECT customerNumber,customerName,SUM(amount) FROM payments INNER JOIN customers USING(customerNumber) GROUP BY customerNumber;
    @Select("SELECT c.customerName,SUM(amount) " +
            "FROM payments as p " +
            "INNER JOIN customers as c " +
            "USING(customerNumber) " +
            "GROUP BY p.customerNumber")
    List<Map<Long, Double>> paymentsByCustomers();

    @Select("SELECT c.customerName,SUM(p.amount) FROM payments as p INNER JOIN " +
            "customers AS c USING (customerNumber)" +
            " GROUP BY c.customerNumber" +
            " HAVING SUM(p.amount) >= 100000" +
            " ORDER BY SUM(p.amount) DESC;")
    List<Map<String, Double>> paymentsByCustomersGreaterThan();

}
