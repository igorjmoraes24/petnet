package com.petnet.petnet.repository;

import com.petnet.petnet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Gera SQL: SELECT * FROM usuário WHERE email = ?
    Optional<User> findByEmail(String email);

    // Gera SQL: SELECT * FROM usuário WHERE LOWER(nm_completo) LIKE LOWER('%' || ? || '%')
    List<User> findByNomeContainingIgnoreCase(String nome);
}