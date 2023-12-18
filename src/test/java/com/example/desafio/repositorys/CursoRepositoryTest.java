package com.example.desafio.repositorys;
import com.example.desafio.dtos.CursoDTO;
import com.example.desafio.models.Cursos;
import com.example.desafio.services.AlunoService;
import com.example.desafio.services.CursoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class CursoRepositoryTest {


}
