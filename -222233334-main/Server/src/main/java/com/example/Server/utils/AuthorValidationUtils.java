package com.example.Server.utils;

import com.example.Server.entity.AuthorEntity;
import com.example.Server.exception.ValidationExceptionAuthor;


public class AuthorValidationUtils {
    public static void authorValidationUtils(AuthorEntity author) throws ValidationExceptionAuthor {
        String authorName = author.getName();
        if(authorName == null || authorName.isBlank()){
            throw new ValidationExceptionAuthor("Поле имя не может быть пустым");
        }

        if(author.getSurname()==null){
            throw new ValidationExceptionAuthor("Поле фамилия не может быть пустым");
        }

        if(author.getLastname()==null){
            throw new ValidationExceptionAuthor("Поле отчество не может быть пустым");
        }
    }
}