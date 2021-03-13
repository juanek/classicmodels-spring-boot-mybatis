package ar.com.juanek.model;

/**
 * Stores all employee information as well as the organization structure such as who reports to whom.
 *
 * +----------------+--------------+------+-----+---------+-------+
 * | Field          | Type         | Null | Key | Default | Extra |
 * +----------------+--------------+------+-----+---------+-------+
 * | employeeNumber | int(11)      | NO   | PRI | NULL    |       |
 * | lastName       | varchar(50)  | NO   |     | NULL    |       |
 * | firstName      | varchar(50)  | NO   |     | NULL    |       |
 * | extension      | varchar(10)  | NO   |     | NULL    |       |
 * | email          | varchar(100) | NO   |     | NULL    |       |
 * | officeCode     | varchar(10)  | NO   | MUL | NULL    |       |
 * | reportsTo      | int(11)      | YES  | MUL | NULL    |       |
 * | jobTitle       | varchar(50)  | NO   |     | NULL    |       |
 * +----------------+--------------+------+-----+---------+-------+
 *
 * @author juanekipes@gmail.com
 */
public class Employee {

    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private Office office;
    private Employee employee;
    private String jobTitle;

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
