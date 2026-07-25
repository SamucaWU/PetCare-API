package com.petshop.apipetshop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petshop.apipetshop.DTO.TutorRequestDTO;
import com.petshop.apipetshop.DTO.TutorResponseDTO;
import com.petshop.apipetshop.exception.RegraNegocioException;
import com.petshop.apipetshop.model.Tutor;
import com.petshop.apipetshop.repository.TutorRepository;

@Service
public class TutorService {
    
    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    //Cadastrar um novo tutor garantindo unicidade do CPF.
    @Transactional
    public TutorResponseDTO cadastrar(TutorRequestDTO dto) {
        if(tutorRepository.existsByCpf(dto.cpf())) {
            throw new RegraNegocioException("Já existe um tutor cadastrado com este CPF");
        }

        Tutor tutor = new Tutor();
        tutor.setNome(dto.nome());
        tutor.setCpf(dto.cpf());
        tutor.setTelefone(dto.telefone());

        Tutor salvo = tutorRepository.save(tutor);
        return TutorResponseDTO.fromEntity(salvo);
    }

    //Buscar todos os tutores cadastrados
    @Transactional
    public List<TutorResponseDTO> listarTodos() {
        return tutorRepository.findAll()
                .stream()
                .map(TutorResponseDTO::fromEntity)
                .toList();
    }

    //Buscar tutor por ID ou lançar exceção
    @Transactional(readOnly = true)
    public TutorResponseDTO buscarPorId(Long id) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Tutor não encontrado com o ID: " + id));
        return TutorResponseDTO.fromEntity(tutor);
    }


    //Atualiza os dados de um tutor existente
    @Transactional
    public TutorResponseDTO atualizar(Long id, TutorRequestDTO dto) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Tutor não encontrado com ID: " + id));
        
        if(!tutor.getCpf().equals(dto.cpf()) && tutorRepository.existsByCpf(dto.cpf())) {
            throw new RegraNegocioException("O CPF informado já pertence a outro tutor.");
        }

        tutor.setNome(dto.nome());
        tutor.setCpf(dto.cpf());
        tutor.setTelefone(dto.telefone());

        Tutor atualizado = tutorRepository.save(tutor);
        return TutorResponseDTO.fromEntity(atualizado);
    }

    //Remove um tutor do sistema
    @Transactional
    public void deletar(Long id) {
        if(!tutorRepository.existsById(id)) {
            throw new RegraNegocioException("Tutor não encontrado com ID: " + id);
        }
        tutorRepository.deleteById(id);
    }
}
