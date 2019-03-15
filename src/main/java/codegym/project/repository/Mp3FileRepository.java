package codegym.project.repository;

import codegym.project.model.Mp3File;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Mp3FileRepository extends PagingAndSortingRepository<Mp3File, Long> {
}
