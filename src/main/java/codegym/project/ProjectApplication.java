package codegym.project;

import codegym.project.repository.ImageRepository;
import codegym.project.service.AdminService;
import codegym.project.service.ImageService;
import codegym.project.service.SongCategoryService;
import codegym.project.service.SongService;
import codegym.project.service.impl.AdminServiceImpl;
import codegym.project.service.impl.ImageServiceImpl;
import codegym.project.service.impl.SongCategoryServiceImpl;
import codegym.project.service.impl.SongServiceImpl;
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

    @Bean
    public SongCategoryService songCategoryService() {
        return new SongCategoryServiceImpl();
    }

    @Bean
    public SongService songService() {
        return new SongServiceImpl();
    }

    @Bean
    public ImageService imageService() {
        return new ImageServiceImpl();
    }
}
