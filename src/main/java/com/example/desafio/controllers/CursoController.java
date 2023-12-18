package com.example.desafio.controllers;
import com.example.desafio.dtos.CursoAlunoDTO;
import com.example.desafio.dtos.CursoDTO;
import com.example.desafio.models.Cursos;
import com.example.desafio.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoAlunoDTO>findAll(){
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public CursoAlunoDTO findById(@PathVariable Long id){
        return this.cursoService.findiById(id);
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody CursoDTO cursos){
        var entity = this.cursoService.create(cursos);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
    @PutMapping("/{id}")
    public Cursos update(@RequestBody Cursos cursos, @PathVariable Long id){
        return this.cursoService.update(cursos, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.cursoService.delete(id);
    }
}
