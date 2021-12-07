package com.example.paint.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaintingDTO {
    
    private long id;
    private String name;
    private String style;
    private long painterId;
}