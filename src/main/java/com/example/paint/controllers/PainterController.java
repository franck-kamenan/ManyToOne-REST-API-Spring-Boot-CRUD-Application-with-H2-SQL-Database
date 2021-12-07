package com.example.paint.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.paint.models.dtos.PainterDTO;
import com.example.paint.models.forms.PainterForm;
import com.example.paint.services.impl.PainterServiceImpl;

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
@RequestMapping(path = "/painter")
public class PainterController {

    private final PainterServiceImpl painterService;

    public PainterController(PainterServiceImpl painterService) {

        this.painterService = painterService;
    }

    @GetMapping
    public ResponseEntity<List<PainterDTO>> getList() {

        return ResponseEntity.ok(this.painterService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PainterDTO> getOneById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(this.painterService.getOneById(id));
    }

    @PostMapping()
    public ResponseEntity<PainterDTO> insertOne(@Valid @RequestBody PainterForm form) {

        return ResponseEntity.ok(this.painterService.insert(form));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PainterDTO> updateOne(@PathVariable(name = "id") Long id, @Valid @RequestBody PainterForm form) {

        return ResponseEntity.ok(this.painterService.update(form, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> deleteOne(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(this.painterService.delete(id));
    }
}