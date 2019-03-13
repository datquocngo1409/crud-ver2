package codegym.project;

import codegym.project.service.AdminService;
import codegym.project.service.impl.AdminServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Bean
    public AdminService adminService() {
        return new AdminServiceImpl();
    }
}
