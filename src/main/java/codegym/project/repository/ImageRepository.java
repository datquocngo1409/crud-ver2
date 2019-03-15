package codegym.project.repository;

import codegym.project.model.Image;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {
    Image findByName(String filename);
}
