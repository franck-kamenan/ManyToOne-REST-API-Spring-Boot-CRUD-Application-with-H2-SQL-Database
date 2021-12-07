package com.example.paint.repositories;

import com.example.paint.models.entities.Painter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PainterRepository extends JpaRepository<Painter, Long> {}