package com.petshop.apipetshop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petshop.apipetshop.DTO.petDTO.PetRequestDTO;
import com.petshop.apipetshop.DTO.petDTO.PetResponseDTO;
import com.petshop.apipetshop.exception.RegraNegocioException;
import com.petshop.apipetshop.model.Pet;
import com.petshop.apipetshop.model.Tutor;
import com.petshop.apipetshop.repository.PetRepository;
import com.petshop.apipetshop.repository.TutorRepository;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final TutorRepository tutorRepository;

    public PetService(PetRepository petRepository, TutorRepository tutorRepository) {
        this.petRepository = petRepository;
        this.tutorRepository = tutorRepository;
    }

    //Cadastro
    @Transactional
    public PetResponseDTO cadastrarPet(PetRequestDTO dto) {
        // Busca tutor
        Tutor tutor = tutorRepository.findById(dto.tutorId())
            .orElseThrow(() -> new RegraNegocioException("Tutor não encontrado com o ID: " + dto.tutorId()));

        //Cadastro do pet
        Pet pet = new Pet();
        pet.setNome(dto.nome());
        pet.setEspecie(dto.especie());
        pet.setIdadeMeses(dto.idadeMeses());
        pet.setTutor(tutor);

        Pet salvo = petRepository.save(pet);
        return PetResponseDTO.fromEntity(salvo);
    }

    //buscar todos os pets
    @Transactional
    public List<PetResponseDTO> listarTodos() {
        return petRepository.findAll()
                .stream()
                .map(PetResponseDTO::fromEntity)
                .toList();
    }

    //buscar por id o pet ou lançar exceção
    @Transactional(readOnly = true)
    public PetResponseDTO buscarPorId(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Pet não encontrado com o ID: " + id));
        return PetResponseDTO.fromEntity(pet);
    }

    //buscar por nome do pet
    @Transactional(readOnly = true)
    public List<PetResponseDTO> buscarPorNome(String nome) {
        List<Pet> pets = petRepository.findByNomeContaining(nome);
        return pets.stream()
                .map(PetResponseDTO::fromEntity)
                .toList();
    }

    //buscar por espécie do pet
    @Transactional(readOnly = true)
    public List<PetResponseDTO> buscarPorEspecie(String especie) {
        List<Pet> pets = petRepository.findByEspecie(especie);
        return pets.stream()
                .map(PetResponseDTO::fromEntity)
                .toList();
    }
    
    //atualizar
    //deletar

}
