package codegym.project.service;

import codegym.project.model.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> findAll();

    Admin findById(Long id);

    void save(Admin admin);

    void remove(Long id);
}
