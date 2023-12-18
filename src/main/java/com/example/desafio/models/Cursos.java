package com.example.desafio.models;
import com.example.desafio.dtos.CursoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "tb_cursos")
public class Cursos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40, nullable = false)
    private String nome;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime dataDeCadastro;
    @Column(length = 5, nullable = false)
    private int cargaHoraria;
    @OneToMany(mappedBy = "cursos", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Alunos> alunosCadastrados;

    //private int quantidadeDeAlunosNoCurso;


    public Cursos() {
    }
    public Cursos(Long id, String nome, int cargaHoraria, int quantidadeDeAlunosNoCurso) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
       //this.quantidadeDeAlunosNoCurso = quantidadeDeAlunosNoCurso;
    }

   /* public int getQuantidadeDeAlunosNoCurso() {
        return quantidadeDeAlunosNoCurso;
    }

    public void setQuantidadeDeAlunosNoCurso(int quantidadeDeAlunosNoCurso) {
        this.quantidadeDeAlunosNoCurso = quantidadeDeAlunosNoCurso;
    }*/

    @JsonIgnore
    public List<Alunos> getAlunosCadastrados() {
        return alunosCadastrados;
    }

    public void setAlunosCadastrados(List<Alunos> alunosCadastrados) {
        this.alunosCadastrados = alunosCadastrados;
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

    //@JsonIgnore
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursos cursos = (Cursos) o;
        return cargaHoraria == cursos.cargaHoraria && Objects.equals(id, cursos.id) && Objects.equals(nome, cursos.nome) && Objects.equals(dataDeCadastro, cursos.dataDeCadastro) && Objects.equals(alunosCadastrados, cursos.alunosCadastrados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataDeCadastro, cargaHoraria, alunosCadastrados);
    }
}
