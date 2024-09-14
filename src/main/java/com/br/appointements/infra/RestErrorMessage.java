package com.br.appointements.infra;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestErrorMessage {
    private HttpStatus status;
    private String message;
    private String type;             
    private String detail;          
    private String instance;         
    private LocalDateTime timestamp; 


}
