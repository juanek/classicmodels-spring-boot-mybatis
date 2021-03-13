package ar.com.juanek.model;

import java.time.LocalDateTime;

/**
 * Stores sales orders placed by customers.
 * +----------------+-------------+------+-----+---------+-------+
 * | Field          | Type        | Null | Key | Default | Extra |
 * +----------------+-------------+------+-----+---------+-------+
 * | orderNumber    | int(11)     | NO   | PRI | NULL    |       |
 * | orderDate      | date        | NO   |     | NULL    |       |
 * | requiredDate   | date        | NO   |     | NULL    |       |
 * | shippedDate    | date        | YES  |     | NULL    |       |
 * | status         | varchar(15) | NO   |     | NULL    |       |
 * | comments       | text        | YES  |     | NULL    |       |
 * | customerNumber | int(11)     | NO   | MUL | NULL    |       |
 * +----------------+-------------+------+-----+---------+-------+
 *
 * @author juanekipes@gmail.com
 */
public class Order {
    private int orderNumber;
    private LocalDateTime orderDate;
    private LocalDateTime requireDate;
    private LocalDateTime shippedDate;
    private String status;
    private String comments;
    private int customerNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getRequireDate() {
        return requireDate;
    }

    public void setRequireDate(LocalDateTime requireDate) {
        this.requireDate = requireDate;
    }

    public LocalDateTime getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDateTime shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
}
