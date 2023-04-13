package com.example.Server.repo;

import com.example.Server.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<AuthorEntity, Long> {

}
