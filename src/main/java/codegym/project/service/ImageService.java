package codegym.project.service;

import codegym.project.model.Image;
import codegym.project.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public interface ImageService {

    List<Image> findAll();

    Resource findOneImage(String name);

    void create(MultipartFile file) throws IOException;

    void delete(String name) throws IOException;

    Image findById(Long id);
}
