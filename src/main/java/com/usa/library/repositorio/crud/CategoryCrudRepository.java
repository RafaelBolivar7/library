package com.usa.library.repositorio.crud;

import com.usa.library.modelo.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
