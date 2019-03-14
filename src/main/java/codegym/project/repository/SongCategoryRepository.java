package codegym.project.repository;

import codegym.project.model.SongCategory;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongCategoryRepository extends PagingAndSortingRepository<SongCategory, Long> {
}
