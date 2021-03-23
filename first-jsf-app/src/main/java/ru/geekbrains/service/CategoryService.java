package ru.geekbrains.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryService {

    List<CategoryRepr> findAll();

    CategoryRepr findById(Long id);

    void deleteById(Long id);
}
