package com.petnet.petnet.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "user_seq_generator"
    )
    @SequenceGenerator(
            name = "user_seq_generator",
            sequenceName = "user_seq",
            allocationSize = 1
    )
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "user_email", nullable = false, unique = true, length = 80)
    private String email;

    @Column(name = "user_senha", nullable = false, unique = true, length = 80)
    private String senha;

    @Column(name = "user_telefone", nullable = false, unique = true, length = 11)
    private String phone;

    public enum UserTipo {
        TUTOR,
        VETERINARIO,
        CLINICA
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "user_tipo", nullable = false, length = 20)
    private UserTipo userTipo;

    @Column(name = "user_endereco", nullable = false, length = 60)
    private String endereco;

    @Column(name = "user_datacri", nullable = false, length = 11)
    private Date datacri;

    // Construtor Padrão (Obrigatório para o JPA/Hibernate)
    public User() {
    }

    // Construtor Completo
    public User(String nome, String email, String senha, String phone, UserTipo userTipo, String endereco, Date datacri) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.phone = phone;
        this.userTipo = userTipo;
        this.endereco= endereco;
        this.datacri=datacri;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.email = email;
    }

    public UserTipo getUserTipo() {
        return userTipo;
    }
    public void setUserTipo(UserTipo userTipo) {
        this.userTipo = userTipo;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDatacri() {
        return datacri;
    }
    public void setDatacri(Date datacri) {
        this.datacri = datacri;
    }
}
