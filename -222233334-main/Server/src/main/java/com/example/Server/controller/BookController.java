package com.example.Server.controller;

import com.example.Server.entity.BookEntity;
import com.example.Server.response.BaseResponse;
import com.example.Server.response.BookListResponse;
import com.example.Server.response.BookResponse;
import com.example.Server.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private BookService service;
    public BookController (BookService service) { this.service = service; }

        @GetMapping("/all") // получить список всех книг
        public ResponseEntity <BaseResponse> getAll() {
            return ResponseEntity.ok(new BookListResponse(service.getAll()));
        }

    @PostMapping("/add") // добавить книгу в БД
    public ResponseEntity <BookResponse> registration(@RequestBody BookEntity data) {
        try {
        BookEntity temp = service.save(data);
        return ResponseEntity.ok (new BookResponse( true, "Kнигa дoбaвлена", temp));
     }catch (Exception e) {
        return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(), null));
        }
    }
    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity data) {
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