package com.example.desafio.repositorys;

import com.example.desafio.dtos.AlunoDTOParaPost;
import com.example.desafio.models.Alunos;
import com.example.desafio.services.AlunoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class AlunoRepositoryTest {
    @Autowired
   private AlunoRepository alunoRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    CursoRepository cursoRepository;
    @Test
    @DisplayName("Deve pegar o aluno com sucesso do DB")
    void existsByCpfCase1() {
        String cpf = "12345678901234";

        AlunoDTOParaPost data = new AlunoDTOParaPost(1L, "Icaro", cpf, "icaro@gmail.com", "0987364911", "61500000", "rua tal", 1L);
        this.createAluno(data);

        boolean result = this.alunoRepository.existsByCpf(cpf);

        assertTrue(result);

        Alunos alunos = this.alunoRepository.findAlunosByCpf(cpf);

        assertNotNull(alunos);

    }
    private void createAluno(AlunoDTOParaPost data){
        Alunos newAluno = new Alunos(data);
        this.entityManager.persist(newAluno);

    }

    @Test
    void existsByNumeroDeTelefone() {
    }

}