package com.example.desafio.services;
import com.example.desafio.dtos.AlunoDTOGetById;
import com.example.desafio.dtos.AlunoDTOParaPost;
import com.example.desafio.dtos.AlunosDTO;
import com.example.desafio.models.Alunos;
import com.example.desafio.models.Cursos;
import com.example.desafio.repositorys.AlunoRepository;
import com.example.desafio.repositorys.CursoRepository;
import com.example.desafio.ultil.Exceptions.CampoInvalidoException;
import com.example.desafio.ultil.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public Alunos create(AlunoDTOParaPost alunos){

        if (alunoRepository.existsByCpf(alunos.getCpf())){
            throw new CampoInvalidoException("O cpf informado ja existe no sistema");
        } else if (alunoRepository.existsByNumeroDeTelefone(alunos.getNumeroDeTelefone())) {
            throw new CampoInvalidoException("O Numero de telefone informado ja existe no sistema");
        }
            Alunos novoAluno = new Alunos();
        if (alunos.getNome().isEmpty()){
            throw new CampoInvalidoException("nome vazio");
        }
        else if(alunos.getEmail().isEmpty()){
            throw new CampoInvalidoException("email vazio");
        }
        else if (alunos.getCpf().isEmpty()){
            throw new CampoInvalidoException("cpf vazio");
        }
        else if (alunos.getCep().isEmpty()){
            throw new CampoInvalidoException("cep vazio");
        } else if (alunos.getEndereco().isEmpty()) {
            throw new CampoInvalidoException("Endereço vazio");
        } else if (alunos.getNumeroDeTelefone().isEmpty()) {
            throw new CampoInvalidoException("Numero de telefone vazio");
        }
        else {
            novoAluno.setNome(alunos.getNome());
            novoAluno.setId(alunos.getId());
            novoAluno.setEmail(alunos.getEmail());
            if (alunos.getCpf().length() < 14){
                throw new CampoInvalidoException("O CPF está faltanto caracter");
            }
            novoAluno.setCpf(alunos.getCpf());
            novoAluno.setCep(alunos.getCep());
            novoAluno.setEndereco(alunos.getEndereco());
            if (alunos.getNumeroDeTelefone().length() < 13){
                throw new CampoInvalidoException("O Numero de telefone está faltanto caracter");
            }
            novoAluno.setNumeroDeTelefone(alunos.getNumeroDeTelefone());

            Cursos cursos = cursoRepository.findById(alunos.getCurso())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("O curso com o id passado não existe. Por favor cadastre-o para concluir a ação"));
            novoAluno.setCursos(cursos);

            return alunoRepository.save(novoAluno);
        }
    }
    public List<AlunosDTO> findALl(){
       List<Alunos> alunosList = alunoRepository.findAll();
       List<AlunosDTO >dtos  = new ArrayList<>();

       for (Alunos a: alunosList){
           dtos.add(new AlunosDTO(a));
       }
       return dtos;
    }

    public Alunos findById(Long id){

        return this.alunoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("O aluno com o id passado não existe. Por favor cadastre-o para concluir a ação"));
    }
    public void delete(Long id){
        var aluno = alunoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("O curso com o id passado não existe. Por favor cadastre-o para concluir a ação"));
        if (aluno != null) {
            alunoRepository.deleteById(id);
        }
    }
    public Alunos updade(AlunoDTOGetById alunos, Long id){
            Alunos entity = alunoRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("O aluno com o id passado não existe. Por favor cadastre-o para concluir a ação"));
            if (alunos.getNome().isEmpty()){
                throw new CampoInvalidoException("O nome está vazio");
            } else if (alunos.getEmail().isEmpty()) {
                throw new CampoInvalidoException("O email está vazio");
            } else if (alunos.getCep().isEmpty()) {
                throw new CampoInvalidoException("O cep está vazio");
            } else if (alunos.getNumeroDeTelefone().isEmpty()) {
                throw new CampoInvalidoException("O Numero de telefone está vazio");
            } else if (alunos.getEndereco().isEmpty()) {
                throw new CampoInvalidoException("O endereço está vazio");
            }
            else {
                entity.setNome(alunos.getNome());
                if (alunoRepository.existsByCpf(alunos.getCpf())){
                    throw new CampoInvalidoException("O CPF cadastrado já existe no sistema");
                }
                if (alunos.getCpf().length() < 14){
                    throw new CampoInvalidoException("O CPF está faltanto caracter");
                }
                entity.setCpf(alunos.getCpf());
                entity.setEmail(alunos.getEmail());
                if (alunos.getNumeroDeTelefone().length() < 13){
                    throw new CampoInvalidoException("O Numero de telefone está faltanto caracter");
                }
                entity.setNumeroDeTelefone(alunos.getNumeroDeTelefone());
                entity.setEndereco(alunos.getEndereco());
                entity.setCep(alunos.getCep());

                Cursos cursos = cursoRepository.findById(alunos.getCurso()).orElseThrow();
                entity.setCursos(cursos);

                alunoRepository.save(entity);

                return entity;
            }
    }
}