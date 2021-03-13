package ar.com.juanek.model;

/**
 * Stores sales order line items for each sales order.
 * +-----------------+---------------+------+-----+---------+-------+
 * | Field           | Type          | Null | Key | Default | Extra |
 * +-----------------+---------------+------+-----+---------+-------+
 * | orderNumber     | int(11)       | NO   | PRI | NULL    |       |
 * | productCode     | varchar(15)   | NO   | PRI | NULL    |       |
 * | quantityOrdered | int(11)       | NO   |     | NULL    |       |
 * | priceEach       | decimal(10,2) | NO   |     | NULL    |       |
 * | orderLineNumber | smallint(6)   | NO   |     | NULL    |       |
 * +-----------------+---------------+------+-----+---------+-------+
 *
 * @author juanekipes@gmail.com
 */
public class OrderDetails {

    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private int orderLinerNumer;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public int getOrderLinerNumer() {
        return orderLinerNumer;
    }

    public void setOrderLinerNumer(int orderLinerNumer) {
        this.orderLinerNumer = orderLinerNumer;
    }
}
