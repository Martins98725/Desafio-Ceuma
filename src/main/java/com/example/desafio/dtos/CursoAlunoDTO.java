package com.example.desafio.dtos;

import com.example.desafio.models.Alunos;
import com.example.desafio.models.Cursos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CursoAlunoDTO {
    private Long id;
    private String nome;
    private int cargaHoraria;
    private LocalDateTime dataDeCadastro;
    private List<AlunoCursoDTO> AlunosNoCurso = new ArrayList<>();
    public CursoAlunoDTO() {
    }

    public CursoAlunoDTO(Long id, String nome, int cargaHoraria, LocalDateTime dataDeCadastro, List<AlunoCursoDTO> alunosNoCurso) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.dataDeCadastro = dataDeCadastro;
        this.AlunosNoCurso = alunosNoCurso;

    }
    public CursoAlunoDTO(Cursos entity){
        id = entity.getId();
        nome = entity.getNome();
        dataDeCadastro = entity.getDataDeCadastro();
        cargaHoraria = entity.getCargaHoraria();
        entity.getAlunosCadastrados()
                .forEach(x -> getAlunosNoCurso()
                .add(new AlunoCursoDTO(x.getId(), x.getNome(), x.getCpf())));
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public List<AlunoCursoDTO> getAlunosNoCurso() {
        return AlunosNoCurso;
    }

    public void setAlunosNoCurso(List<AlunoCursoDTO> alunosNoCurso) {
        this.AlunosNoCurso = alunosNoCurso;
    }


}
