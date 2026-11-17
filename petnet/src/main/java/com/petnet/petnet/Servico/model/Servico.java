package com.petnet.petnet.Servico.model;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "servicos")
public class Servico {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "pedido_seq_generator"
    )
    @SequenceGenerator(
            name = "pedido_seq_generator",
            sequenceName = "pedido_seq",
            allocationSize = 1
    )
    @Column(name = "tipos_id")
    private Long tipos_id;

    @Column(name = "ped_id", nullable = false)
    private Long ped_id;

    public Servico() {
    }

    public Servico(Long tipos_id, Long ped_id){
        this.tipos_id = tipos_id;
        this.ped_id = ped_id;
    }

    public Long getId() {
        return tipos_id;
    }
    public void setId(Long tipos_id) {
        this.tipos_id = tipos_id;
    }

    public Long getPediId() {
        return ped_id;
    }
    public void setPediId(Long ped_id) {
        this.ped_id = ped_id;
    }
}
