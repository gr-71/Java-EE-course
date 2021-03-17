package ru.geekbrains.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryServiceRemote {

    List<CategoryRepr> findAll();

    CategoryRepr findById(Long id);

}
