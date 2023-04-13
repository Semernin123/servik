package com.example.Server.controller;

import com.example.Server.entity.AuthorEntity;
import com.example.Server.entity.BookEntity;
import com.example.Server.response.*;
import com.example.Server.service.AuthorService;
import com.example.Server.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    private AuthorService service;
    public AuthorController (AuthorService service) { this.service = service; }

    @GetMapping("/all") // получить список всех книг
    public ResponseEntity <BaseResponse> getAll() {
        return ResponseEntity.ok(new AuthorListResponse(service.getAll()));
    }

    @PostMapping("/add") // добавить книгу в БД
    public ResponseEntity <AuthorResponse> registration(@RequestBody AuthorEntity data) {
        try {
            AuthorEntity temp = service.save(data);
            return ResponseEntity.ok (new AuthorResponse( true, "Kнигa дoбaвлена", temp));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthorResponse(false, e.getMessage(), null));
        }
    }
    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Информация о книге была обновлена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}") //Удалить книгу из БД по eё Id
    public ResponseEntity<BaseResponse> delete (@PathVariable("id") long id){
        try {
            System.out.println(id);
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Kнигa yдaлена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}