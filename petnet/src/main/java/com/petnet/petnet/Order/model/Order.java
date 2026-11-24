package com.petnet.petnet.Order.model;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Order {
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
    @Column(name = "pedi_id")
    private Long id;

    @Column(name = "user_tutor_id", nullable = false)
    private Long user_id;

    @Column(name = "pet_id", nullable = false)
    private Long pet_id;

    @Column(name = "serv_id", nullable = false)
    private Long serv_id;

    public enum PediStatus {
        ABERTO,
        EM_ANDAMENTO,
        CONCLUIDO,
        CANCELADO
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "pedi_status", nullable = false)
    private Order.PediStatus status;

    @Column(name = "pedi_datacri", nullable = false)
    private Date datacri;

    public Order() {
    }

    public Order(Long user_id, Long pet_id, PediStatus status, Long tipo, String desc, Date datacri, Long serv_id){
        this.user_id = user_id;
        this.pet_id = pet_id;
        this.status = status;
        this.datacri = datacri;
        this.serv_id = serv_id;
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

    public Long getPetId() {
        return pet_id;
    }
    public void setPetId(Long pet_id) {
        this.pet_id = pet_id;
    }

    public PediStatus getPediStatus() {
        return status;
    }
    public void setPediStatus(PediStatus status) {
        this.status = status;
    }

    public Date getDatacri() {
        return datacri;
    }
    public void setDatacri(Date datacri) {
        this.datacri = datacri;
    }

    public Long getServ_id() {
        return serv_id;
    }
    public void setServ_id(Long serv_id) {
        this.serv_id = serv_id;
    }


}
