package com.usa.library.repositorio.crud;

import com.usa.library.modelo.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository <Client, Integer> {
}
