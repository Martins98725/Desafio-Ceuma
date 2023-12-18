package com.example.desafio.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_alunos")
public class Alunos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70, nullable = false)
    private String nome;
    @Column(length = 14, nullable = false, unique = true)
    private String cpf;
    @Column(length = 10, nullable = false)
    private String cep;
    @Column(length = 100, nullable = false)
    private String endereco;
    @Column(length = 40, nullable = false)
    private String email;
    @Column(length = 17, nullable = false, unique = true)
    private String numeroDeTelefone;
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Cursos cursos;

    public Alunos() {
    }

    public Alunos(Long id, String nome, String cpf, String cep, String endereco, String email, String numeroDeTelefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public Alunos(Long id, String nome, String cpf, String cep, String endereco, String email, String numeroDeTelefone, Cursos cursos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
        this.cursos = cursos;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNumeroDeTelefone(String numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alunos alunos = (Alunos) o;
        return Objects.equals(id, alunos.id) && Objects.equals(nome, alunos.nome) && Objects.equals(cpf, alunos.cpf) && Objects.equals(cep, alunos.cep) && Objects.equals(endereco, alunos.endereco) && Objects.equals(email, alunos.email) && Objects.equals(numeroDeTelefone, alunos.numeroDeTelefone) && Objects.equals(cursos, alunos.cursos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, cep, endereco, email, numeroDeTelefone, cursos);
    }
}
