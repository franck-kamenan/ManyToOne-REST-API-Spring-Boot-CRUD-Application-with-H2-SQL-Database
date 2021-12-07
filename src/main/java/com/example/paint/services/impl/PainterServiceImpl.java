package com.example.paint.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.paint.mappers.PainterMapper;
import com.example.paint.models.dtos.PainterDTO;
import com.example.paint.models.entities.Painter;
import com.example.paint.models.forms.PainterForm;
import com.example.paint.repositories.PainterRepository;
import com.example.paint.services.BaseService;

import org.springframework.stereotype.Service;

@Service
public class PainterServiceImpl implements BaseService<PainterDTO, PainterForm, Long> {

    private final PainterRepository painterRepository;
    private final PainterMapper painterMapper;

    public PainterServiceImpl(PainterRepository painterRepository, PainterMapper painterMapper) {

        this.painterRepository = painterRepository;
        this.painterMapper = painterMapper;
    }

    @Override
    public List<PainterDTO> getAll() {

        return this.painterRepository
                .findAll()
                .stream()
                .map(this.painterMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PainterDTO getOneById(Long id) {

        return this.painterMapper.entityToDto(this.painterRepository
                                                  .findById(id)
                                                  .orElse(null));
    }

    @Override
    public PainterDTO insert(PainterForm form) {

        Painter p = this.painterMapper.formToEntity(form);

        return this.painterMapper.entityToDto(this.painterRepository.save(p));
    }

    @Override
    public Long delete(Long id) {

        Painter p = this.painterRepository
                        .findById(id)
                        .orElse(null);

        if (p != null) {

            this.painterRepository.delete(p);

            return p.getId();
        }

        return -1L;
    }

    @Override
    public PainterDTO update(PainterForm form, Long id) {

        Painter p = this.painterRepository
                        .findById(id)
                        .orElse(null);

        if (p != null) {

            p.setFirstname(form.getFirstname());
            p.setLastname(form.getLastname());
            this.painterRepository.save(p);
        }
        return this.painterMapper.entityToDto(p);
    }

}