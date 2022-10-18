package com.usa.library.repositorio.crud;

import com.usa.library.modelo.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
