package com.example.Server.controller;

import com.example.Server.entity.PublisherEntity;
import com.example.Server.response.*;
import com.example.Server.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/publisher")
public class PublisherController {

    private PublisherService service;
    public PublisherController (PublisherService service) { this.service = service; }

    @GetMapping("/all") // получить список всех издательств
    public ResponseEntity <BaseResponse> getAll() {
        return ResponseEntity.ok(new PublisherListResponse(service.getAll()));
    }

    @PostMapping("/add") // добавить издательство в БД
    public ResponseEntity <PublisherResponse> registration(@RequestBody PublisherEntity data) {
        try {
            PublisherEntity temp = service.save(data);
            return ResponseEntity.ok (new PublisherResponse( true, "издательство дoбaвлено", temp));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new PublisherResponse(false, e.getMessage(), null));
        }
    }
    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Информация об издательстве была обновлена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}") //Удалить издательство из БД по его Id
    public ResponseEntity<BaseResponse> delete (@PathVariable("id") long id){
        try {
            System.out.println(id);
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "издательство yдaлено"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}