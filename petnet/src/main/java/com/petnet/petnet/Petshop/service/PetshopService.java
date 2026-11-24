package com.petnet.petnet.Petshop.service;

import com.petnet.petnet.Petshop.model.Petshop;
import com.petnet.petnet.Petshop.repository.PetshopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PetshopService {
    private final PetshopRepository petshopRepository;
    public PetshopService(PetshopRepository petshopRepository) { this.petshopRepository = petshopRepository;}

    public List<Petshop> showAllPetshops() {
        return petshopRepository.findAll();
    }

    public Petshop buscarPetShopPorId(Long id) {
        return petshopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Petshop não encontrado com o ID: " + id));
    }

    @Transactional
    public Petshop salvar(Petshop petshop) {
        return petshopRepository.save(petshop);
    }

    @Transactional
    public Petshop updatePetshop(Long id, Petshop dto) {
        Petshop petshopExistente = buscarPetShopPorId(id);

        petshopExistente.setUserId(dto.getUserId());
        petshopExistente.setNome(dto.getNome());
        petshopExistente.setCnpj(dto.getCnpj());
        petshopExistente.setPhone(dto.getPhone());
        petshopExistente.setAvali(dto.getAvali());

        return petshopRepository.save(petshopExistente);
    }

    @Transactional
    public void deletePetshop(Long id) {
        Petshop petshop = buscarPetShopPorId(id);
        petshopRepository.delete(petshop);
    }
}
