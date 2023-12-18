package com.example.desafio.dtos;
import com.example.desafio.models.Cursos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;

public class CursoDTO {
    private Long id;
    private String nome;
    private LocalDateTime dataDeCadastro;
    private int cargaHoraria;
    private List<AlunosDTO> alunosDTOS;


    public CursoDTO() {
    }

    public CursoDTO(Long id, String nome, LocalDateTime dataDeCadastro, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.dataDeCadastro = dataDeCadastro;
        this.cargaHoraria = cargaHoraria;
    }

    public CursoDTO(Long id, String nome, LocalDateTime dataDeCadastro, int cargaHoraria, List<AlunosDTO> alunosDTOS) {
        this.id = id;
        this.nome = nome;
        this.dataDeCadastro = dataDeCadastro;
        this.cargaHoraria = cargaHoraria;
        this.alunosDTOS = alunosDTOS;
    }

    public CursoDTO(Cursos entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.dataDeCadastro = entity.getDataDeCadastro();
        this.cargaHoraria = entity.getCargaHoraria();
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

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @JsonIgnore
    public List<AlunosDTO> getAlunosDTOS() {
        return alunosDTOS;
    }

    public void setAlunosDTOS(List<AlunosDTO> alunosDTOS) {
        this.alunosDTOS = alunosDTOS;
    }
}
