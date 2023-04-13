package com.example.Server.response;

import com.example.Server.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookResponse extends BaseResponse {
    public BookResponse(boolean success, String message, BookEntity data){
        super(success, message);
        this.data = data;
    }
    public BookResponse(BookEntity data) {
        super(true, "Book data");
    }
    private BookEntity data;
}

