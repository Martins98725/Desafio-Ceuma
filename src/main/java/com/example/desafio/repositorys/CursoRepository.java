package com.example.desafio.repositorys;

import com.example.desafio.models.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Cursos, Long> {

   Optional<Cursos> findCursosByNome(String nomeCurso);
}
