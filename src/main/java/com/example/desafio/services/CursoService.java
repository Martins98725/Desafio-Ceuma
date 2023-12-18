package com.example.desafio.services;

import com.example.desafio.dtos.AlunoCursoDTO;
import com.example.desafio.dtos.CursoAlunoDTO;
import com.example.desafio.dtos.CursoDTO;
import com.example.desafio.models.Cursos;
import com.example.desafio.repositorys.AlunoRepository;
import com.example.desafio.repositorys.CursoRepository;
import com.example.desafio.ultil.Exceptions.CampoInvalidoException;
import com.example.desafio.ultil.Exceptions.ExceptionsHandler;
import com.example.desafio.ultil.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;
    public Cursos create(CursoDTO cursos){
            Cursos entity = new Cursos();
            entity.setId(cursos.getId());
            entity.setNome(cursos.getNome());
            entity.setCargaHoraria(cursos.getCargaHoraria());
            if (entity.getNome() == null || entity.getCargaHoraria() == 0 ) {
                throw new CampoInvalidoException("Não foi possivel cadastrar o curso, pois há um campo invalido ou faltando. Tente novamente");
            }
            repository.save(entity);
            return entity;
    }

    public List<CursoAlunoDTO>findAll(){
        List<Cursos> cursos = repository.findAll();
        List<CursoAlunoDTO> dtos = new ArrayList<>();
        for (Cursos c: cursos){
            dtos.add(new CursoAlunoDTO(c));
        }
           return dtos;
        }

    public CursoAlunoDTO findiById(Long id){
        Cursos cursos = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O curso com o id passado não existe. Por favor cadastre-o para concluir a ação"));

        CursoAlunoDTO cursoAlunoDTO = new CursoAlunoDTO();
        cursoAlunoDTO.setId(cursos.getId());
        cursoAlunoDTO.setNome(cursos.getNome());
        cursoAlunoDTO.setCargaHoraria(cursos.getCargaHoraria());
        cursoAlunoDTO.setDataDeCadastro(cursos.getDataDeCadastro());

        cursos.getAlunosCadastrados()
                .forEach(f -> cursoAlunoDTO
                .getAlunosNoCurso().add(new AlunoCursoDTO(f.getId(), f.getNome(), f.getCpf())));
        return cursoAlunoDTO;
    }
    public void delete(Long id) {
        var cursoId = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("O curso com o id passado não existe. Por favor cadastre-o para concluir a ação"));
        if (cursoId != null){
            repository.deleteById(id);
        }
    }
    public Cursos update(Cursos cursos, Long id){
        Cursos entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("O curso com o id passado não existe. Por favor cadastre-o para concluir a ação"));

        entity.setNome(cursos.getNome());
        entity.setCargaHoraria(cursos.getCargaHoraria());
        if (entity.getNome() == null || entity.getCargaHoraria() == 0 ) {
            throw new CampoInvalidoException("Não foi possivel atualizar o curso, pois há um campo invalido ou faltando. Tente novamente");
        }
        repository.save(entity);

        return entity;
    }
}
