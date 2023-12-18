package com.example.desafio.dtos;

import com.example.desafio.models.Alunos;

public class AlunosDTO {
    private Long id;
    private String nome;
    //private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private String numeroDeTelefone;
    private CursoDTO curso;

    public AlunosDTO() {
    }

    public AlunosDTO(Long id, String nome, String email, String numeroDeTelefone,String endereco,String cep ,CursoDTO curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
        this.endereco = endereco;
        this.cep = cep;
        //,String cpf
        //this.cpf = cpf;
        this.curso = curso;
    }

    public AlunosDTO(Alunos entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        //this.cpf = entity.getCpf();
        this.numeroDeTelefone = entity.getNumeroDeTelefone();
        this.endereco = entity.getEndereco();
        this.cep = entity.getCep();
        CursoDTO curso = new CursoDTO();
        curso.setId(entity.getCursos().getId());
        curso.setNome(entity.getCursos().getNome());
        curso.setCargaHoraria(entity.getCursos().getCargaHoraria());
        curso.setDataDeCadastro(entity.getCursos().getDataDeCadastro());
        this.curso = curso;

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

    public String getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNumeroDeTelefone(String numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }


    public CursoDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoDTO curso) {
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    /* public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }*/
}
