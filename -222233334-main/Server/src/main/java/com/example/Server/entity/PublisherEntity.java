package com.example.Server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "publisher")
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Издательство не может быть пустым")
    private String publisher;
    @NotBlank(message = "Название города не может быть пустым")
    private String city;
    @JsonIgnore
    @OneToMany(cascade =CascadeType.ALL, mappedBy = "publisher")
    private List<BookEntity> book;
}