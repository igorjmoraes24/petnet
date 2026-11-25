package com.petnet.petnet.User.model;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class User implements UserDetails {

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

    @Column(name = "user_senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "user_telefone", nullable = false, unique = true, length = 11)
    private String phone;

    @Column(name = "user_endereco", nullable = false, length = 60)
    private String endereco;

    @Column(name = "user_datacri", nullable = false)
    private Date datacri;

    public User() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    // Construtor Completo
    public User(String nome, String email, String senha, String phone, String endereco, Date datacri) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.phone = phone;
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
        this.phone = phone;
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
