package codegym.project.service;

import codegym.project.model.SongCategory;

import java.util.List;

public interface SongCategoryService {
    //Hàm trả về List Category.
    List<SongCategory> findAll();

    //Hàm trả về Category có ID truyền vào.
    SongCategory findById(Long id);

    //Hàm lưu Category truyền vào.
    void save(SongCategory songCategory);

    //Hàm xóa Category có ID truyền vào.
    void remove(Long id);
}
