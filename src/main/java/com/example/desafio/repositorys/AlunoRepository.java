package com.example.desafio.repositorys;

import com.example.desafio.dtos.AlunoDTOParaPost;
import com.example.desafio.models.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface AlunoRepository extends JpaRepository<Alunos, Long> {
    Alunos findAlunosByCpf(String cpf);
    boolean existsByCpf(String cpf);
    boolean existsByNumeroDeTelefone(String numero);
}
