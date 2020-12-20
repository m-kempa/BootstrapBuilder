package pl.put.poznan.builder.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.builder"})
public class BootstrapBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapBuilderApplication.class, args);
    }
}
