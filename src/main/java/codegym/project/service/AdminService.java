package codegym.project.service;

import codegym.project.model.Admin;

import java.util.List;

public interface AdminService {

    //Hàm trả về List Admin.
    List<Admin> findAll();

    //Hàm trả về Admin có ID truyền vào.
    Admin findById(Long id);

    //Hàm lưu Admin truyền vào.
    void save(Admin admin);

    //Hàm xóa Admin có ID truyền vào.
    void remove(Long id);
}
