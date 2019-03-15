package codegym.project;

import codegym.project.service.*;
import codegym.project.service.impl.*;
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

    @Bean
    public Mp3FileService mp3FileService() {
        return new Mp3FileServiceImpl();
    }
}
