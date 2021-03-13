package ar.com.juanek.model;

import java.time.LocalDateTime;

/**
 * Stores payments made by customers based on their accounts.
 * +----------------+---------------+------+-----+---------+-------+
 * | Field          | Type          | Null | Key | Default | Extra |
 * +----------------+---------------+------+-----+---------+-------+
 * | customerNumber | int(11)       | NO   | PRI | NULL    |       |
 * | checkNumber    | varchar(50)   | NO   | PRI | NULL    |       |
 * | paymentDate    | date          | NO   |     | NULL    |       |
 * | amount         | decimal(10,2) | NO   |     | NULL    |       |
 * +----------------+---------------+------+-----+---------+-------+
 *
 * @author juanekipes@gmail.com
 */
public class Payments {

    private Customer customer;
    //private int customerNumber;
    private String checkNumber;
    private LocalDateTime paymentDate;
    private double amount;

//    public int getCustomerNumber() {
//        return customerNumber;
//    }
//
//    public void setCustomerNumber(int customerNumber) {
//        this.customerNumber = customerNumber;
//    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
