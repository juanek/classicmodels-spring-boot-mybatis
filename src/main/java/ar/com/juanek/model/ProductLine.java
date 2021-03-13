package ar.com.juanek.model;

import java.util.List;

/**
 * Stores a list of product line categories
 * <p>
 * +-----------------+---------------+------+-----+---------+-------+
 * | Field           | Type          | Null | Key | Default | Extra |
 * +-----------------+---------------+------+-----+---------+-------+
 * | productLine     | varchar(50)   | NO   | PRI | NULL    |       |
 * | textDescription | varchar(4000) | YES  |     | NULL    |       |
 * | htmlDescription | mediumtext    | YES  |     | NULL    |       |
 * | image           | mediumblob    | YES  |     | NULL    |       |
 * +-----------------+---------------+------+-----+---------+-------+
 *
 * @author juanekipes@gmail.com
 */
public class ProductLine {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private List<Product> products;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "productLine='" + productLine + '\'' +
                '}';
    }
}
