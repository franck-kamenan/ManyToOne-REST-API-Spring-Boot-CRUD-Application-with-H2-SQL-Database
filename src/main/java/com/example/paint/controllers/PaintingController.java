package com.example.paint.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.paint.models.dtos.PaintingDTO;
import com.example.paint.models.forms.PaintingForm;
import com.example.paint.services.impl.PaintingServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/painting")
public class PaintingController {

    private final PaintingServiceImpl paintingService;

    public PaintingController(PaintingServiceImpl paintingService) {

        this.paintingService = paintingService;
    }

    @GetMapping
    public ResponseEntity<List<PaintingDTO>> getList() {

        return ResponseEntity.ok(this.paintingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaintingDTO> getOneById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(this.paintingService.getOneById(id));
    }

    @PostMapping()
    public ResponseEntity<PaintingDTO> insertOne(@Valid @RequestBody PaintingForm form) {

        return ResponseEntity.ok(this.paintingService.insert(form));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PaintingDTO> updateOne(@PathVariable(name = "id") Long id, @Valid @RequestBody PaintingForm form) {

        return ResponseEntity.ok(this.paintingService.update(form, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> deleteOne(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(this.paintingService.delete(id));
    }
}