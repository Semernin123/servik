package com.example.Server.service;

import com.example.Server.entity.AuthorEntity;
import com.example.Server.exception.ValidationExceptionAuthor;
import com.example.Server.repo.AuthorRepo;

import com.example.Server.utils.AuthorValidationUtils;
import org.springframework.stereotype.Service;



@Service
public class AuthorService {

    private final AuthorRepo repo;
    public AuthorService (AuthorRepo repo){
        this.repo= repo;

    }
    public AuthorEntity save(AuthorEntity author) throws ValidationExceptionAuthor {
        AuthorValidationUtils.authorValidationUtils(author);
        return repo.save(author);
    }
    public void delete(Long id){repo.deleteById(id);}

    public Iterable<AuthorEntity> getAll(){return repo.findAll();}

    public AuthorEntity find(Long id){return repo.findById(id).get();}
}
