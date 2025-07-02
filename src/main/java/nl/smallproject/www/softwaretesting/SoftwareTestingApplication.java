package nl.smallproject.www.softwaretesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "controller")
public class SoftwareTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareTestingApplication.class, args);
    }

}
