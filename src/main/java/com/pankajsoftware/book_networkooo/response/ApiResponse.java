package com.pankajsoftware.book_networkooo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse { // apiresponse not used ---- confusion in receiving complex jason data on flutter frontend
//    private String message;  
    private Object data;
}
