package com.usa.library.repositorio.crud;

import com.usa.library.modelo.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryCrudRepository extends CrudRepository<Library, Integer> {
}
