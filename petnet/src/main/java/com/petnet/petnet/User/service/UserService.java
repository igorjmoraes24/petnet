package com.petnet.petnet.User.service;

import com.petnet.petnet.User.model.User;
import com.petnet.petnet.User.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Injeção de Dependência via Construtor (Boa prática recomendada)
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    public User buscarPorId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID: " + id));
    }

    @Transactional
    public User salvar(User user) {
        // Regra de Negócio: Não permite cadastrar e-mails duplicados
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com este e-mail!");
        }
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        if (user.getDatacri() == null) {
            user.setDatacri(new java.util.Date());
        }
        return userRepository.save(user);
    }

        @Transactional
        public User updateUser(Long id, User dto) {
            User userExistente = buscarPorId(id);

            userExistente.setNome(dto.getNome());
            userExistente.setEmail(dto.getEmail());
            if (dto.getSenha() != null && !dto.getSenha().isBlank()) {
                userExistente.setSenha(passwordEncoder.encode(dto.getSenha()));
            }
            userExistente.setPhone(dto.getPhone());
            userExistente.setEndereco(dto.getEndereco());

            return userRepository.save(userExistente);
        }

    @Transactional
    public void deleteUser(Long id) {
        User user = buscarPorId(id);
        userRepository.delete(user);
    }
}
