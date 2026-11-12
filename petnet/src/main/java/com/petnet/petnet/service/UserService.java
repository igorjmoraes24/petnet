package com.petnet.petnet.service;

import com.petnet.petnet.model.User;
import com.petnet.petnet.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Injeção de Dependência via Construtor (Boa prática recomendada)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        return userRepository.save(user);
    }

        @Transactional
        public User updateUser(Long id, User dto) {
            User userExistente = buscarPorId(id);

            userExistente.setNome(dto.getNome());
            userExistente.setEmail(dto.getEmail());
            userExistente.setSenha(dto.getSenha());
            userExistente.setPhone(dto.getPhone());
            userExistente.setUserTipo(dto.getUserTipo());
            userExistente.setEndereco(dto.getEndereco());
            userExistente.setDatacri(dto.getDatacri());

            return userRepository.save(userExistente);
        }

    @Transactional
    public void deleteUser(Long id) {
        User user = buscarPorId(id);
        userRepository.delete(user);
    }
}
