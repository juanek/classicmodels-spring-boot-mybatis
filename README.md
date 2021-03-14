# Classicmodels Spring-Boot-Mybatis

## Create a docker image.

``` console
cd classicmodels-spring-boot-mybatis
``` 
```console
docker build -t mysql-classicmodels:1 .
```
## Create a docker container.
```console
docker run -d -p 3300:3306 --name classicmodels-db -e MYSQL_ROOT_PASSWORD=root mysql-classicmodels:1
``` 
## Execute an interactive bash shell on the container.
```console
docker exec -it classicmodels-db bash
``` 

## Start a docker container.

```console
docker start classicmodels-db
``` 

## Stop a docker container.

```console
docker stop classicmodels-db
```

## Run application.

```console
mvn spring-boot:run
``` 
## Test application

```console
mvn test
```

## ClasicModels.

ClasicModels is a fictitious company for [https://www.mysqltutorial.org/basic-mysql-tutorial.aspx](https://www.mysqltutorial.org/basic-mysql-tutorial.aspx)

![ERM](MySQL-Sample-Database-Schema.png)

Some responses to [https://www.richardtwatson.com/dm6e/Reader/ClassicModels.html](https://www.richardtwatson.com/dm6e/Reader/ClassicModels.html) with mybatis annotation.


## Single entity.

1. **Prepare a list of offices sorted by country, state, city.**
    
    ``` sql
    @Select("Select * From offices Order By country,state, city")
    ```     
    
2. **How many employees are there in the company?**

    ``` sql
    @Select("SELECT count(*) FROM employees")
    ``` 

3. **What is the total of payments received?**

    ``` sql
    @Select("SELECT sum(amount) FROM payments")
    ``` 

4. **List the product lines that contain 'Cars'.**
    ``` sql
    @Select("SELECT * FROM productlines WHERE productLine LIKE '%Cars%'")
    ```

5. **Report total payments for October 28, 2004.**

    ``` sql
    @Select("SELECT SUM(amount) FROM payments WHERE paymentDate= '2004-10-28'")
    ```
   
6. **Report those payments greater than $100,000.**
    ``` sql
    @Select("SELECT * FROM payments WHERE amount >= 100000") -> MAL
    ``` 
   
7. **List the products in each product line.**
    ``` sql
    @Select("SELECT * FROM products ORDER BY productLine")
    ``` 
   
8. **How many products in each product line?**
    ``` sql
    @Select("select productLine,count(productCode) from products group by productLine")
    ``` 
9. **What is the minimum payment received?**
    ``` sql
    @Select("SELECT MIN(amount) FROM payments")
    ``` 
   
10. **List all payments greater than twice the average payment.**
    ``` sql
    @Select("SELECT * FROM payments WHERE amount  >= ((SELECT AVG(amount) FROM payments) * 2)")
    ``` 
11. **What is the average percentage markup of the MSRP on buyPrice?**
    ``` sql
    @Select("SELECT AVG((MSRP-buyPrice)/MSRP)*100 FROM products")
    ``` 
12. **How many distinct products does ClassicModels sell?**
    ``` sql
    @Select("SELECT COUNT(distinct productName) FROM products")
    ``` 
13. **Report the name and city of customers who don't have sales representatives?**
    ``` sql
    @Select("SELECT customerName,city FROM customers WHERE salesRepEmployeeNumber IS NULL")
    ``` 
14. **What are the names of executives with VP or Manager in their title? Use the CONCAT function to combine the employee's first name and last name into a single field for reporting.**
    ``` sql
    @Select("SELECT CONCAT(firstname,' ',lastname) FROM employees WHERE jobTitle LIKE '%VP%' OR jobTitle LIKE '%Manager%'")
    ``` 
15. **Which orders have a value greater than $5,000?**
    ``` sql
    @Select("SELECT orderNumber,sum(priceEach*quantityOrdered) as price from orderdetails group by orderNumber having sum(priceEach*quantityOrdered) > 5000 ")
    ``` 

## One to many relationship

1. **Report the account representative for each customer.**
    ``` sql
    @Select("SELECT customerName, CONCAT(e.firstName,' ',e.lastName) FROM customers AS c INNER JOIN employees AS e ON c.salesRepEmployeeNumber = e.employeeNumber;")
    ``` 
   
2. **Report total payments for Atelier graphique.**
    ``` sql
    @Select("SELECT * FROM payments INNER JOIN customers AS c USING(customerNumber) WHERE c.customerName = #{name}")
        @Results({
                @Result(id = true, column = "checkNumber", property = "checkNumber"),
                @Result(column = "paymentDate", property = "paymentDate"),
                @Result(column = "amount", property = "amount"),
                @Result(column = "customerNumber", property = "customer",
                        one = @One(select = "ar.com.juanek.mapper.CustomerMapper.findCustomerByNumber"))
    })
   ``` 
   
3. **Report the total payments by date.**
    ``` sql
    @Select("SELECT paymentDate,sum(amount) FROM payments GROUP BY paymentDate")
    ``` 
4. **Report the products that have not been sold.**
    ``` sql
    @Select("SELECT * from products 
             WHERE NOT EXISTS 
            ( SELECT * FROM orderdetails 
              WHERE products.productCode = orderdetails.productCode)")
    ``` 
5. **List the amount paid by each customer.**
    ``` sql
    @Select("SELECT c.customerName,SUM(amount) FROM payments as p INNER JOIN customers as c USING(customerNumber) GROUP BY p.customerNumber")
    ``` 
    
6. **How many orders have been placed by Herkku Gifts?.**
    ``` sql
    @Select("select count(*) from customers as c inner join orders as o using(customerNumber) where c.customerName = 'Herkku Gifts'")
    ``` 

7. **Who are the employees in Boston?.**
    ``` sql
    @Select("SELECT * FROM employees AS e INNER JOIN offices AS o WHERE o.city = 'Boston'")
    ``` 
8. **Report those payments greater than $100,000. Sort the report so the customer who made the highest payment appears first.**
    ``` sql
    @Select("SELECT c.customerName,SUM(p.amount) FROM payments as p INNER JOIN customers AS c USING (customerNumber) GROUP BY c.customerNumber HAVING SUM(p.amount) >= 100000 ORDER BY SUM(p.amount) DESC;")
    ``` 
9. **List the value of 'On Hold' orders.**
    ``` sql
    @Select("select sum(d.quantityOrdered*d.priceEach) as value from orders as o inner join orderdetails as d using (orderNumber) where o.status = 'On Hold'")
    ``` 
10. **Report the number of orders 'On Hold' for each customer.**
    ``` sql
    @Select("SELECT c.customerName,count(*) FROM customers as c INNER JOIN orders AS o USING (customerNumber) WHERE o.status = 'On Hold' GROUP BY c.customerNumber")
    ``` 

## Many to many relationship

1. **List products sold by order date.**
    ``` sql
    @Select("SELECT p.productName,o.orderDate 
           FROM products as p 
            INNER JOIN orderdetails AS d ON p.productCode = d.productCode 
            INNER JOIN orders AS o ON d.orderNumber = o.orderNumber 
            ORDER BY o.orderDate")
   ```   
2. **List the order dates in descending order for orders for the 1940 Ford Pickup Truck.**
   ``` sql
    @Select("SELECT p.productName,o.orderDate FROM products as p INNER JOIN orderdetails AS d ON p.productCode = d.productCode INNER JOIN orders AS o ON d.orderNumber = o.orderNumber WHERE p.productName = '1940 Ford Pickup Truck' ORDER BY o.orderDate DESC")
    @Results({
            @Result(column = "productName",property = "productName",javaType = String.class),
            @Result(column = "orderDate",property = "orderDate",javaType = LocalDateTime.class)
    })
    ```     
3. **List the names of customers and their corresponding order number where a particular order from that customer has a value greater than $25,000?**
    ``` sql
    @Select("SELECT c.customerName,sum(d.quantityOrdered*d.priceEach) as value FROM customers AS c INNER JOIN orders AS o ON c.customerNumber = o.customerNumber INNER JOIN orderdetails AS d ON o.orderNumber = d.orderNumber GROUP BY c.customerNumber HAVING value > 25000")
    @Results({
            @Result(column = "customerName", property = "customerName", javaType = String.class),
            @Result(column = "value", property = "value", javaType = Double.class)
    })
   ```     
4. **Are there any products that appear on all orders?**
    ``` sql
    @Select("SELECT productName  FROM products 
            WHERE NOT EXISTS (SELECT * FROM orders  WHERE NOT EXISTS 
                            ( SELECT *  FROM orderdetails 
                                WHERE orderdetails.orderNumber = orders.orderNumber 
                                    AND orderdetails.productCode = products.productCode ) )")
    ``` 
5. **List the names of products sold at less than 80% of the MSRP.**

    ```  sql
    @Select("SELECT p.productName FROM products as p JOIN  orderdetails as d ON p.productCode = d.productCode JOIN orders as o ON d.orderNumber = o.orderNumber WHERE d.priceEach < (0.8*p.MSRP) AND o.status='Shipped'")
    ```
 
6. **Reports those products that have been sold with a markup of 100% or more (i.e.,  the priceEach is at least twice the buyPrice)**
        
    ``` sql    
    @Select("SELECT DISTINCT productName FROM products AS p JOIN orderdetails AS d ON d.productCode = p.productCode  WHERE d.priceEach >= 2*p.buyPrice;")
    ```                
7. **List the products ordered on a Monday.**

    ``` sql
    @Select("SELECT * FROM products JOIN orderdetails ON orderdetails.productCode = products.productCode JOIN orders ON orders.orderNumber = orderdetails.orderNumber WHERE DAYOFWEEK(orders.orderDate) = 1")
    ```
    
8. **What is the quantity on hand for products listed on 'On Hold' orders?**

    ``` sql
    @Select("select count(*) from products join orderdetails on orderdetails.productCode = products.productCode join orders on orders.orderNumber = orderdetails.orderNumber where orders.status = 'On Hold';")
    ``` 
