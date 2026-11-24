package com.petnet.petnet.Servico.model;

import com.petnet.petnet.Order.model.Order;
import jakarta.persistence.*;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "servico_seq_generator"
    )
    @SequenceGenerator(
            name = "servico_seq_generator",
            sequenceName = "servico_seq",
            allocationSize = 1
    )
    @Column(name = "serv_id")
    private Long id;

    @Column(name = "serv_nome", length = 200)
    private String serv_nome;

    public Servico() {
    }

    public Servico(Long id, String serv_nome) {
        this.id = id;
        this.serv_nome = serv_nome;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getServNome() { return serv_nome; }
    public void setServNome(String serv_nome) {this.serv_nome=serv_nome; }
}