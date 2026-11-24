package com.petnet.petnet.Petshop.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pet_shops")
public class Petshop {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "shop_seq_generator"
    )
    @SequenceGenerator(
            name = "shop_seq_generator",
            sequenceName = "shop_seq",
            allocationSize = 1
    )
    @Column(name = "shop_id")
    private Long id;

    @Column(name = "shop_nome",nullable = false, length = 60)
    private String nome;

    @Column(name = "shop_cnpj",nullable = false, length = 14)
    private String cnpj;

    @Column(name= "shop_dono_id")
    private Long user_id;

    @Column(name= "shop_datacri")
    private Date datacri;

    @Column(name = "shop_telefone", length = 20)
    private String phone;

    @Column(name = "shop_avaliacao")
    private Double avali;

    public Petshop() {
    }

    public Petshop(Long id, String nome, String cnpj, Long user_id, Date datacri, String phone, Double avali) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.user_id = user_id;
        this.datacri = datacri;
        this.phone = phone;
        this.avali = avali;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDatacri() {
        return datacri;
    }
    public void setDatacri(Date datacri) {
        this.datacri = datacri;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getAvali() {
        return avali;
    }
    public void setAvali(Double avali) {
        this.avali = avali;
    }

}