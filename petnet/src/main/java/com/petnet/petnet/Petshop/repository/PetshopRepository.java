package com.petnet.petnet.Petshop.repository;

import com.petnet.petnet.Petshop.model.Petshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PetshopRepository extends JpaRepository<Petshop, Long> {

    Optional<Petshop> findById(String id);
}
