package com.petnet.petnet.Petshop.controller;

import com.petnet.petnet.Petshop.model.Petshop;
import com.petnet.petnet.Petshop.service.PetshopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet_shops")
public class PetshopController {
    private final PetshopService petshopService;

    public PetshopController(PetshopService petshopService) {
        this.petshopService = petshopService;
    }

    @GetMapping
    public ResponseEntity<List<Petshop>> showAllPetShops() {
        List<Petshop> petshops = petshopService.showAllPetshops();
        return ResponseEntity.ok(petshops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Petshop> buscarPetshopPorId(@PathVariable Long id) {
        Petshop petshop = petshopService.buscarPetShopPorId(id);
        return ResponseEntity.ok(petshop);
    }

    @PostMapping
    public ResponseEntity<Petshop> createPetshop(@RequestBody Petshop petshop) {
        Petshop novoPetshop = petshopService.salvar(petshop);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPetshop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Petshop> updatePetshop(@PathVariable Long id, @RequestBody Petshop petshop) {
        Petshop petshopAtualizado = petshopService.updatePetshop(id, petshop);
        return ResponseEntity.ok(petshopAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetshop(@PathVariable Long id) {
        petshopService.deletePetshop(id);
        return ResponseEntity.noContent().build();
    }
}
