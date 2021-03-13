package ar.com.juanek.model;

/**
 * Stores sales office data.
 * +--------------+-------------+------+-----+---------+-------+
 * | Field        | Type        | Null | Key | Default | Extra |
 * +--------------+-------------+------+-----+---------+-------+
 * | officeCode   | varchar(10) | NO   | PRI | NULL    |       |
 * | city         | varchar(50) | NO   |     | NULL    |       |
 * | phone        | varchar(50) | NO   |     | NULL    |       |
 * | addressLine1 | varchar(50) | NO   |     | NULL    |       |
 * | addressLine2 | varchar(50) | YES  |     | NULL    |       |
 * | state        | varchar(50) | YES  |     | NULL    |       |
 * | country      | varchar(50) | NO   |     | NULL    |       |
 * | postalCode   | varchar(15) | NO   |     | NULL    |       |
 * | territory    | varchar(10) | NO   |     | NULL    |       |
 * +--------------+-------------+------+-----+---------+-------+
 *
 * @author juanekipes@gmail.com
 */
public class Office {

    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }
}
