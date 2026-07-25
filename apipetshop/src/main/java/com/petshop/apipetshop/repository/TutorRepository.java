package com.petshop.apipetshop.repository;

import com.petshop.apipetshop.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    boolean existsByCpf(String cpf);
    Optional<Tutor> findByCpf(String cpf);
}
