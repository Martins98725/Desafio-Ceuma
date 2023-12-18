package com.example.desafio.ultil.Exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date horario;
    private String mensagem;
    private String detalhes;

    public ExceptionResponse(Date horario, String mensagem, String detalhes) {
        this.horario = horario;
        this.mensagem = mensagem;
        this.detalhes = detalhes;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
