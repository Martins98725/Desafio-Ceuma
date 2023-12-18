package com.example.desafio.dtos;

public class AlunoDTOGetById {
    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private String cep;
    private String numeroDeTelefone;
    private Long curso;

    public AlunoDTOGetById(Long id, String nome, String email, String endereco, String cep, String numeroDeTelefone, Long curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
        this.numeroDeTelefone = numeroDeTelefone;
        this.curso = curso;
    }

    public AlunoDTOGetById() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNumeroDeTelefone(String numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public Long getCurso() {
        return curso;
    }

    public void setCurso(Long curso) {
        this.curso = curso;
    }
}
