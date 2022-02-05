package repo;

import entity.Singer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {
    List<Singer> findByFirstName(String name);
}
