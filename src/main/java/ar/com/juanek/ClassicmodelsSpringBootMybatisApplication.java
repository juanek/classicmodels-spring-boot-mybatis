package ar.com.juanek;

import ar.com.juanek.mapper.EmployeeMapper;
import ar.com.juanek.mapper.OfficeMapper;
import ar.com.juanek.mapper.ProductLineMapper;
import ar.com.juanek.service.ClassicService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class ClassicmodelsSpringBootMybatisApplication implements CommandLineRunner {

    private final ProductLineMapper productLineMapper;

    private final OfficeMapper officeMapper;

    private final EmployeeMapper employeeMapper;

    private final ClassicService classicService;

    public static void main(String[] args) {
        SpringApplication.run(ClassicmodelsSpringBootMybatisApplication.class, args);
    }

    public ClassicmodelsSpringBootMybatisApplication(ProductLineMapper productLineMapper
            , OfficeMapper officeMapper
            , EmployeeMapper employeeMapper
            , ClassicService classicService) {
        this.productLineMapper = productLineMapper;
        this.officeMapper = officeMapper;
        this.employeeMapper = employeeMapper;
        this.classicService = classicService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.productLineMapper.findAll());
        System.out.println(this.officeMapper.findOfficesOrdered());
        System.out.println(this.officeMapper.selectByOfficeCode("6"));
        System.out.println(this.employeeMapper.findEmployee(1002));

        System.out.println(this.classicService.findOfficeOrdered());
    }
}
