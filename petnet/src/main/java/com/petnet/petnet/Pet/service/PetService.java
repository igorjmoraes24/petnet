package com.petnet.petnet.Pet.service;

import com.petnet.petnet.Exception.NotFoundException;
import com.petnet.petnet.Pet.model.Pet;
import com.petnet.petnet.Pet.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) { this.petRepository = petRepository;}

    public List<Pet> showAllPets() {
        return petRepository.findAll();
    }

    public Pet buscarPetPorId(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pet não encontrado com o ID: " + id));
    }

    @Transactional
    public Pet salvar(Pet pet) { return petRepository.save(pet);}

    @Transactional
    public Pet updatePet(Long id, Pet dto) {
        Pet petExistente = buscarPetPorId(id);

        petExistente.setUserId(dto.getUserId());
        petExistente.setNomePet(dto.getNomePet());
        petExistente.setObserv(dto.getObserv());
        petExistente.setPeso(dto.getPeso());
        petExistente.setNasc(dto.getNasc());
        petExistente.setEspecie(dto.getEspecie());
        petExistente.setRaca(dto.getRaca());

        return petRepository.save(petExistente);
    }

    @Transactional
    public void deletePet(Long id) {
        Pet pet = buscarPetPorId(id);
        petRepository.delete(pet);
    }
}
