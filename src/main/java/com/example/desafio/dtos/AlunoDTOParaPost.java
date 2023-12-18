package com.example.desafio.dtos;

public class AlunoDTOParaPost {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String numeroDeTelefone;
    private String cep;
    private String endereco;
    private Long curso;

    public AlunoDTOParaPost() {
    }

    public AlunoDTOParaPost(Long id, String nome, String cpf, String email, String numeroDeTelefone, String cep, String endereco, Long curso) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
        this.cep = cep;
        this.endereco = endereco;
        this.curso = curso;
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

    public Long getCurso() {
        return curso;
    }

    public void setCurso(Long curso) {
        this.curso = curso;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
