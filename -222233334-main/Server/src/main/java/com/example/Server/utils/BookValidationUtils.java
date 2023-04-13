package com.example.Server.utils;

import com.example.Server.entity.BookEntity;
import com.example.Server.exception.ValidationExceptionBook;



public class BookValidationUtils {
    public static void bookValidationUtils(BookEntity book) throws ValidationExceptionBook {
        String title = book.getTitle();
        if(title == null || title.isBlank()){
            throw new ValidationExceptionBook("Поле название не может быть пустым");
        }
        if(book.getAuthor()==null){
            throw new ValidationExceptionBook("Нужно выбрать автора");
        }
        if(book.getPublisher()== null){
            throw new ValidationExceptionBook("Нужно выбрать издательство");
        }
    }
}

