package com.example.Server.utils;

import com.example.Server.entity.PublisherEntity;
import com.example.Server.exception.ValidationExceptionPublisher;


public class PublisherValidationUtils {
    public static void publisherValidationUtils(PublisherEntity publisher) throws ValidationExceptionPublisher {
        String publisherTitle = publisher.getPublisher();
        if(publisherTitle == null || publisherTitle.isBlank()){
            throw new ValidationExceptionPublisher("Поле название не может быть пустым");
        }
        String city = publisher.getCity();
        if(city==null){
            throw new ValidationExceptionPublisher("Нужно выбрать город");
        }
    }
}

