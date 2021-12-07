package com.example.paint.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.paint.mappers.PaintingMapper;
import com.example.paint.models.dtos.PaintingDTO;
import com.example.paint.models.entities.Painter;
import com.example.paint.models.entities.Painting;
import com.example.paint.models.forms.PaintingForm;
import com.example.paint.repositories.PainterRepository;
import com.example.paint.repositories.PaintingRepository;
import com.example.paint.services.BaseService;

import org.springframework.stereotype.Service;

@Service
public class PaintingServiceImpl implements BaseService<PaintingDTO, PaintingForm, Long> {

    private final PaintingRepository paintingRepository;
    private final PaintingMapper paintingMapper;
    private final PainterRepository paintergRepository;

    public PaintingServiceImpl(PaintingRepository paintingRepository, PaintingMapper paintingMapper, PainterRepository paintergRepository) {

        this.paintingRepository = paintingRepository;
        this.paintingMapper = paintingMapper;
        this.paintergRepository = paintergRepository;
    }

    @Override
    public List<PaintingDTO> getAll() {

        return this.paintingRepository
                .findAll()
                .stream()
                .map(this.paintingMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaintingDTO getOneById(Long id) {

        return this.paintingMapper.entityToDto(this.paintingRepository
                                                  .findById(id)
                                                  .orElse(null));
    }

    @Override
    public PaintingDTO insert(PaintingForm form) {

        Painting p = this.paintingMapper.formToEntity(form);
        Painter painterObject = paintergRepository.getById(form.getPainterId());
        p.setPainter(painterObject);
        return this.paintingMapper.entityToDto(this.paintingRepository.save(p));
    }

    @Override
    public Long delete(Long id) {

        Painting p = this.paintingRepository
                        .findById(id)
                        .orElse(null);

        if (p != null) {

            this.paintingRepository.delete(p);

            return p.getId();
        }

        return -1L;
    }

    @Override
    public PaintingDTO update(PaintingForm form, Long id) {

        Painting p = this.paintingRepository
                        .findById(id)
                        .orElse(null);

        if (p != null) {

            p.setName(form.getName());
            p.setStyle(form.getStyle());
            this.paintingRepository.save(p);
        }
        return this.paintingMapper.entityToDto(p);
    }

}