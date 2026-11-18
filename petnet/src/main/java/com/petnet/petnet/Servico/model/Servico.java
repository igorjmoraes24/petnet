package com.petnet.petnet.Servico.model;

import com.petnet.petnet.Order.model.Order;
import jakarta.persistence.*;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ped_id", nullable = false)
    private Order order;

    @Column(name = "tipos_id")
    private Long tiposId;

    public Servico() {
    }

    public Servico(Long id, Order order, Long tiposId) {
        this.id = id;
        this.order = order;
        this.tiposId = tiposId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Long getTiposId() {
        return tiposId;
    }
    public void setTiposId(Long tiposId) {
        this.tiposId = tiposId;
    }
}