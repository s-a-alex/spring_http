package dao;


import entity.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    Singer findById(Long id);
    List<Singer> findByFirstName(String name);
    Singer save(Singer singer);
}
