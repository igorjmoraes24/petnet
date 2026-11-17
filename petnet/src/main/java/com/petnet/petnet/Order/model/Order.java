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

    public enum PediStatus {
        ABERTO,
        EM_ANDAMENTO,
        ENCERRADO
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "pedi_status", nullable = false)
    private Order.PediStatus status;

    @Column(name = "pedi_tipo_servico", nullable = false)
    private Long tipo;

    @Column(name = "pedi_descricao_problema", nullable = false)
    private String desc;

    @Column(name = "pedi_datacri", nullable = false)
    private Date datacri;


    public Order() {
    }

    public Order(Long user_id, Long pet_id, PediStatus status, Long tipo, String desc, Date datacri){
        this.user_id = user_id;
        this.pet_id = pet_id;
        this.status = status;
        this.tipo = tipo;
        this.desc = desc;
        this.datacri = datacri;
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

    public Long getTipo() { return tipo; }
    public void setTipo(Long tipo) { this.tipo = tipo; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public Date getDatacri() {
        return datacri;
    }
    public void setDatacri(Date datacri) {
        this.datacri = datacri;
    }
}
