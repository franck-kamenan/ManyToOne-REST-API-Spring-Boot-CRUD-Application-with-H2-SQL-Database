package com.example.paint.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PainterDTO {
    
    private long id;
    private String lastname;
    private String firstname;
}