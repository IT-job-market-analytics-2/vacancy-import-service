package dev.lxqtpr.linda.vacancyimportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VacancyImportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacancyImportServiceApplication.class, args);
    }

}
