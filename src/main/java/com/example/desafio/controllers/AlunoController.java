package com.example.desafio.controllers;
import com.example.desafio.dtos.AlunoDTOGetById;
import com.example.desafio.dtos.AlunoDTOParaPost;
import com.example.desafio.dtos.AlunosDTO;
import com.example.desafio.models.Alunos;
import com.example.desafio.models.Cursos;
import com.example.desafio.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
    @Autowired
    private AlunoService service;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody AlunoDTOParaPost alunos){
        var alunoCreate = this.service.create(alunos);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCreate);
    }
    @GetMapping
    public List<AlunosDTO>findAll(){
      return this.service.findALl();
    }

    @GetMapping( "/{id}")
    public Alunos findById(@PathVariable Long id){
        return this.service.findById(id);
    }

    @PutMapping("/{id}")
    public Alunos update(@RequestBody AlunoDTOGetById alunos, @PathVariable Long id){
        return this.service.updade(alunos, id);
    }
}
