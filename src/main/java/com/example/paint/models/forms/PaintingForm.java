package com.example.paint.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PaintingForm {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Size(min = 2, max = 30)
    private String style;
    
    @NotNull
    private long painterId;

    public long getPainterId() {
        return painterId;
    }

    public void setPainterId(long painterId) {
        this.painterId = painterId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getStyle() {

        return style;
    }

    public void setStyle(String style) {
        
        this.style = style;
    }
}