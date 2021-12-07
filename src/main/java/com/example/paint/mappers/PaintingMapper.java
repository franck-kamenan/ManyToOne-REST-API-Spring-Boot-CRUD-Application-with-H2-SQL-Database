package com.example.paint.mappers;

import com.example.paint.models.dtos.PaintingDTO;
import com.example.paint.models.entities.Painting;
import com.example.paint.models.forms.PaintingForm;
import org.springframework.stereotype.Service;

@Service
public class PaintingMapper implements BaseMapper<PaintingDTO, PaintingForm, Painting> {

    @Override
    public Painting formToEntity(PaintingForm form) {

        Painting p = new Painting();

        p.setName(form.getName());
        p.setStyle(form.getStyle());
        return p;
    }

    @Override
    public PaintingDTO entityToDto(Painting entity) {

        if (entity != null && entity.getId() > 0) {

            return PaintingDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .style(entity.getStyle())
                    .painterId(entity.getPainter().getId())
                    .build();
        }

        return null;
    }

    @Override
    public Painting dtoToEntity(PaintingDTO dto) {

        Painting p = new Painting();
        if (dto != null && dto.getId() > 0) {

            p.setId(dto.getId());
            p.setName(dto.getName());
            p.setStyle(dto.getStyle());
        }
        
        return p;
    }

}