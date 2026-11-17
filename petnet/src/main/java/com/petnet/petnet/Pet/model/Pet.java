package com.petnet.petnet.Pet.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "pet_seq_generator"
    )
    @SequenceGenerator(
            name = "pet_seq_generator",
            sequenceName = "pet_seq",
            allocationSize = 1
    )
    @Column(name = "pet_id")
    private Long id;

    @Column(name = "user_tutor_id")
    private Long user_id;

    @Column(name = "pet_nome",nullable = false, length = 60)
    private String nome_pet;

    @Column(name = "pet_observacoes_medicas", length = 200)
    private String observ;

    @Column(name = "pet_peso")
    private Double peso;

    @Column(name = "pet_datanasc")
    private Date nasc;

    @Column(name = "pet_especie")
    private String especie;

    @Column(name = "pet_raca")
    private String raca;

    public Pet() {
    }

    public Pet(Long user_id, String nome_pet, String observ, Double peso, Date nasc, String especie, String raca) {
        this.user_id = user_id;
        this.nome_pet = nome_pet;
        this.observ = observ;
        this.peso = peso;
        this.nasc = nasc;
        this.especie = especie;
        this.raca= raca;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return user_id;
    }
    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    public String getNomePet() {
        return nome_pet;
    }
    public void setNomePet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public String getObserv() {
        return observ;
    }
    public void setObserv(String observ) {
        this.observ = observ;
    }

    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getNasc() {
        return nasc;
    }
    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
}
