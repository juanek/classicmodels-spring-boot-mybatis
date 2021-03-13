package ar.com.juanek.model;

/**
 *  Stores customer’s data.
 * +------------------------+---------------+------+-----+---------+-------+
 * | Field                  | Type          | Null | Key | Default | Extra |
 * +------------------------+---------------+------+-----+---------+-------+
 * | customerNumber         | int(11)       | NO   | PRI | NULL    |       |
 * | customerName           | varchar(50)   | NO   |     | NULL    |       |
 * | contactLastName        | varchar(50)   | NO   |     | NULL    |       |
 * | contactFirstName       | varchar(50)   | NO   |     | NULL    |       |
 * | phone                  | varchar(50)   | NO   |     | NULL    |       |
 * | addressLine1           | varchar(50)   | NO   |     | NULL    |       |
 * | addressLine2           | varchar(50)   | YES  |     | NULL    |       |
 * | city                   | varchar(50)   | NO   |     | NULL    |       |
 * | state                  | varchar(50)   | YES  |     | NULL    |       |
 * | postalCode             | varchar(15)   | YES  |     | NULL    |       |
 * | country                | varchar(50)   | NO   |     | NULL    |       |
 * | salesRepEmployeeNumber | int(11)       | YES  | MUL | NULL    |       |
 * | creditLimit            | decimal(10,2) | YES  |     | NULL    |       |
 * +------------------------+---------------+------+-----+---------+-------+
 *
 * @author juanekipes@gmail.com
 */
public class Customer {

    private long customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Long salesRepEmployeeNumber;
    private Double creditLimit;

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(Long salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
