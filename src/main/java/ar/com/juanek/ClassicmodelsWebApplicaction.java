package ar.com.juanek;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author juanekipes@gmail.com
 */
@SpringBootApplication
public class ClassicmodelsWebApplicaction {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ClassicmodelsWebApplicaction.class)
                .run(args);
        //SpringApplication.run(WicketHelloApplication.class, args);
    }

}
