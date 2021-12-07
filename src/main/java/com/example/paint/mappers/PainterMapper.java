package com.example.paint.mappers;

import com.example.paint.models.dtos.PainterDTO;
import com.example.paint.models.entities.Painter;
import com.example.paint.models.forms.PainterForm;
import org.springframework.stereotype.Service;

@Service
public class PainterMapper implements BaseMapper<PainterDTO, PainterForm, Painter> {

    @Override
    public Painter formToEntity(PainterForm form) {

        Painter p = new Painter();

        p.setFirstname(form.getFirstname());
        p.setLastname(form.getLastname());
        return p;
    }

    @Override
    public PainterDTO entityToDto(Painter entity) {

        if (entity != null && entity.getId() > 0) {

            return PainterDTO.builder()
                    .id(entity.getId())
                    .firstname(entity.getFirstname())
                    .lastname(entity.getLastname())
                    .build();
        }

        return null;
    }

    @Override
    public Painter dtoToEntity(PainterDTO dto) {

        Painter p = new Painter();
        if (dto != null && dto.getId() > 0) {

            p.setId(dto.getId());
            p.setFirstname(dto.getFirstname());
            p.setLastname(dto.getLastname());
        }
        
        return p;
    }

}