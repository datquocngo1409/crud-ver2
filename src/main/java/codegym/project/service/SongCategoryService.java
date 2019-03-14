package codegym.project.service;

import codegym.project.model.SongCategory;

import java.util.List;

public interface SongCategoryService {
    List<SongCategory> findAll();

    SongCategory findById(Long id);

    void save(SongCategory songCategory);

    void remove(Long id);
}
